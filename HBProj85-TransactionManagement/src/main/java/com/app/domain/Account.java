package com.app.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account",schema="SYSTEM")
public class Account implements java.io.Serializable {
	private int acno;
	private String holder;
	private BigDecimal balance;
	public Account() {
		System.out.println("Account: 0-param constructor.");
	}
	public Account(int acno) {
		this.acno = acno;
	}

	public Account(int acno, String holder, BigDecimal balance) {
		super();
		this.acno = acno;
		this.holder = holder;
		this.balance = balance;
	}
	@Id
	@Column(name="acno",unique=true,nullable=false,precision=5,scale=0)
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	@Column(name="holder",length=20)
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	@Column(name="balance",precision=10)
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
}
