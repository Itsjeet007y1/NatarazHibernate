package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankAccount;
import com.app.utility.HibernateUtil;

public class VersionTest {
	public static void main(String[] args) {
		Session session = null;
		boolean flag = true;
		BankAccount account = null;
		Transaction tx = null;
		long idVal = 0;
		// get Session
		session = HibernateUtil.getSession();
		// prepare Object
		tx = session.beginTransaction();
		account = new BankAccount();
		account.setHolderName("Malya");
		account.setBalance(20000);
		account.setType("Performing");
		account = session.get(BankAccount.class, 2L);
		if (account != null) {
			account.setBalance(10001);
			try {
				session.update(account);
				System.out.println("Account Number::" + account.getAcno());
				flag = true;
			} catch (HibernateException xe) {
				flag = false;
				xe.printStackTrace();
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
			} finally {
				if (flag == true) {
					tx.commit();
					System.out.println("Object Saved successfully. :)");
				} else {
					tx.rollback();
					System.out.println("Object not Saved.");
				}
				// close objects
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
			} // finally
		} else {
			System.out.println("Record not Found");
		}
	}// main
}// class
