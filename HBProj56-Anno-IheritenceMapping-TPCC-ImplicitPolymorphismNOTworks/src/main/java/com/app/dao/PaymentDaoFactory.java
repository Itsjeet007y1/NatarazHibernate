package com.app.dao;

public class PaymentDaoFactory {
	public static PaymentDao getInstance() {
		return new PaymentDaoImpl();
	}
}
