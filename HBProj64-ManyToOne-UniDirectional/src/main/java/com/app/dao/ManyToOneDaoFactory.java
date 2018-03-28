package com.app.dao;

public class ManyToOneDaoFactory {
	public static ManyToOneDao getInstance()	{
		return new ManyToOneDaoImpl();
	}
}
