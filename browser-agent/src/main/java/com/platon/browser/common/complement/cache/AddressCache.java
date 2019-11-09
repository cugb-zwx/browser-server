package com.platon.browser.common.complement.cache;

import com.platon.browser.common.enums.AddressTypeEnum;
import com.platon.browser.dao.entity.Address;
import com.platon.browser.elasticsearch.dto.Transaction;
import com.platon.browser.enums.ContractDescEnum;
import com.platon.browser.enums.InnerContractAddrEnum;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class AddressCache {
    private Map<String,Address> addressMap = new HashMap<String, Address>();
    
    public void update(Transaction tx) {
    	String from = tx.getFrom();
    	String to = tx.getTo();
    	updateAddress(tx,from);
    	updateAddress(tx,to);
    }
    
    public Collection<Address> getAll(){
    	return addressMap.values();
    }
    
    public void cleanAll() {
    	addressMap.clear();
    }
    
    private void updateAddress(Transaction tx, String addr) {
    	Address address = addressMap.get(addr);
    	if(address == null) {
    		address = createDefaultAddress(addr);
    		addressMap.put(addr, address);
    	}
    	
    	 switch (tx.getTypeEnum()){
	         case TRANSFER: // 转账交易
	        	 address.setTxQty(address.getTxQty() + 1);
	             break;
	         case STAKE_CREATE:// 创建验证人
	         case STAKE_INCREASE:// 增加自有质押
	         case STAKE_MODIFY:// 编辑验证人
	         case STAKE_EXIT:// 退出验证人
	         case REPORT:// 举报验证人
	        	 address.setStakingQty(address.getStakingQty()+1);
	             break;
	         case DELEGATE_CREATE:// 发起委托
	         case DELEGATE_EXIT:// 撤销委托
	        	 address.setDelegateQty(address.getDelegateQty()+1);
	             break;
	         case PROPOSAL_TEXT:// 创建文本提案
	         case PROPOSAL_UPGRADE:// 创建升级提案
	         case PROPOSAL_VOTE:// 提案投票
	         case PROPOSAL_CANCEL:// 取消提案
	         case VERSION_DECLARE:// 版本声明
	        	 address.setProposalQty(address.getProposalQty()+1); 
	             break;
	         default:
    	 }    	
    }
    
    private Address createDefaultAddress(String addr) {
    	Address address = new Address();
    	address.setAddress(addr);
        // 设置地址类型
        if(InnerContractAddrEnum.getAddresses().contains(addr)){
            // 内置合约地址
        	address.setType(AddressTypeEnum.INNER_CONTRACT.getCode());
        }else{
            // 主动发起交易的都认为是账户地址因为当前川陀版本无wasm
        	address.setType(AddressTypeEnum.ACCOUNT.getCode());
        }
        
        ContractDescEnum cde = ContractDescEnum.getMap().get(addr);
        if(cde!=null){
        	address.setContractName(cde.getContractName());
        	address.setContractCreate(cde.getCreator());
        	address.setContractCreatehash(cde.getContractHash());
        } else {
        	address.setContractName("");
        	address.setContractCreate("");
        	address.setContractCreatehash("");
		}    	
    	
        address.setTxQty(0);
        address.setTransferQty(0);
        address.setStakingQty(0);
        address.setDelegateQty(0);
        address.setProposalQty(0);
    	return address;
    }
}