package com.app.domain;

import java.util.Date;

public class BankTxDetails {
	private int txId;
	private String txName;
	private float txAmount;
	private Date txDate;
	//default constructor
	public BankTxDetails() {
		super();
	}
	//setters and getters
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public String getTxName() {
		return txName;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	public float getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}
}
