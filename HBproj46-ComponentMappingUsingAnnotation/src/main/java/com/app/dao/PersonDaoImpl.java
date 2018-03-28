package com.app.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.Person;
import com.app.utility.HibernateUtil;

public class PersonDaoImpl implements PersonDao {
	private final String GET_PERSONS="from Person";
	
	/*@Override
	public void savePerson(Person person) {
		Session session = null;
		Transaction tx=null;
		//Get session object
		session=HibernateUtil.getSession();
		// save person object
		try {
			tx=session.beginTransaction();
			session.save(person);
			tx.commit();
			System.out.println("Object is saved!!");
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession(session);
	}*/
	
	@Override
	public List<Person> getPerson() throws Exception {
		Session session=null;
		List<Person> list=null;
		//get Session object
		session=HibernateUtil.getSession();
		Query query=session.createQuery(GET_PERSONS);
		list=query.list();
		return list;
	}
}
