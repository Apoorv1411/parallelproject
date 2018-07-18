package com.cg.wallet.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.wallet.beans.Account;

public class Walletdb {
	private static HashMap<String,Account> walletDb=new HashMap<String,Account>();
	public static HashMap<String, Account> getWalletMap() {
	return walletDb;
	}
	Account obj=new Account();
	static{

	walletDb.put("9876543210",new Account("9876543210","Himanshu","himanshu@gmail.com",2000.0,LocalDateTime.now()));
	walletDb.put("9988776655",new Account("9988776655","Sonu","sonu@gmail.com",1500.0,LocalDateTime.now()));
	walletDb.put("9876501234",new Account("9876501234","Shrey","shrey@gmail.com",1000.0,LocalDateTime.now()));
	walletDb.put("9746130258",new Account("9746130258","Nilanshu","nilanshu@gmail.com",2500.0,LocalDateTime.now()));
	}
}
