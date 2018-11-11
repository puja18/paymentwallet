package com.cg.paymentwallet.ui;

import java.math.BigInteger;
import java.util.Scanner;

import com.cg.paymentwallet.bean.DepositBean;
import com.cg.paymentwallet.bean.FundTransferBean;
import com.cg.paymentwallet.bean.WalletBean;
import com.cg.paymentwallet.bean.WithdrawBean;
import com.cg.paymentwallet.exception.WalletException;
import com.cg.paymentwallet.service.IWalletService;
import com.cg.paymentwallet.service.WalletServiceImpl;

public class Main {
	public static void main(String[] args) {
		IWalletService service = new WalletServiceImpl();
		WalletBean bean = new WalletBean();
		try {
			while(true) {
		//MENU FOR PAYMENT WALLET
		System.out.println("WELCOME TO PAYMENT WALLET");
		System.out.println("1.Create Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Print Transactions");
		//Gives values from keyboard use scanner class
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			//create account
			System.out.println("Enter the first name");
			String firstName = scanner.next();
			System.out.println("Enter the last Name");
			String lastName = scanner.next();
			System.out.println("Enter the mobile number");
			BigInteger phoneNum = scanner.nextBigInteger();
			System.out.println("Enter the Address");
			String address = scanner.next();
			System.out.println("Enter the Email ");
			String mailId = scanner.next();

			
			//set the values into bean
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setPhoneNum(phoneNum);
			bean.setAddress(address);
			bean.setMailId(mailId);
			
			System.out.println("Your account is created succesfully");
			System.out.println("Your account details are:");
			
			
			try {
				boolean isValid = service.validations(bean);
				if(isValid) {
					boolean isAdded = service.createAccount(bean);
				
				   if(isAdded) {
				    	System.out.println(bean);
					    System.out.println("Thank you");
				   }
					
				}
				else {
					System.out.println("Enter the details properly");
				}
			} catch (WalletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;

		case 2:
			System.out.println("Enter phonenum");
			BigInteger phoneNum1 = scanner.nextBigInteger();
			//bean.setPhoneNum(phoneNum1);
			try {
			boolean isValid1 = service.validateShowBalance(phoneNum1);
			if(isValid1) {
			    
			  service.showBalance(phoneNum1);
			 
			}
			 else {
				System.out.println("InValid phonenum");
			}
			System.out.println("total balance is:" + bean.getBalance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
	
		 case 3:
			 DepositBean depositBean = new  DepositBean();
			 System.out.println("Enter the mobile Num");
			 BigInteger phoneNumber = scanner.nextBigInteger();
			 System.out.println("Enter the amount to deposit");
			 double amount = scanner.nextDouble();
			 //depositBean.setPhoneNum(phoneNumber);
			 bean.setAmount(amount);
			 //depositBean.setDepositAmt(amount);
			 try {
					boolean isValid = service.validateDeposit(phoneNumber,amount);
					  if(isValid) {
						  service.deposit(phoneNumber,amount);
						  
					  }
					  else {
						  System.out.println("InValid phonenum or enter the amount properly"); 
					  }
					  System.out.println(bean);
				      System.out.println("total balance in ur account is:" + bean.getBalance());
					
			 }
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 break;
			 
		 case 4:
			WithdrawBean withdraw = new WithdrawBean();
			 System.out.println("Enter the mobile Num");
			 BigInteger phoneNumb = scanner.nextBigInteger();
			 System.out.println("Enter the amount to withdraw");
			 double amt = scanner.nextDouble();
			// withdraw.setPhoneNum(phoneNumb);
			 //withdraw.setWithdrawAmt(amt);
			 bean.setAmount(amt);
			 try {
					boolean isValid = service.validateWithdraw(phoneNumb,amt);
					  if(isValid) {
						  service.withdraw(phoneNumb,amt);
					  }
					  else {
						  System.out.println("InValid phonenum or enter the amount properly"); 
					  }
					  System.out.println(bean);
					  System.out.println("total balance in ur account is:" + bean.getBalance());
				
			 }
			 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 break;
		 case 5:
			 FundTransferBean transferBean = new FundTransferBean();
			 System.out.println("Enter the mobile Num");
			 BigInteger phnNum = scanner.nextBigInteger();
			 System.out.println("Enter the target phonenumber");
			 BigInteger targetNum = scanner.nextBigInteger();
			 System.out.println("Enter the amount to be transfered");
			 double amunt = scanner.nextDouble();
			 transferBean.setTargetPhnNum(targetNum);
			 transferBean.setPhoneNumb(phnNum);
			 transferBean.setFundtransferAmt(amunt);
			 try {
			 boolean isValid = service.validateFundTransfer(phnNum,targetNum,amunt);
			  if(isValid) {
				  service.fundTransfer(phnNum,targetNum,amunt);
				  System.out.println(bean);
				  System.out.println("total balance in ur account is:" + bean.getBalance());
			  }
			  else {
				  System.out.println("InValid phonenum or enter the amount properly"); 
			
			  			}
			 }	catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}	
			 
		 case 6:
			 DepositBean DBean = new DepositBean();
			// service.addTransaction(amount, msg, date, time);
		
	
}
}
		}
		catch (Exception e) {
	           System.out.println(" internal error. try later.");
      }
	}
}
	


