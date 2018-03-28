package com.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.PhoneNumber;
import com.app.domain.User;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void SaveDataUsingParents() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Map<String,PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		//parent obj
		 user=new User();
		 user.setUserId(1001);
		 user.setUserName("Jeet");
		//child objs
		 ph1=new PhoneNumber();
		ph1.setPhone(999999);
		ph1.setNumberType("office");

		 ph2=new PhoneNumber();
		ph2.setPhone(88888);
		ph2.setNumberType("home");

		childs=new HashMap<String,PhoneNumber>();
		childs.put("hyd no",ph1);
		childs.put("blore no",ph2);
		//set childs to parent
		user.setPhones(childs);
		//save objs (parent to child)
		Transaction tx=null;
		try{
		 tx=ses.beginTransaction();
		   ses.save(user);
		 tx.commit();
		 System.out.println("Objects are saved....");
		  }//try
		  catch(Exception e){
		    tx.rollback();
		  }
		    
	}

	@Override
	public void deleteOneChildFromCollectionOfChildsInAParent() {
		Session ses=null;
		User user=null;
		Map<String,PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=(User)ses.get(User.class,1001);
		//get Childs from a Parent
		childs=user.getPhones();
		//delete child from collection of childs
		try{
			tx=ses.beginTransaction();
			  childs.remove("hyd no");
			 tx.commit();
			 System.out.println("Removing child obj from collection of childs");
		}//try
		catch(Exception e){
			tx.rollback();
		}	
	}
}
