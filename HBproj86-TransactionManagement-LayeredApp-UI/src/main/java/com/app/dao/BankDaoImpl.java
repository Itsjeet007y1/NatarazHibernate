package com.app.dao;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Account;
import com.app.exception.InsufficientAccountBalanceException;
import com.app.exception.NonPositvieBalanceTransferException;
import com.app.utility.HibernateUtil;

public class BankDaoImpl implements BankDao {

	private String WITHDRAW_QUERY="UPDATE Account set balance=balance-:amt where acno=:srcacid";
	private String DEPOSITE_QUERY="UPDATE Account set balance=balance+:amt where acno=:destacid";
	Account acc=null;
	
	@Override
	public Account getAccountDetailsByAccountNumber(int acno) {
		Session session=null;
		//get Session object
		session=HibernateUtil.getSession();
		try {
			acc=session.get(Account.class, acno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public boolean transferMoney(int srcAcno, int destAcno, float amt) throws NonPositvieBalanceTransferException {
		Session session=null;
		Query query1=null, query2=null;
		int result1=0,result2=0;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//for Deposit Operation
		query1=session.createQuery(DEPOSITE_QUERY);
		query1.setBigDecimal("amt", new BigDecimal(amt));
		query1.setInteger("destacid", destAcno);
		result1=query1.executeUpdate();
		//for withdrawn operation
		query2=session.createQuery(WITHDRAW_QUERY);
		query2.setBigDecimal("amt", new BigDecimal(amt));
		query2.setInteger("srcacid", srcAcno);
		result2=query2.executeUpdate();
		//begin Transaction
		try {
			tx=session.beginTransaction();
			if(result1!=0 && result2!=0) {
				tx.commit();
				return true;
			} else {
				tx.rollback();
				return false;
			}
		} catch(Exception e) {
			tx.rollback();
			return false;
		}
	}
}
