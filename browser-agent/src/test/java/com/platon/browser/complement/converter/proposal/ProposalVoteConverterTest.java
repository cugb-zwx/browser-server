package com.platon.browser.complement.converter.proposal;

import com.platon.browser.AgentTestBase;
import com.platon.browser.common.collection.dto.CollectionTransaction;
import com.platon.browser.common.complement.cache.NetworkStatCache;
import com.platon.browser.common.complement.cache.NodeCache;
import com.platon.browser.common.complement.cache.bean.NodeItem;
import com.platon.browser.common.queue.collection.event.CollectionEvent;
import com.platon.browser.complement.dao.mapper.ProposalBusinessMapper;
import com.platon.browser.dao.mapper.ProposalMapper;
import com.platon.browser.elasticsearch.dto.Block;
import com.platon.browser.elasticsearch.dto.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @description: 委托参数转换器测试类
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-04 17:58:27
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProposalVoteConverterTest extends AgentTestBase {

    @Mock
    private ProposalBusinessMapper proposalBusinessMapper;
    @Mock
    private NetworkStatCache networkStatCache;
    @Mock
    private ProposalMapper proposalMapper;
    @Mock
    private NodeCache nodeCache;
    @InjectMocks
    @Spy
    private ProposalVoteConverter target;

    @Before
    public void setup() throws Exception {
        NodeItem nodeItem = NodeItem.builder()
                .nodeId("0x77fffc999d9f9403b65009f1eb27bae65774e2d8ea36f7b20a89f82642a5067557430e6edfe5320bb81c3666a19cf4a5172d6533117d7ebcd0f2c82055499050")
                .nodeName("integration-node1")
                .stakingBlockNum(new BigInteger("88602"))
                .build();
        when(nodeCache.getNode(anyString())).thenReturn(nodeItem);
        when(proposalMapper.selectByPrimaryKey(anyString())).thenReturn(proposalList.get(0));
        when(networkStatCache.getAndIncrementNodeOptSeq()).thenReturn(1l);
    }

    @Test
    public void convert() {
        Block block = blockList.get(0);
        CollectionEvent collectionEvent = new CollectionEvent();
        collectionEvent.setBlock(block);
        Transaction tx = new Transaction();
        for (CollectionTransaction collectionTransaction : transactionList) {
            if (collectionTransaction.getTypeEnum().equals(Transaction.TypeEnum.PROPOSAL_VOTE)) {
                tx = collectionTransaction;
            }
        }
        tx.setStatus(Transaction.StatusEnum.FAILURE.getCode());
        target.convert(collectionEvent, tx);
        tx.setStatus(Transaction.StatusEnum.SUCCESS.getCode());
        target.convert(collectionEvent, tx);
        assertTrue(true);
    }
}
