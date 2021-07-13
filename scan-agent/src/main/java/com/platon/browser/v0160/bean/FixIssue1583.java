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
        issue1583.setNodeId("0x104005f1bb2cefa6059be68d8f7b6dd0ed7b325688c88c6d03be8df471e5979b3d45157835cc2795566855392eb77274b61b3197f3dba129350cd2f61b6f9a0a");
        issue1583.setStakingBlockNumber(718L);
        issue1583.setRecoveredEpoch(216);
        issue1583.setTotalDelegationAmount(new BigInteger("5000000000000000000"));
        issue1583.setTotalDelegationRewardAmount(new BigInteger("2834054521573192732"));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1a78ls0s4zrw66dwmx0h6vu6lp2wffjn52ftfkk", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1tmdug9sv5kv06wu87yvhuedzat7mqwtk2runc9", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp1vtesk9c9eqq3aalajlnnvgxw7a86gq8dw423x9", new BigInteger("1000000000000000000")));
        issue1583.addRecoveredDelegation(new RecoveredDelegation("atp14hmsk2qne5ps3epf9jx8cyz94mkq00y4jlzvl8", new BigInteger("1000000000000000000")));
        list.add(issue1583);

        FixIssue1583 issue15832 = new FixIssue1583();
        issue15832.setNodeId("0x50b6d2f6490040ac0813d0aa0042d6020b0e537d5922805b00de7180bbdb29fca4877fdbf2d2dcd570b8ac9a904c02c69a60c9089239bfff04e0252886ef1158");
        issue15832.setStakingBlockNumber(722L);
        issue15832.setRecoveredEpoch(475);
        issue15832.setTotalDelegationAmount(new BigInteger("7000000000000000000"));
        issue15832.setTotalDelegationRewardAmount(new BigInteger("2834054521573192732"));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1m0qy0ylh7evjk2yfrezkmaylwz32c4n3ttqukp", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1nmy3lfpxk0r7rezr5hjdscqsulwjlfprmjundm", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp16a5f649vmwk3842jcwajrfqtjrsu5rlfxx8v2h", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp1xwew5ywq4lcy3tt4epay5dm8mx46cs5t389y7v", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp102rkam0m4ayasfe5awklaf3y367zedr6vc236c", new BigInteger("1000000000000000000")));
        issue15832.addRecoveredDelegation(new RecoveredDelegation("atp19nzzh4p3s87jf436hs2wmjjwta7k5yak2p98az", new BigInteger("1000000000000000000")));
        list.add(issue15832);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(FixIssue1583.getRecoveredDelegationInfo()));
    }
}
