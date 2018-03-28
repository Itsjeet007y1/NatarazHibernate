package com.app.dao;

public class TransferDAOFactory {
	
	public static TransferDAO getInstance(){
		return new TransferDAOImpl();
	}
}
