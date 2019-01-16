package com.platon.browser.dto.node;

import com.platon.browser.dao.entity.NodeRanking;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class NodeDetail {
    private Long id;
    private String address;
    private String name;
    private String logo;
    private Integer electionStatus;
    private String location;
    private Long joinTime;
    private String deposit;
    private Double rewardRatio;
    private Integer ranking;
    private String profitAmount;
    private Integer verifyCount;
    private Long blockCount;
    private Double avgBlockTime;
    private String rewardAmount;
    private String nodeUrl;
    private String publicKey;
    private String wallet;
    private String intro;
    private String orgName;
    private String orgWebsite;

    public void init(NodeRanking initData) {
        BeanUtils.copyProperties(initData,this);
        this.setJoinTime(initData.getJoinTime().getTime());
        this.setNodeUrl("http://"+initData.getIp()+":"+initData.getPort());
        // 公钥就是节点ID
        this.setPublicKey(initData.getNodeId());
        // 钱包就是address
        this.setWallet(initData.getAddress());
        this.setLogo(initData.getUrl());
    }
}