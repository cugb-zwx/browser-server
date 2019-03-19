package com.platon.browser.dto.transaction;

import com.alibaba.fastjson.JSON;
import com.platon.browser.dao.entity.Transaction;
import com.platon.browser.dto.ticket.TxInfo;
import lombok.Data;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

/**
 * User: dongqile
 * Date: 2019/3/15
 * Time: 14:16
 */
@Data
public class VoteSummary {
    private String hash;
    private String locked;
    private String earnings;
    private String validNum;
    private String totalTicketNum;
    public void init( Transaction transaction){
        this.hash = transaction.getHash();
        TxInfo ticketTxInfo = JSON.parseObject(transaction.getTxInfo(), TxInfo.class);
        TxInfo.Parameter ticketParameter = ticketTxInfo.getParameters();
        if(ticketParameter!=null){
            BigDecimal ticketPrice= Convert.fromWei(ticketParameter.getPrice().toString(), Convert.Unit.ETHER);
            BigDecimal total = new BigDecimal(ticketParameter.getCount());
            BigDecimal sum = ticketPrice.multiply(total);
            this.totalTicketNum = ticketParameter.getCount().toString();
            this.locked = sum.toString();
        }
    }
}