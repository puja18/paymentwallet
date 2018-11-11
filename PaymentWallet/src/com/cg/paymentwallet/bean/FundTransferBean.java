package com.cg.paymentwallet.bean;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class FundTransferBean {
	private LocalDate date;
	private LocalTime time;
	private BigInteger phoneNumb;
	private double fundtransferAmt;
	private BigInteger targetPhnNum;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public double getFundtransferAmt() {
		return fundtransferAmt;
	}
	public void setFundtransferAmt(double fundtransferAmt) {
		this.fundtransferAmt = fundtransferAmt;
	}
	public BigInteger getTargetPhnNum() {
		return targetPhnNum;
	}
	public void setTargetPhnNum(BigInteger targetPhnNum) {
		this.targetPhnNum = targetPhnNum;
	}
	public BigInteger getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(BigInteger phoneNumb) {
		this.phoneNumb = phoneNumb;
	}
	
}
