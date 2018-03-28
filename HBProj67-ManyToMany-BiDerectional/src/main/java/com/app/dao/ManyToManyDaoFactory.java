package com.app.dao;

public class ManyToManyDaoFactory {
	public static ManyToManyDao getInstance() {
		return new ManyToManyDaoImpl();
	}
}
