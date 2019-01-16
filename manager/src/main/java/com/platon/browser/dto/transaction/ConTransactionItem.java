package com.platon.browser.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 合约详情中的交易列表Bean
 */
@Data
public class ConTransactionItem {
    private String txHash;
    private long blockTime;
    private String from;
    private String to;
    private String value;
    private String actualTxCost;
    private int txReceiptStatus;
    private String txType;
    private long serverTime;
    private String failReason;

    @JsonIgnore
    private Date createTime;
}