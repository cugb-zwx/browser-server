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
        issue1583.setNodeId("0xf8f7b7ec03b6fd58334df4fd565a26024a1c5d64868880803f63c6c3b06d3dabd051c3251549ccf186c3d83afce12fa0a32c2188872aafa620b10bd337ea2a64");
        issue1583.setStakingBlockNumber(65L);
        issue1583.setRecoveredEpoch(216);
        issue1583.setTotalDelegationAmount(new BigInteger("5000000000000000000"));
        issue1583.setTotalDelegationRewardAmount(new BigInteger("207219251336898395721907"));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1evctymqxg8w53la3mqpc726kq0lqchzytwnmvm", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1gxl4cfearl3y2ducgckurkxvsmz3msjjmaqrhn", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp10he0qsx299tkqvrtmk5kj07nz5702hz4czcx2r", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp13nfkmjq3lzyykn3ah2a5q4f9yaw98hxqq942vc", new BigInteger("1000000000000000000")));
        list.add(issue1583);

        FixIssue1583 issue15832 = new FixIssue1583();
        issue15832.setNodeId("0x5801350aa672441894c753f41e5c7c52b2a4374e7902e52f4a8cacdc33cd1a6ca63bdb7ecda710b5a6500bfb53bb80bd046aba63fc326f11a0971b91bfb1225a");
        issue15832.setStakingBlockNumber(68L);
        issue15832.setRecoveredEpoch(475);
        issue15832.setTotalDelegationAmount(new BigInteger("7000000000000000000"));
        issue15832.setTotalDelegationRewardAmount(new BigInteger("173796791443850267379667"));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1xcwvc4a3tue68vdl3elsnemdztphl6az859y32", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1l257mw2674zk66s6xk5rg7cs6d3cwfld7su9r2", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp199qxhgq62cyesq8ffjuwpy75rndqhyhfyxmqtv", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1edv6889u0paxzvj0kwgzchktlwduu4m73xp24d", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1yanf79gl46gh7quan8thq572yd3wvuukhjxy8s", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp18nlw6pljswwdcjch9zy2c7r00uzdystcel3j4r", new BigInteger("1000000000000000000")));
        list.add(issue15832);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(FixIssue1583.getRecoveredDelegationInfo()));
    }
}
