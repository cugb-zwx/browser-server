package com.platon.browser.task;

import com.platon.browser.AgentTestBase;
import com.platon.browser.common.enums.AppStatus;
import com.platon.browser.common.utils.AppStatusUtil;
import com.platon.browser.complement.dao.mapper.StatisticBusinessMapper;
import com.platon.browser.dao.mapper.AddressMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @description:
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-13 17:13:04
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class AddressUpdateTaskTest extends AgentTestBase {
    @Mock
    private StatisticBusinessMapper statisticBusinessMapper;
    @Mock
    private AddressMapper addressMapper;
    @InjectMocks
    @Spy
    private AddressUpdateTask target;

    @Before
    public void setup() throws Exception {
        when(addressMapper.selectByExample(any())).thenReturn(new ArrayList<>(addressList));
        when(statisticBusinessMapper.getAddressStatisticsFromStaking(any())).thenReturn(Collections.emptyList());
        when(statisticBusinessMapper.getAddressStatisticsFromDelegation(any())).thenReturn(Collections.emptyList());
    }

    @Test
    public void test(){
        AppStatusUtil.setStatus(AppStatus.RUNNING);
        target.batchUpdate(4,55);
        //verify(target, times(1)).batchUpdate(any(),any());
    }
}
