package com.platon.browser.service;

import com.platon.browser.dao.entity.PendingTx;
import com.platon.browser.dao.entity.TransactionWithBLOBs;
import com.platon.browser.dto.transaction.PendingTxDetail;
import com.platon.browser.dto.transaction.PendingTxItem;
import com.platon.browser.req.account.AccountDetailReq;
import com.platon.browser.req.account.ContractDetailReq;
import com.platon.browser.req.transaction.PendingTxDetailReq;
import com.platon.browser.req.transaction.PendingTxListReq;

import java.util.List;

public interface PendingTxService {
    List<PendingTxItem> getTransactionList(PendingTxListReq req);
    PendingTxDetail getTransactionDetail(PendingTxDetailReq req);

    /**
     * 通过账户信息获取待处理交易列表
     * @param req
     * @return
     */
    List<PendingTx> getTransactionList(AccountDetailReq req);

    List<PendingTx> getContractList(ContractDetailReq req);
}
