package com.app.dao;

public class LOBDAOFactory {
	public static LOBDAO getInstance(){
		return new LOBDAOImpl();
	}
}
