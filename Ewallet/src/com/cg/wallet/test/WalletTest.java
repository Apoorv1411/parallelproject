package com.cg.wallet.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletTest {
private IWalletService service;

@Before
public void init() {
service = new WalletServiceImpl();
}

@Test
public void testCreateAccountForMobile() {
Account ac = new Account();
ac.setMobileNo("4587");
ac.setName("John");
ac.setEmail("john@gmail.com");
ac.setBalance(150.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
}
}
@Test
public void testCreateAccountForName() {
Account ac = new Account();
ac.setMobileNo("9564156871");
ac.setName("Padhu");
ac.setEmail("padhu@gmail.com");
ac.setBalance(400.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
}
}
@Test
public void testCreateAccountForNameIsEmpty() {
Account ac = new Account();
ac.setMobileNo("9790518161");
ac.setName("");
ac.setEmail("ajith@gmail.com");
ac.setBalance(200.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Name cannot be empty", e.getMessage());
}
}
@Test
public void testCreateAccountForEmailId() {
Account ac = new Account();
ac.setMobileNo("9898989898");
ac.setName("ajithP");
ac.setEmail("ajith@@gggmail.com");
ac.setBalance(200.0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Enter valid emailid", e.getMessage());
}
}
/*@Test
public void testCreateAccountForBalance() {
Account ac = new Account();
ac.setMobileNo("9898989898");
ac.setName("ajith");
ac.setEmail("ajith@gmail.com");
ac.setBalance(0);
try {
service.createAccount(ac);
} catch (WalletException e) {
Assert.assertEquals("Balance should be greater than zero", e.getMessage());
}
}*/
@Test
public void testCreateAccount() {
Account ac = new Account();
ac.setMobileNo("9898989898");
ac.setName("ajith");
ac.setEmail("ajith@gmail.com");
ac.setBalance(200.0);
try {
String s=service.createAccount(ac);
Assert.assertNotNull(s);
} catch (WalletException e) {
//System.out.println(e.getMessage());
}
}
@Test
public void testShowBalanceForMobileNo() {
/*Account ac=new Account();
ac.setMobileNo("98989898");*/
try {
service.showBalance("98056");
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}

@Test
public void testShowBalanceForMobileNoDoesNotExist() {
/*Account ac=new Account();
ac.setMobileNo("95059");*/
try {
service.showBalance("9500167683");
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
/*public void testShowBalanceForMobileNoExist() {
Account ac=new Account();
ac.setMobileNo("9500167683");
try {
assertSame((2000.0, service.showBalance(ac.getMobileNo())));
} catch (WalletException e) {
// TODO Auto-generated catch block
System.out.println(e.getMessage());
}
}
*/
@Test
public void testShowBalanceForName() {
Account ac=new Account();
ac.setMobileNo("9790518161");
try {
service.showBalance(ac.getMobileNo());
assertEquals("Ajith", ac.getName());
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testDepositForMobileNo() {
Account ac=new Account();
ac.setMobileNo("95625486");
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
ac.setMobileNo("9176545054");
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
ac.setMobileNo("9500167683");
try {
service.deposit(ac.getMobileNo(), -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
}
}
@Test
public void testDeposit() {
Account ac=new Account();
ac.setMobileNo("9500167683");
try {
Account ac1=service.deposit(ac.getMobileNo(), 230);
assertNotNull(ac1);
} catch (WalletException e) {
System.out.println(e.getMessage());
}
}
@Test
public void testWithDrawForMobileNo() {
Account ac=new Account();
ac.setMobileNo("9654287");
try {
service.withdraw(ac.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testWithdrawForMobileNoDoesNotExist() {
Account ac=new Account();
ac.setMobileNo("9500167689");
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
ac.setMobileNo("9500167683");
try {
service.withdraw(ac.getMobileNo(), -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}

@Test
public void testFundTransferForMobileNo() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("968459");
ac2.setMobileNo("5698");
try {
service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
@Test
public void testFundTransferForMobileNoDoesNotExist() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9500167683");
ac2.setMobileNo("9790518161");
try {
service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The mobile number does not exist",e.getMessage());
}
}
@Test
public void testFundTransferForAmt() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("7397406265");
ac2.setMobileNo("9884290501");
try {
service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
} catch (WalletException e) {
// TODO Auto-generated catch block
Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
}
}
@Test
public void testFundTransfer() {
Account ac=new Account();
Account ac2=new Account();
ac.setMobileNo("9500167683");
ac2.setMobileNo("9790518161");
try {
assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
} catch (WalletException e) {
// TODO Auto-generated catch block
System.out.println(e.getMessage());
}
}
@Test
public void testPrinttransactionDetails() {
Account ac=new Account();
ac.setMobileNo("9790518161");
try {
Account acc=service.printTransactionDetails(ac.getMobileNo());
assertNotNull(acc);
} catch (WalletException e) {
System.out.println(e.getMessage());
}
}

}
