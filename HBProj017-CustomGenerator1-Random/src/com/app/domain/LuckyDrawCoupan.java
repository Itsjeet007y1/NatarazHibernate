package com.app.domain;

import java.util.Date;

public class LuckyDrawCoupan {
	private int cuponNo;
	private String customerName;
	private int billNo;
	private Date purchaseDate;
	private float billAmt;
	public int getCuponNo() {
		return cuponNo;
	}
	public void setCuponNo(int cuponNo) {
		this.cuponNo = cuponNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public float getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}
}
