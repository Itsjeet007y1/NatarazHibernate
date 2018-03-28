package com.app.dao;

public class PersonDaoFactory {
	public static PersonDao getInstance() {
		return new PersonDaoImpl();
	}
}
