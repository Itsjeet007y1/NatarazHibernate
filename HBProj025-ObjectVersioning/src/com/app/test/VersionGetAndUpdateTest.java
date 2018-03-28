package com.app.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankAccount;
import com.app.utility.HibernateUtil;

public class VersionGetAndUpdateTest {
	public static void main(String[] args) {
		Session session = null;
		boolean flag = true;
		Scanner sc=null;
		BankAccount account = null;
		Transaction tx = null;
		long idVal = 0l;
		// get Session
		session = HibernateUtil.getSession();
		// prepare Object
		tx = session.beginTransaction();
		account = new BankAccount();
		account.setHolderName("CheaterMalya");
		account.setBalance(9999999);
		account.setType("Non-Performing");
		sc=new Scanner(System.in);
		System.out.println("Enter account number:");
		idVal=sc.nextLong();
		System.out.println("Enter amount to withdraw:");
		float bal=sc.nextFloat();
		account = session.get(BankAccount.class, idVal);
		if (account != null) {
			account.setBalance(account.getBalance()-bal);
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
					System.out.println("Money Withdraw successfully..");
				} else {
					tx.rollback();
					System.out.println("Some problem occured. Please try later..");
				}
				// close objects
				HibernateUtil.closeSession(session);
				HibernateUtil.closeSessionFactory();
				sc.close();
			} // finally
		} else {
			System.out.println("Record not Found");
		}
	}// main
}// class
