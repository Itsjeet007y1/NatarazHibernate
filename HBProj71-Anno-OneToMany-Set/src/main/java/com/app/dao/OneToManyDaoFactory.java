package com.app.dao;

public class OneToManyDaoFactory {
	public static OneToManyDao getInstance() {
		return new OneToManyDaoImpl();
	}
}
