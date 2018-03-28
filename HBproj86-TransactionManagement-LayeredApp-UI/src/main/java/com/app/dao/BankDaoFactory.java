package com.app.dao;

public class BankDaoFactory {
	public static BankDao getInstance() {
		return new BankDaoImpl();
	}
}
