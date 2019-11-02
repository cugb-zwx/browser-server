package com.platon.browser.common.enums;

/**
 * 业务类型：
 * 质押：创建、增持、减持、退出
 * 委托：委托、撤销
 * 提案：文本、版本、升级、投票
 * 处罚：低出块率、双签
 */
public enum BusinessType {
    STAKE_CREATE,STAKE_INCREASE,STAKE_REDUCTION,STAKE_EXIT,
    DELEGATE_CREATE,DELEGATE_REDUCE,
    PROPOSAL_TEXT,PROPOSAL_VERSION,PROPOSAL_UPGRADE,PROPOSAL_VOTE,
    SLASH_LOW_RATE,SLASH_MULTI_SIGN
}