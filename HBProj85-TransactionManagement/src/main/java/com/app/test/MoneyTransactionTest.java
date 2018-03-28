package com.app.test;


import com.app.dao.BankDao;
import com.app.dao.BankDaoFactory;
import com.app.utility.HibernateUtil;

public class MoneyTransactionTest {
	public static void main(String[] args) {
		BankDao dao=null;
		//get dao object from dao factory
		dao=BankDaoFactory.getInstance();
		//use dao object
		if(dao.transferMoney(909, 101,12000f))
			System.out.println("Money Transfered..");
		else
			System.out.println("Money Not Transfered..");
		//close objects
		HibernateUtil.closeSessionFactory();
		HibernateUtil.closeSessionFactory();
	}
}
