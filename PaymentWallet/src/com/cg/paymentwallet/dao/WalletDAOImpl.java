package com.cg.paymentwallet.dao;

import java.awt.List;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.DepositBean;
import com.cg.paymentwallet.bean.FundTransferBean;
import com.cg.paymentwallet.bean.WalletBean;
import com.cg.paymentwallet.bean.WithdrawBean;

public class WalletDAOImpl implements IWalletDAO {
	private static ArrayList<WalletBean> list = new ArrayList<>();
	private static ArrayList<String> printList = new ArrayList<>();
	WalletBean bean = new WalletBean();

	@Override
	public boolean createAccount(WalletBean bean) {
		// TODO Auto-generated method stub
		return list.add(bean) ;
	}

	@Override
	public double showBalance(BigInteger phoneNum1) {
		// TODO Auto-generated method stub
		if(phoneNum1 == bean.getPhoneNum()) {
			double totalBal = bean.getBalance();
			//System.out.println(totalBal);
		}
		return bean.getBalance(); 
		
	}

	@Override
	public double deposit(BigInteger phoneNumber, double amount) {
		// TODO Auto-generated method stub
		DepositBean depositBean1 = new DepositBean();
		if(phoneNumber == depositBean1.getPhoneNum()) {
			double totalBalance = bean.getBalance() + depositBean1.getDepositAmt();
			bean.setBalance(totalBalance);
			depositBean1.setBalance(totalBalance);
			LocalDate date = LocalDate.now();
			depositBean1.setDate(date);
			LocalTime time = LocalTime.now();
			depositBean1.setTime(time);

			String msg = "Amount is deposited successfully";
			
			String message  = date + "   " + time + "    " + amount + "  " + msg;
			printList.add(message);

			
		}
		return bean.getBalance();
		  
	}

	@Override
	public double withdraw(BigInteger phoneNumb, double amt) {
		// TODO Auto-generated method stub
		WithdrawBean withdrawBean = new WithdrawBean();
		if(phoneNumb == bean.getPhoneNum()) {
			if(bean.getBalance() > amt ) {
			double totBal = bean.getBalance() - amt;	
			bean.setBalance(totBal);
			LocalDate date = LocalDate.now();
			withdrawBean.setDate(date);
			LocalTime time = LocalTime.now();
			withdrawBean.setTime(time);
			
			String msg = "Total amount withdrawl ";
			
			String message = date + "   " + time + "    " + amt + "  " + msg;
			printList.add(message);

		 }
		   else {
				System.out.println("insufficient balance");
			}
		}
		
		return bean.getBalance();
	}

	@Override
	public double fundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt) {
		// TODO Auto-generated method stub
		FundTransferBean fundTransferBean = new FundTransferBean();
		if(phnNum == bean.getPhoneNum()) {
			if(bean.getBalance() > amunt ) {
				double totbal = bean.getBalance() - amunt;	
				bean.setBalance(totbal);
				
			 }
			   else {
					System.out.println("insufficient balance");
				}
			
		}
		return bean.getBalance();
	}

	@Override
	public ArrayList<String> addTransaction(double amount, String msg, LocalDate date, LocalTime time) {
		// TODO Auto-generated method stub
		printTransaction();
		return printList;
		
	}

	@Override
	public ArrayList<String> printTransaction() {
		// TODO Auto-generated method stub
		System.out.println(printList);
		return printList;
	}

}
