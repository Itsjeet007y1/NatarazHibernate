package com.app.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankAccount;
import com.app.utility.HibernateUtil;

public class SoftDeleteSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		List<BankAccount> list=null;
		Query query=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//Load objects
		try{
	     query=ses.createQuery("from BankAccount");
	     list=query.list();
	     list.forEach(acc->{
	    	 System.out.println(acc.getAcno()+"  "+acc.getHolderName()+" "+acc.getType()+" "+acc.getBalance());
	     });
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		 //close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}/// class
