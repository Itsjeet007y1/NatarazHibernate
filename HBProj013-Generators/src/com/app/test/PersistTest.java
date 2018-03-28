package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.EmpDetails;
import com.app.util.HibernateUtil;

public class PersistTest {
	public static void main(String[] args) {
		EmpDetails details=null;
		Transaction tx=null;
		Session session=null;
		boolean flag=false;
		//Prepare object
		details=new EmpDetails();
		details.setNo(22);
		details.setFname("Dharmendra");
		details.setLname("Kumar");
		details.setMail("Dhiru@gmail.com");
		//get session object
		session=HibernateUtil.getSession();
		//create transaction object
		tx=session.beginTransaction();
		
		try {
			//persist the object
			session.persist(details);
			session.flush();
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
			System.out.println("Data persisted successfully !!!");
		} else if(flag=false) {
			tx.rollback();
			System.out.println("Data not persisted. !!!");
		}
		//close session object
		HibernateUtil.closeSession(session);
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
