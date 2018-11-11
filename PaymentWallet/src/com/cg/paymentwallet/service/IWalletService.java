package com.cg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.WalletBean;
import com.cg.paymentwallet.exception.WalletException;

public interface IWalletService {

	boolean validations(WalletBean bean) throws WalletException;

	boolean createAccount(WalletBean bean);

	boolean validateShowBalance(BigInteger phoneNum1) throws Exception;

	double showBalance(BigInteger phoneNum);

	boolean validateDeposit(BigInteger phoneNumber, double amount) throws WalletException;

	double deposit(BigInteger phoneNumber, double amount);

	boolean validateWithdraw(BigInteger phoneNumb, double amt) throws WalletException;

	double withdraw(BigInteger phoneNumb, double amt);

	boolean validateFundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt) throws WalletException;

	double fundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt);

	public ArrayList<String> addTransaction(double amount,String msg,LocalDate date,LocalTime time);
	
    public ArrayList<String> printTransaction();
	 

}
