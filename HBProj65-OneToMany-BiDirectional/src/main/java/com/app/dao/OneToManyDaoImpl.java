package com.app.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
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
		User user=null;
		Transaction tx=null;
		PhoneNumber phone=null,phone1=null;
		Set<PhoneNumber> childs=null;
		//get session object
		session=HibernateUtil.getSession();
		//set user value
		user=new User();
		user.setUserId(101);
		user.setUserName("Adom");
		//set phone numbers
		phone=new PhoneNumber();
		phone.setPhone(11111);
		phone.setNumberType("Office");
		phone1=new PhoneNumber();
		phone1.setPhone(22222);
		phone1.setNumberType("Secret");
		childs=new HashSet<PhoneNumber>();
		childs.add(phone);childs.add(phone1);
		user.setPhones(childs);
		phone1.setUser(user);
		phone.setUser(user);
		//save the data
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
			System.out.println("Child and parent data is saved...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SaveDataUsingChilds() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 user=new User();
		 user.setUserId(102);
		 user.setUserName("Ramesh");
		//child objects
		 ph1=new PhoneNumber();
		ph1.setPhone(54545445);
		ph1.setNumberType("office");

		 ph2=new PhoneNumber();
		ph2.setPhone(545466758);
		ph2.setNumberType("home");
		//set children to parent 
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		user.setPhones(childs);
		//set parent to children
		ph1.setUser(user);
		ph2.setUser(user);
		//save objects (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(ph1); ses.save(ph2);
		 tx.commit();
		 System.out.println("data is saved using childs");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		    }
	}

	@Override
	public void loadUsingParents() {
		Session session=null;
		List<User> list=null;
		//get Session object
		session=HibernateUtil.getSession();
		//get data using parent
		Query query=session.createQuery("from User");
		list=query.list();
		list.forEach(p-> {
			System.out.println("Parent:-"+p.getUserId()+"  "+p.getUserName());
			Set<PhoneNumber> phone=p.getPhones();
			phone.forEach(c->{
				System.out.println("Children:"+c.getPhone()+"  "+c.getNumberType());
			});
		});
	}

	@Override
	public void loadDataUsingChilds() {
		Session session=null;
		List<PhoneNumber> pList=null;
		//get Session object
		session=HibernateUtil.getSession();
		//get Data using child
		Query query=session.createQuery("from PhoneNumber");
		pList=query.list();
		pList.forEach(c->{
			System.out.println("Chldren:"+c.getPhone()+"  "+c.getNumberType());
			User user=c.getUser();
			System.out.println("Parent"+user.getUserId()+"  "+user.getUserName());
		});
	}
	
}
