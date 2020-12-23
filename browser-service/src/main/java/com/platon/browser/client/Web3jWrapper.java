package com.platon.browser.client;

import lombok.Builder;
import lombok.experimental.Accessors;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.Web3jService;

/**
 * @description:
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-16 15:24:09
 **/
@Builder
@Accessors(chain = true)
public class Web3jWrapper {
    private Web3j web3j;
    private Web3jService web3jService;
    private String address;
	public Web3j getWeb3j() {
		return web3j;
	}
	public void setWeb3j(Web3j web3j) {
		this.web3j = web3j;
	}
	public Web3jService getWeb3jService() {
		return web3jService;
	}
	public void setWeb3jService(Web3jService web3jService) {
		this.web3jService = web3jService;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
