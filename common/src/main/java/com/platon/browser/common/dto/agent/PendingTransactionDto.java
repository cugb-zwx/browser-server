package com.platon.browser.common.dto.agent;

/**
 * User: dongqile
 * Date: 2018/10/24
 * Time: 17:15
 */
public class PendingTransactionDto {

    /**
     * 交易hash
     */
    private String hash;


    /**
     * 交易时间（单位：秒）
     */
    private long timestamp;

    /**
     * 交易发起方地址
     */
    private String from;

    /**
     * 交易接收方地址
     */
    private String to;

    /**
     * 交易金额
     */
    private String value;

    /**
     * 能量限制
     */
    private Integer energonLimit;

    /**
     * 交易类型
     transfer ：转账
     MPCtransaction ： MPC交易
     contractCreate ： 合约创建
     vote ： 投票
     transactionExecute ： 合约执行
     authorization ： 权限
     */
    private String txType;

    /**
     * Nonce值
     */
    private String nonce;

    /**
     * 交易输入数据
     */
    private String input;

    public String getHash () {
        return hash;
    }

    public void setHash ( String hash ) {
        this.hash = hash;
    }

    public long getTimestamp () {
        return timestamp;
    }

    public void setTimestamp ( long timestamp ) {
        this.timestamp = timestamp;
    }

    public String getFrom () {
        return from;
    }

    public void setFrom ( String from ) {
        this.from = from;
    }

    public String getTo () {
        return to;
    }

    public void setTo ( String to ) {
        this.to = to;
    }

    public String getValue () {
        return value;
    }

    public void setValue ( String value ) {
        this.value = value;
    }

    public Integer getEnergonLimit () {
        return energonLimit;
    }

    public void setEnergonLimit ( Integer energonLimit ) {
        this.energonLimit = energonLimit;
    }

    public String getTxType () {
        return txType;
    }

    public void setTxType ( String txType ) {
        this.txType = txType;
    }

    public String getNonce () {
        return nonce;
    }

    public void setNonce ( String nonce ) {
        this.nonce = nonce;
    }

    public String getInput () {
        return input;
    }

    public void setInput ( String input ) {
        this.input = input;
    }
}