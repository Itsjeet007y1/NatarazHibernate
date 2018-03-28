package com.app.test;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

import com.app.domain.BankAccount;


public class HBStatisticClient {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session ses1 = factory.openSession();
		Session ses2 = factory.openSession();
		Session ses3 = factory.openSession();
		Transaction tx=null;
		BankAccount account = ses1.get(BankAccount.class,10l);
		System.out.println(account.getAcno()+" "+account.getBalance()+" "+account.getHolderName());
		try{
			tx=ses1.beginTransaction();
			  ses1.delete(account);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		 ses2.close();
		// Get Session stats
		 Statistics stats= factory.getStatistics();
		 stats.setStatisticsEnabled(true);
		 
		 System.out.println("open sessions count: "+stats.getSessionOpenCount());
		 System.out.println("closed sessions count "+stats.getSessionCloseCount());
		 System.out.println("Tx count"+stats.getTransactionCount());
		 System.out.println("successful Tx count"+stats.getSuccessfulTransactionCount());
         System.out.println("session start time"+new Date(stats.getStartTime()));		 
         
         // Get Entity Statistics
          EntityStatistics es=stats.getEntityStatistics("com.nt.domain.BankAccount");
          
          System.out.println("delete count::"+es.getDeleteCount());
          System.out.println("insert count::"+es.getInsertCount());
          System.out.println("load count::"+es.getLoadCount());
          System.out.println("update count::"+es.getUpdateCount());
          
          
		ses1.close();
	   factory.close();
	}// main

}// class
