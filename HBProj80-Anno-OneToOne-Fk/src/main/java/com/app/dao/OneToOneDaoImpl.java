package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Passport;
import com.app.domain.Person;
import com.app.utility.HibernateUtil;

public class OneToOneDaoImpl implements OneToOneDao {

	@Override
	public void saveDataUsingPassport() {
		Session session=null;
		Passport pass=null;
		Person per=null;
		Transaction tx=null;
		boolean flag=false;
		//get session object
		session=HibernateUtil.getSession();
		//prepare objects
		pass=new Passport();
		pass.setPname("Jitendra Kumar");
		pass.setCountry("India");
		
		per=new Person();
		per.setAge(24);
		per.setPname("Jitendra");
		
		//map Person to passport
		pass.setPersonDetails(per);
		//save the object
		try {
			tx=session.beginTransaction();
			session.save(pass);
			flag=true;
		} catch(HibernateException he) {
			flag=false;
			throw he;
		} catch(Exception e) {
			flag=false;
			throw e;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object saved");
			} else {
				tx.rollback();
				System.out.println("Object not saved.");
			}
			//close the connection object
			HibernateUtil.closeSession();
		}
	}
}
