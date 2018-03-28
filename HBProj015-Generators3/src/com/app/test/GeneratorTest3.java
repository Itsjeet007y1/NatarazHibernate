package com.app.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankTxDetails;
import com.app.utility.HibernateUtil;

public class GeneratorTest3 {
	public static void main(String[] args) {
		Session session=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		BankTxDetails details=null;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare BankTxDetails class object
		details=new BankTxDetails();
		//set the value to details object
		//details.setTxId(123);
		details.setTxName("Sartazi");
		details.setTxAmount(100000);
		details.setTxDate(new Date());
		//set Transaction object
		tx=session.beginTransaction();
		try {
			idVal=(int)session.save(details);
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
				System.out.println("Object saved successfully..!! with id Number: "+idVal);
			} else if(flag==false) {
				tx.rollback();
				System.out.println("Object not saved !!");
			}
		}
		//close session and session factory object
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
}
