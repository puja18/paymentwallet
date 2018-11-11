package com.cg.paymentwallet.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.WalletBean;

public interface IWalletDAO {

	boolean createAccount(WalletBean bean);

	double showBalance(BigInteger phoneNum1);

	double deposit(BigInteger phoneNumber, double amount);

	double withdraw(BigInteger phoneNumber, double amount);

	double fundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt);

	ArrayList<String> addTransaction(double amount, String msg, LocalDate date, LocalTime time);

	ArrayList<String> printTransaction();

}
