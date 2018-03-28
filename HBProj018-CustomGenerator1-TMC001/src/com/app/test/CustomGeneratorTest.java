package com.app.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.LuckyDrawCoupan;
import com.app.util.HibernateUtil;

public class CustomGeneratorTest {
	public static void main(String[] args) {
		Session session=null;
		Transaction tx=null;
		boolean flag=false;
		LuckyDrawCoupan coupan=null;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare the class object
		coupan=new LuckyDrawCoupan();
		//coupan.setCuponNo(123);
		coupan.setBillNo(12354);
		coupan.setCustomerName("SDfsdf");
		coupan.setBillAmt(1236978);
		coupan.setPurchaseDate(new Date());
		//create Transaction object ready
		tx=session.beginTransaction();
		try {
			session.save(coupan);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e ) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Data saved successfully !!!");
			} else if(flag==false) {
				tx.rollback();
				System.out.println("Something went wrong. Pleas check !!!");
			}
		}
		//close session and session factory object
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
}
