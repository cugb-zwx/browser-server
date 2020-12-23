package com.platon.browser.complement.converter.stake;

import com.platon.browser.AgentTestBase;
import com.platon.browser.common.collection.dto.EpochMessage;
import com.platon.browser.common.complement.cache.NetworkStatCache;
import com.platon.browser.common.complement.cache.NodeCache;
import com.platon.browser.common.complement.cache.bean.NodeItem;
import com.platon.browser.common.queue.collection.event.CollectionEvent;
import com.platon.browser.complement.dao.mapper.StakeBusinessMapper;
import com.platon.browser.elasticsearch.dto.Transaction;
import com.platon.browser.service.govern.ParameterService;
import com.platon.browser.service.misc.StakeMiscService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * @Auther: dongqile
 * @Date: 2019/11/13
 * @Description: 创建验证人(质押)转化器测试类
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class StakeCreateConverterTest extends AgentTestBase {

    @Mock
    private StakeBusinessMapper stakeBusinessMapper;
    @Mock
    private NetworkStatCache networkStatCache;
    @Mock
    private NodeCache nodeCache;
    @Mock
    private CollectionEvent collectionEvent;
    @Mock
    private ParameterService parameterService;
    @Mock
    private StakeMiscService stakeMiscService;
    @InjectMocks
    @Spy
    private StakeCreateConverter target;

    @Before
    public void setup()throws Exception{
        NodeItem nodeItem = NodeItem.builder()
                .nodeId("0xbfc9d6578bab4e510755575e47b7d137fcf0ad0bcf10ed4d023640dfb41b197b9f0d8014e47ecbe4d51f15db514009cbda109ebcf0b7afe06600d6d423bb7fbf")
                .nodeName("zrj-node1")
                .stakingBlockNum(new BigInteger("20483"))
                .build();
        when(networkStatCache.getAndIncrementNodeOptSeq()).thenReturn(1L);
        when(nodeCache.getNode(any())).thenReturn(nodeItem);
        when(parameterService.getValueInBlockChainConfig(any())).thenReturn("5");
        when(stakeMiscService.getUnStakeFreeDuration()).thenReturn(BigInteger.TEN);
        when(stakeMiscService.getUnStakeEndBlock(anyString(),any(BigInteger.class),anyBoolean())).thenReturn(BigInteger.TEN);
    }


    @Test
    public void convert(){
        Transaction tx = new Transaction();
        for (Transaction transaction : transactionList){
            if(transaction.getTypeEnum().equals(Transaction.TypeEnum.STAKE_CREATE))
                tx=transaction;
        }
        EpochMessage epochMessage = EpochMessage.newInstance();
        epochMessage.setSettleEpochRound(new BigInteger("13"));
        CollectionEvent collectionEvent = new CollectionEvent();
        collectionEvent.setEpochMessage(epochMessage);
        target.convert(collectionEvent,tx);
    }
}