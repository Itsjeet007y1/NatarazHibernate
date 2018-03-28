package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.EmpDetails;
import com.app.util.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		EmpDetails details=null;
		Session session=null;
		Transaction tx=null;
		int id=0;
		boolean flag=false;
		//prepare Employee object
		details=new EmpDetails();
		details.setNo(105);
		details.setFname("Jitendra");
		details.setLname("Kumar");
		details.setMail("Jeet.62.jp@gmail.com");
		try {
			//get session object
			session=HibernateUtil.getSession();
			//prepare Transaction object
			tx=session.beginTransaction();
			//save the object
			id=(int)session.save(details);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		if(flag==true) {
			tx.commit();
			System.out.println("Object saved successfully !!"+id);
		} else if(flag==false) {
			tx.rollback();
			System.out.println("Object not saved !! Some Problem occured.!!!");
		}
		//close session object
		HibernateUtil.closeSession(session);
		//close sessionfactory object
		HibernateUtil.closeSessionFactory();
	}
}
