package com.app.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Country;
import com.app.domain.State;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void saveDataUsingCountry() {
		Session session=null;
		Country country=null;
		State state1,state2=null;
		Set<State> children=null;
		Transaction tx=null;
		boolean flag=false;
		//get session object
		session=HibernateUtil.getSession();
		//prepare objects
		country=new Country();
		country.setName("India");
		country.setCapital("New Delhi");
		country.setLanguage("Hindi");
		
		state1=new State();
		state1.setCode("UP");
		state1.setName("Uttar Pradesh");
		state1.setCapital("Lucknow");
		
		state2=new State();
		state2.setCode("MP");
		state2.setName("MadhyaPradesh");
		state2.setCapital("Bhopal");
		//set children to parent
		children=new HashSet<State>();
		children.add(state1);
		children.add(state2);
		country.setStates(children);
		//set parent to child
		state1.setCountry(country);
		state2.setCountry(country);
		//save objects parent to children
		try {
			tx=session.beginTransaction();
			session.save(country);
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
				System.out.println("Object saved(parent to child) Successfully...");
			}
			else {
				tx.rollback();
				System.out.println("Some problem occured. Please check...");
			}
		}
	}

	@Override
	public void saveDataUsingState() {
		Session session=null;
		Country country=null;
		State state1,state2=null;
		Set<State> children=null;
		Transaction tx=null;
		boolean flag=false;
		//get session object
		session=HibernateUtil.getSession();
		//prepare object
		country=new Country();
		country.setName("America");
		country.setCapital("WahingtonDC");
		country.setLanguage("English");
		
		state1=new State();
		state1.setCode("CLF");
		state1.setName("California");
		state1.setCapital("Sacramento");
		
		state2=new State();
		state2.setCode("NJ");
		state2.setName("New Jersey");
		state2.setCapital("Trenton");
		//set child to parent
		children=new HashSet<State>();
		children.add(state1);
		children.add(state2);
		country.setStates(children);
		//set parent to child
		state1.setCountry(country);
		state2.setCountry(country);
		//save data child to parent
		try {
			tx=session.beginTransaction();
			session.save(state1);
			session.save(state2);
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
				System.out.println("Objec (child to parent) saved successfully...");
			} else {
				tx.rollback();
				System.out.println("Something went wrong!! please check.");
			}
		}
	}
}
