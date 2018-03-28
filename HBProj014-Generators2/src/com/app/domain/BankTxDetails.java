package com.app.domain;

import java.sql.Timestamp;
import java.util.Date;

public class BankTxDetails {
	private String txId;
	private String txName;
	private float txAmount;
	private Date txDate;

	// default Constructor
	public BankTxDetails() {
		super();
	}

	// setters and getters
	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
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
