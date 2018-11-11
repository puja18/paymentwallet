package com.cg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.WalletBean;
import com.cg.paymentwallet.dao.IWalletDAO;
import com.cg.paymentwallet.dao.WalletDAOImpl;
import com.cg.paymentwallet.exception.WalletException;
import com.cg.paymentwallet.exception.WalletExceptionMessage;

public class WalletServiceImpl implements IWalletService {
	IWalletDAO walletDao = new WalletDAOImpl();

	
	@Override
	public boolean createAccount(WalletBean bean) {
		// TODO Auto-generated method stub
		return walletDao.createAccount(bean);
	}

	

	@Override
	public double showBalance(BigInteger phoneNum) {
		// TODO Auto-generated method stub
		return walletDao.showBalance(phoneNum);
	}
	
	@Override
	public boolean validations(WalletBean bean) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid=true;
		
		if(!( bean.getFirstName().matches("[a-zA-Z]{3,}")))
		{
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR1);
		}
		if(!( bean.getLastName().matches("[a-zA-Z]{3,}")))
		{
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR2);
		}
		if(!(bean.getPhoneNum().toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR3);
		}
		if((bean.getMailId()== null || !(bean.getMailId().matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")))){

			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR4);
		}
		if((bean.getAddress()==null)||(!(bean.getAddress().matches("[A-Za-z]{5,50}"))))
		{
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR5);
		}
		if(bean.getBalance()==0||!(bean.getBalance()>0)){
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR6);
	 
		}
		
			return isValid;
	
	}


	@Override
	public boolean validateShowBalance(BigInteger phoneNum) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		if(!(phoneNum.toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR3);
		}
		return isValid;
	}



	@Override
	public boolean validateDeposit(BigInteger phoneNumber, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		//DepositBean depositBean = new DepositBean();
		if(!(phoneNumber.toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR5);
		}
		if(amount==0||!(amount>0)){
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR6);
	 
		}
		return isValid;
	}



	@Override
	public double deposit(BigInteger phoneNumber, double amount) {
		// TODO Auto-generated method stub
		return walletDao.deposit(phoneNumber,amount);
	}



	@Override
	public boolean validateWithdraw(BigInteger phoneNumb, double amt) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		if(!(phoneNumb.toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR5);
		}
		if(amt==0||!(amt>0)){
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR6);
	 
		}
		return isValid;

	}



	@Override
	public double withdraw(BigInteger phoneNumb, double amt) {
		// TODO Auto-generated method stub
		return walletDao.withdraw(phoneNumb,amt);
	}



	@Override
	public boolean validateFundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		if(!(phnNum.toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR5);
		}
        if(!(targetNum.toString().matches("^[6-9][0-9]{9}"))){
			
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR5);
		}
		if(amunt==0||!(amunt>0)){
			isValid=false;
			throw new WalletException(WalletExceptionMessage.ERROR6);
	 
		}
		return isValid;

	}
		

	@Override
	public double fundTransfer(BigInteger phnNum, BigInteger targetNum, double amunt) {
		// TODO Auto-generated method stub
		return walletDao.fundTransfer(phnNum,targetNum,amunt);
	}



	@Override
	public ArrayList<String> addTransaction(double amount, String msg, LocalDate date, LocalTime time) {
		// TODO Auto-generated method stub
		return walletDao.addTransaction(amount,msg,date,time);
	}



	@Override
	public ArrayList<String> printTransaction() {
		// TODO Auto-generated method stub
		return walletDao.printTransaction();
	}


}
