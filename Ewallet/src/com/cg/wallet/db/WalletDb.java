package com.cg.wallet.db;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;



import com.cg.wallet.bean.Account;

public class WalletDb {
private static HashMap<String,Account> walletDb=new HashMap<String,Account>();
public static HashMap<String, Account> getWalletMap() {
return walletDb;
}
Account obj=new Account();
static{
walletDb.put("9790518161",new Account("9790518161","Ajith","ajith@gmail.com",2000.0,LocalDateTime.now()));
walletDb.put("9500167683",new Account("9500167683","Banu","banu@gmail.com",1000.0,LocalDateTime.now()));
walletDb.put("7397406265",new Account("7397406265","Nandhu","nandhu@gmail.com",1500.0,LocalDateTime.now()));
walletDb.put("9884290501",new Account("9884290501","Giri","giri@gmail.com",2000.0,LocalDateTime.now()));
}
}
