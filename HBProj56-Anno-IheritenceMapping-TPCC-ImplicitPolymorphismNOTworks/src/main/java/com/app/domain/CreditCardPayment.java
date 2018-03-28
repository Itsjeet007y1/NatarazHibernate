package com.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="credit_card_payment4")
public class CreditCardPayment extends Payment {
	private long ccNo;
	private String ccType;
	public long getCcNo() {
		return ccNo;
	}
	public void setCcNo(long ccNo) {
		this.ccNo = ccNo;
	}
	public String getCcType() {
		return ccType;
	}
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	@Override
	public String toString() {
		return "CreditCardPayment [ccNo=" + ccNo + ", ccType=" + ccType + "]";
	}
}
