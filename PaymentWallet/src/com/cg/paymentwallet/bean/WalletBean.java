package com.cg.paymentwallet.bean;

import java.math.BigInteger;

public class WalletBean {
	private String firstName;
	private String lastName;
	private BigInteger phoneNum;
	private String mailId;
	private String address;
	private double amount;
	private double balance = 500;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigInteger getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(BigInteger phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "WalletBean [firstName=" + firstName + ", lastName=" + lastName + ", phoneNum=" + phoneNum + ", mailId="
				+ mailId + ", address=" + address + ", balance=" + balance + "]";
	}
	
	

}
