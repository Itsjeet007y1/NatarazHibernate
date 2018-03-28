package com.app.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Bank_Account1")
public class BankAccount {
	private long accno;
	private String holderName;
	private String type;
	private float balance;
	private int version;
	private Timestamp lastOperated;
	private Timestamp openingDate;
	//default constructor
	public BankAccount() {
		super();
	}
	//setters and getters
	@Id
	@Column(length=20)
	@SequenceGenerator(name="gen1",sequenceName="Acno_seq",initialValue=10,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	@Column(length=30)
	@Type(type="string")
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	@Column(length=20)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(length=10)
	@Type(type="float")
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Column(length=6, name="Version_col")
	@Type(type="int")
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Column
	@CreationTimestamp
	public Timestamp getLastOperated() {
		return lastOperated;
	}
	public void setLastOperated(Timestamp lastOperated) {
		this.lastOperated = lastOperated;
	}
	@Column
	@UpdateTimestamp
	public Timestamp getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Timestamp openingDate) {
		this.openingDate = openingDate;
	}
}
