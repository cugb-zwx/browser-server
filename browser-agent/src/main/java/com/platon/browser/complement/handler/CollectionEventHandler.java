package com.platon.browser.complement.handler;

import com.platon.browser.common.complement.cache.NetworkStatCache;
import com.platon.browser.common.queue.collection.event.CollectionEvent;
import com.platon.browser.common.queue.collection.handler.ICollectionEventHandler;
import com.platon.browser.common.queue.complement.publisher.ComplementEventPublisher;
import com.platon.browser.complement.service.param.BlockParameterService;
import com.platon.browser.complement.service.param.StatisticParameterService;
import com.platon.browser.complement.service.param.TransactionParameterService;
import com.platon.browser.dao.entity.NOptBak;
import com.platon.browser.dao.entity.TxBak;
import com.platon.browser.dao.mapper.NOptBakMapper;
import com.platon.browser.dao.mapper.TxBakMapper;
import com.platon.browser.elasticsearch.dto.NodeOpt;
import com.platon.browser.elasticsearch.dto.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 区块事件处理器
 */
@Slf4j
public class CollectionEventHandler implements ICollectionEventHandler {

    @Autowired
    private TransactionParameterService transactionParameterService;
    @Autowired
    private BlockParameterService blockParameterService;
    @Autowired
    private StatisticParameterService statisticParameterService;
    @Autowired
    private ComplementEventPublisher complementEventPublisher;
    @Autowired
    private NetworkStatCache networkStatCache;
    @Autowired
    private NOptBakMapper nOptBakMapper;
    @Autowired
    private TxBakMapper txBakMapper;

    // 交易序号id
    private long transactionId = 0;

    private Long preBlockNum=0L;
    @Transactional
    public void onEvent(CollectionEvent event, long sequence, boolean endOfBatch) throws Exception {
        long startTime = System.currentTimeMillis();

        log.debug("CollectionEvent处理:{}(event(block({}),transactions({})),sequence({}),endOfBatch({}))",
                Thread.currentThread().getStackTrace()[1].getMethodName(),event.getBlock().getNum(),event.getTransactions().size(),sequence,endOfBatch);
        if(preBlockNum!=0L&&(event.getBlock().getNum()-preBlockNum!=1)) throw new AssertionError();

        // 使用已入库的交易数量初始化交易ID初始值
        if(transactionId==0) transactionId=networkStatCache.getNetworkStat().getTxQty();
        try {
            List<Transaction> transactions = event.getTransactions();
            // 确保交易从小到大的索引顺序
            transactions.sort(Comparator.comparing(Transaction::getIndex));
            for (Transaction tx:transactions) tx.setId(++transactionId);

            // 根据区块号解析出业务参数
            List<NodeOpt> nodeOpts1 = blockParameterService.getParameters(event);
            // 根据交易解析出业务参数
            List<NodeOpt> nodeOpts2 = transactionParameterService.getParameters(event);
            // 统计业务参数
            statisticParameterService.getParameters(event);
          
            nodeOpts1.addAll(nodeOpts2);

            complementEventPublisher.publish(event.getBlock(),transactions,nodeOpts1);

            // 交易入库mysql
            if(!transactions.isEmpty()){
                List<TxBak> baks = new ArrayList<>();
                transactions.forEach(tx->{
                    TxBak bak = new TxBak();
                    BeanUtils.copyProperties(tx,bak);
                    baks.add(bak);
                });
                txBakMapper.batchInsert(baks);
            }

            // 操作日志入库mysql
            if(!nodeOpts1.isEmpty()){
                List<NOptBak> baks = new ArrayList<>();
                nodeOpts1.forEach(no->{
                    NOptBak bak = new NOptBak();
                    BeanUtils.copyProperties(no,bak);
                    baks.add(bak);
                });
                nOptBakMapper.batchInsert(baks);
            }

            preBlockNum=event.getBlock().getNum();
        }catch (Exception e){
            log.error("",e);
            throw e;
        }

        log.debug("处理耗时:{} ms",System.currentTimeMillis()-startTime);
    }
}