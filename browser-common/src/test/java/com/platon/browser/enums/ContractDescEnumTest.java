package com.platon.browser.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContractDescEnumTest {

	@Test
	public void testContractDescEnum() {
		ContractDescEnum enumm = ContractDescEnum.INCENTIVE_POOL_CONTRACT;
		assertNotNull(enumm);
	}

	@Test
	public void testGetAddress() {
		ContractDescEnum enumm = ContractDescEnum.INCENTIVE_POOL_CONTRACT;
		assertNotNull(enumm.getAddress());
	}

	@Test
	public void testGetContractName() {
		ContractDescEnum enumm = ContractDescEnum.INCENTIVE_POOL_CONTRACT;
		assertNotNull(enumm.getContractName());
	}

	@Test
	public void testGetCreator() {
		ContractDescEnum enumm = ContractDescEnum.INCENTIVE_POOL_CONTRACT;
		assertNotNull(enumm.getCreator());
	}

	@Test
	public void testGetContractHash() {
		ContractDescEnum enumm = ContractDescEnum.INCENTIVE_POOL_CONTRACT;
		assertNotNull(enumm.getContractHash());
	}

}
