package com.app.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Cheque_payment1")
@PrimaryKeyJoinColumn(name="payment_id",referencedColumnName="txId")
public class ChequePayment extends Payment {
	private long chequeNo;
	private String chequeType;
	public long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + "]";
	}
}
