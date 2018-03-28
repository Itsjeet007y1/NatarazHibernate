package com.app.dao;

public interface BankDao {
	public boolean transferMoney(int srcAcno,int destAcno,float amt);
}
