package com.app.domain;

public class PhoneNumber {
	private long phone;
	private String numberType;
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public PhoneNumber() {
		System.out.println("PhoneNumber: 0-parma constructor...");
	}
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + "]";
	}
}
