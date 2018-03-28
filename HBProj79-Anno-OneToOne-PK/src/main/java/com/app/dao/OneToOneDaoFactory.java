package com.app.dao;

public class OneToOneDaoFactory {
	public static OneToOneDao getInstance() {
		return new OneToOneDaoImpl();
	}
}
