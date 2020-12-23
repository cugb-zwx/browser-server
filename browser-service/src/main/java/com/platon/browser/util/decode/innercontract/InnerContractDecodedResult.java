package com.platon.browser.util.decode.innercontract;

import com.platon.browser.elasticsearch.dto.Transaction;
import com.platon.browser.param.OthersTxParam;
import com.platon.browser.param.TxParam;

/**
 * @description: 解码后的结果
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-04 20:38:57
 **/
public class InnerContractDecodedResult {
    private TxParam param= new OthersTxParam();
    private Transaction.TypeEnum typeEnum= Transaction.TypeEnum.OTHERS;

    public TxParam getParam() {
        return param;
    }

    public InnerContractDecodedResult setParam(TxParam param) {
        this.param = param;
        return this;
    }

    public Transaction.TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public InnerContractDecodedResult setTypeEnum(Transaction.TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
        return this;
    }
}
