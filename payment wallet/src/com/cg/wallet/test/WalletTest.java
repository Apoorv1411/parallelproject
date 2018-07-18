package com.cg.wallet.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.beans.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class WalletTest {
	private IWalletService service;

	@Before
	public void init() {
	service = new WalletServiceImpl();
	}

	@Test
	public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setMobileNo("4661");
	ac.setName("Abhishek");
	ac.setEmail("abhishek@gmail.com");
	ac.setBalance(400.0);
	try {
	service.createAccount(ac);
	} catch (WalletException e) {
	Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("anivarsh");
	ac.setEmail("anivarsh@gmail.com");
	ac.setBalance(700.0);
	try {
	service.createAccount(ac);
	} catch (WalletException e) {
	Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("");
	ac.setEmail("shiva@gmail.com");
	ac.setBalance(300.0);
	try {
	service.createAccount(ac);
	} catch (WalletException e) {
	Assert.assertEquals("Name cannot be empty", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForEmailId() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Vishwajeet");
	ac.setEmail("vishwajeet@@46gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (WalletException e) {
	Assert.assertEquals("Enter valid emailid", e.getMessage());
	}
	}

	

	@Test
	public void testCreateAccount() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Tanutra");
	ac.setEmail("tanutra@gmail.com");
	ac.setBalance(600.0);

	try {
	String s=service.createAccount(ac);
	Assert.assertNotNull(s);
	} catch (WalletException e) {
	//System.out.println(e.getMessage());

	}

	}

	@Test
	public void testShowBalanceForMobileNo() {
	
	try {
	service.showBalance("975646");
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}


	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
	
	try {
	service.showBalance("9565257633");
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}

	
	@Test
	public void testShowBalanceForName() {
	Account ac=new Account();
	ac.setMobileNo("9565257633");
	try {
	service.showBalance(ac.getMobileNo());
	assertEquals("Shubham", ac.getName());
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}

	@Test
	public void testDepositForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("94567248879");
	try {
	service.deposit(ac.getMobileNo(), 230);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testDepositForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("9505934512");
	try {
	service.deposit(ac.getMobileNo(), 230);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setMobileNo("9876543210");
	try {
	service.deposit(ac.getMobileNo(), -360);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
	}

	@Test
	public void testDeposit() {
	Account ac=new Account();
	ac.setMobileNo("9876543210");
	try {
	Account ac1=service.deposit(ac.getMobileNo(), 360);
	assertNotNull(ac1);
	} catch (WalletException e) {

	System.out.println(e.getMessage());
	}
	}

	@Test
	public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("99887766");
	try {
	service.withdraw(ac.getMobileNo(), 330);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("9505934512");
	try {
	service.withdraw(ac.getMobileNo(), 230);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForAmt() {
	Account ac=new Account();
	ac.setMobileNo("9876543210");
	try {
	service.withdraw(ac.getMobileNo(), -400);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
	}


	@Test
	public void testFundTransferForMobileNo() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("98765432");
	ac2.setMobileNo("1234");
	try {
	service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 600);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForMobileNoDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9123456789");
	ac2.setMobileNo("9445646721");
	try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),230);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForAmt() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9876543210");
	ac2.setMobileNo("9889898989");
	try {
	service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), -560);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
	}
	@Test
	public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9876543210");
	ac2.setMobileNo("9889889898");
	try {
	assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(), 420));
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	}
	}
	@Test
	public void testPrinttransactionDetails() {
	Account ac=new Account();
	ac.setMobileNo("9988776655");
	try {
	Account acc=service.printTransactionDetails(ac.getMobileNo());
	assertNotNull(acc);
	} catch (WalletException e) {
	System.out.println(e.getMessage());
	}

	}
	
	@Test
	public void testPrinttransactionDetailsForIncorrectMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("98492285");
	try {
	Account acc=service.printTransactionDetails(ac.getMobileNo());
	assertNotNull(acc);
	} catch (WalletException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
			 
	} 
	@Test
	public void testPrinttransactionDetailsForMObileNoDoesExistInDb() {
	Account ac=new Account();
	ac.setMobileNo("9875486310");
	try {
	Account acc=service.printTransactionDetails(ac.getMobileNo());
	assertNotNull(acc);
	} catch (WalletException e) {
		assertEquals("The mobile number does not exist",e.getMessage());
	}
			 
	}  
	@Test
	public void testWithDrawForMobileNoInDb() {
	Account acc=new Account();
	acc.setMobileNo("944167487");
	try {
	service.withdraw(acc.getMobileNo(), 600);
	} catch (WalletException e) {
	// TODO Auto-generated catch block
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}  


	}
	


