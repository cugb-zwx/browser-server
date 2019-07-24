package com.platon.browser.filter;

import com.platon.browser.bean.PendingBean;
import com.platon.browser.client.PlatonClient;
import com.platon.browser.dao.entity.NodeRanking;
import com.platon.browser.dao.entity.PendingTx;
import com.platon.browser.dao.entity.PendingTxExample;
import com.platon.browser.dao.mapper.PendingTxMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.core.methods.response.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: dongqile
 * Date: 2019/1/9
 * Time: 17:08
 */
@Component
public class PendingFilter {
    private static Logger logger = LoggerFactory.getLogger(PendingFilter.class);
    @Autowired
    private PendingTxMapper pendingTxMapper;

    @Transactional
    public void analyse ( List <Transaction> transactions, String chainId, PlatonClient platon ) {
        try {
            List <PendingTx> pendingTxes = new ArrayList <>();
            transactions.forEach(initData -> {
                PendingBean bean = new PendingBean();
                bean.initData(initData);
                bean.setChainId(chainId);
                // 设置接收地址类型
                if (null != initData.getTo()) {
                    try {
                        EthGetCode ethGetCode = platon.getWeb3j(chainId).ethGetCode(initData.getTo(), DefaultBlockParameterName.LATEST).send();
                        if ("0x".equals(ethGetCode.getCode())) {
                            bean.setReceiveType("account");
                        } else {
                            bean.setReceiveType("contract");
                        }
                    } catch (IOException e) {
                        logger.error("platon.getWeb3j().ethGetCode() error:{}", e.getMessage());
                    }
                } else {
                    bean.setTo("0x0000000000000000000000000000000000000000");
                }
                pendingTxes.add(bean);
                logger.debug("PendingTx Synchronization is complete !!!...");
            });
            if (pendingTxes.size() > 0) {
                List<PendingTx> newList = new ArrayList <>();
                List <String> pendingHashList = new ArrayList <>();
                pendingTxes.forEach(pendingTx -> {
                    pendingHashList.add(pendingTx.getHash());
                });
                PendingTxExample pendingTxExample = new PendingTxExample();
                pendingTxExample.createCriteria().andChainIdEqualTo(chainId).andHashIn(pendingHashList);
                List <PendingTx> dbList = pendingTxMapper.selectByExample(pendingTxExample);
                if (dbList.size() > 0) {
                    Map <String, PendingTx> dbMap = new HashMap <>();
                    dbList.forEach(pendingTx -> {
                        dbMap.put(pendingTx.getHash(), pendingTx);
                    });
                    pendingTxes.forEach(pendingTx -> {
                        PendingTx tx = dbMap.get(pendingTx.getHash());
                        if (null == tx) {
                            newList.add(pendingTx);
                        }
                    });
                }
                if(newList.size() > 0){
                    pendingTxMapper.batchInsert(newList);
                }
            }
            logger.debug("PendingTxSynchronizeJob is null ,Synchronization is complete !!!...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}