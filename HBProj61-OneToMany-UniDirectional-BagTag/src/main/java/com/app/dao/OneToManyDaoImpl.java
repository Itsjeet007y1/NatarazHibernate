package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.PhoneNumber;
import com.app.domain.User;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void SaveDataUsingParents() {
		Session session=null;
		List<PhoneNumber> childs=null;
		PhoneNumber ph1=null,ph2=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//Enter parent object
		User user=new User();
		user.setUserId(102);
		user.setUserName("Jitendra");
		//childs object
		ph1=new PhoneNumber();
		ph1.setPhone(1122334455l);
		ph1.setNumberType("Home");
		ph2=new PhoneNumber();
		ph2.setPhone(5544998877l);
		ph2.setNumberType("Office");
		childs=new ArrayList<>();
		childs.add(ph1); childs.add(ph2);
		//set childs to parent
		user.setPhones(childs);
		try {
			tx=session.beginTransaction();
			session.persist(user);
			tx.commit();
			System.out.println("Object are saved...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadDataUsingParent() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		List<PhoneNumber> childs=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from User");
		//execute Query
		list=query.list();
		//process the Results
		for(User user:list){
			System.out.println("parent---->"+user);
			//get all childs of each parent
			childs=user.getPhones();
			System.out.println(childs.size());
			for(PhoneNumber ph:childs){
				System.out.println("child--->"+ph);
			}//for
		
			}//for
		
	}

	@Override
	public void deleteOneChildFromCollectionOfChildsInAParent() {
		Session ses=null;
		User user=null;
		List<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=(User)ses.get(User.class,102);
		//get Childs from a Parent
		childs=user.getPhones();
		//delete child from collection of childs
		try{
			tx=ses.beginTransaction();
			    childs.remove(0);
			 tx.commit();
			 System.out.println("Removing child obj from collection of childs");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}
}
