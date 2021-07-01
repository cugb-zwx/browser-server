package com.platon.browser.v0160.bean;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FixIssue1583 {
    private String nodeId;
    private Long stakingBlockNumber;
    private Integer RecoveredEpoch;
    private BigInteger totalDelegationAmount;
    private BigInteger totalDelegationRewardAmount;
    private List<RecoveredDelegation> recoveredDelegationList;

    public void addRecoveredDelegation(RecoveredDelegation recoveredDelegation) {
        if (recoveredDelegationList == null) {
            recoveredDelegationList = new ArrayList<>();
        }
        recoveredDelegationList.add(recoveredDelegation);
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Long getStakingBlockNumber() {
        return stakingBlockNumber;
    }

    public void setStakingBlockNumber(Long stakingBlockNumber) {
        this.stakingBlockNumber = stakingBlockNumber;
    }

    public Integer getRecoveredEpoch() {
        return RecoveredEpoch;
    }

    public void setRecoveredEpoch(Integer recoveredEpoch) {
        RecoveredEpoch = recoveredEpoch;
    }

    public BigInteger getTotalDelegationAmount() {
        return totalDelegationAmount;
    }

    public void setTotalDelegationAmount(BigInteger totalDelegationAmount) {
        this.totalDelegationAmount = totalDelegationAmount;
    }

    public BigInteger getTotalDelegationRewardAmount() {
        return totalDelegationRewardAmount;
    }

    public void setTotalDelegationRewardAmount(BigInteger totalDelegationRewardAmount) {
        this.totalDelegationRewardAmount = totalDelegationRewardAmount;
    }

    public List<RecoveredDelegation> getRecoveredDelegationList() {
        return recoveredDelegationList;
    }

    public void setRecoveredDelegationList(List<RecoveredDelegation> recoveredDelegationList) {
        this.recoveredDelegationList = recoveredDelegationList;
    }
/**
 * 获取
 *
 * @return:
 * @date: 2021/6/25
 */
    public static List<FixIssue1583> getRecoveredDelegationInfo() {
        List<FixIssue1583> list = new ArrayList<>();

        FixIssue1583 issue1583 = new FixIssue1583();
        issue1583.setNodeId("0xaef93e9cb7c4488de216f8ed12cad9ddecfd2150ae4cc6a5045ba286ce26276910cf8c6e4df633c2964160cc3bca8015cff2c55a41294e979767d5b0effb48b0");
        issue1583.setStakingBlockNumber(22L);
        issue1583.setRecoveredEpoch(216);
        issue1583.setTotalDelegationAmount(new BigInteger("3000000000000000000"));
        issue1583.setTotalDelegationRewardAmount(new BigInteger("2072192513368983957211"));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1g004udw6gy2z2vc4t5d7a77qdrlx3nk07ce9fv", new BigInteger("1000000000000000000")));
        list.add(issue1583);

        FixIssue1583 issue15832 = new FixIssue1583();
        issue15832.setNodeId("0x13915ba5e9f988d1438aab6b66828887c2445f746af799a679a153c2b7704e10d24500ba600ec53c259a859aa3544d1a225f26d38e0ab6f1b58db2847fe3a93b");
        issue15832.setStakingBlockNumber(42L);
        issue15832.setRecoveredEpoch(475);
        issue15832.setTotalDelegationAmount(new BigInteger("8000000000000000000"));
        issue15832.setTotalDelegationRewardAmount(new BigInteger("1069518716577540106951"));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1zc3k2zd7j72d3h045h43hgzgy8wsvan2lnpegt", new BigInteger("2000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp13t9ml06m5q5p6yl277xagwhl734zhl2dteywzw", new BigInteger("2000000000000000000")));
        list.add(issue15832);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(FixIssue1583.getRecoveredDelegationInfo()));
    }
}
