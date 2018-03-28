package com.app.domain;

import java.util.List;
import java.util.Map;

public class User {
	private int userId;
	private String userName;
	private Map<String,PhoneNumber> phones;
	public User() {
		System.out.println("User: 0-param constructor..");
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String,PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(Map<String,PhoneNumber> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phones=" + phones + "]";
	}
}
