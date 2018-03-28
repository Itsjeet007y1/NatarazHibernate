package com.app.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.BankAccount;


public class ContextualSessionClient1 {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Transaction tx=null;
		Session ses1=null,ses2=null;
		
		try{
		 ses1 = factory.getCurrentSession();//for creating single thread
		tx=ses1.beginTransaction();
		BankAccount account=ses1.get(BankAccount.class,10L);
		System.out.println(account.getAcno()+" "+account.getHolderName());
		
		
		 ses2 = factory.getCurrentSession();
		BankAccount account1=ses2.get(BankAccount.class,10L);
		System.out.println(account1.getAcno()+" "+account1.getHolderName());
		
		System.out.println(ses1.hashCode()+"  "+ses2.hashCode());
		tx.commit();
		
		}
		catch(Exception e){
			 e.printStackTrace();
		  }
	    finally{
	      factory.close();
	    }
	}// main
}// class
