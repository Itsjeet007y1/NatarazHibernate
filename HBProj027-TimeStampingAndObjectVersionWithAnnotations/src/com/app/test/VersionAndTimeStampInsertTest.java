package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankAccount;
import com.app.utility.HibernateUtil;

public class VersionAndTimeStampInsertTest {
	public static void main(String[] args) {
		Session session=null;
		boolean flag=false;
		Transaction tx=null;
		BankAccount account=null;
		long idVal=0;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare object
		try {
			tx=session.beginTransaction();
			account=new BankAccount();
			account.setHolderName("Jitendra Kumar");
			account.setBalance(1200000);
			account.setType("Performing");
			idVal=(Long)session.save(account);
			System.out.println("Account Number:"+idVal);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Object saved !!");
			} else {
				tx.commit();
				System.out.println("Object not saved !!");
			}
			//close objects
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
