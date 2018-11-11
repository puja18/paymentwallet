package com.cg.paymentwallet.util;

import java.math.BigInteger;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.WalletBean;

public class DataBase {
	private static ArrayList<WalletBean> list = new ArrayList<>();
	//private static ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();

	private static ArrayList<String> printList = new ArrayList<String>();
	
	public static ArrayList<WalletBean> getAccountList() {
		WalletBean bean = new WalletBean();
		bean.setFirstName("puja");
		bean.setLastName("devi");
		bean.setAddress("Vijayawada");
		bean.setBalance(1500.00);
		bean.setMailId("pujadavi18@gmail.com");
		bean.setPhoneNum(new BigInteger("6302088199"));
		list.add(bean);
		WalletBean bean1 = new WalletBean();
		bean1.setFirstName("sai");
		bean1.setLastName("bhargavi");
		bean1.setAddress("Bhimavaram");
		bean1.setBalance(1000.00);
		bean1.setMailId("sai32@gmail.com");
		bean1.setPhoneNum(new BigInteger("9550608053"));
		list.add(bean1);
		return list;
		
		
	}


}
