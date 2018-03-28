package com.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

@Entity
@Table(name="Bank_Account_Soft_Delete")
@SQLDelete(sql="Update Bank_Account_Soft_Delete set status='Locked' where acno=?")
@Where(clause = "status is  null")
public class BankAccount implements Serializable {
	private long acno;
	private  String holderName;
	private String type;
	private float balance;
	
	@Id
	@Column(length=10)
	@SequenceGenerator(name="gen1",
	                   sequenceName="ACNO_SEQ",
	                   initialValue=10,
	                   allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Type(type="long")
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	@Column(length=15)
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

}
