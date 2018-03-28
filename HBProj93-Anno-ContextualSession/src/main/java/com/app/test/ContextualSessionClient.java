package com.app.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.domain.BankAccount;


public class ContextualSessionClient {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session ses1 = factory.openSession();
		BankAccount account=ses1.get(BankAccount.class,10L);
		System.out.println(account.getAcno()+" "+account.getHolderName());
		
		Session ses2 = factory.openSession();
		BankAccount account1=ses2.get(BankAccount.class,10L);
		System.out.println(account1.getAcno()+" "+account1.getHolderName());
		
		System.out.println(ses1.hashCode()+"  "+ses2.hashCode());
		
		
		ses1.close();
		 factory.close();
	}// main

}// class
