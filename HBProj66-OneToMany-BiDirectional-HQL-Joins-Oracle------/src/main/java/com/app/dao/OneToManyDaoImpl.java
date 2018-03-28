package com.app.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.PhoneNumber;
import com.app.domain.User;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void loadDataUisngParentsAndJoins() {
		Session session=null;
		List<Object[]> list=null;
		Query query=null;
		//create session object
		session=HibernateUtil.getSession();
		//prepare query
		
		//query=session.createQuery("select u.userId, u.userName, ph.phone, ph.numberType from User u full join u.phones ph");
		//query=session.createQuery("select u.userId, u.userName, ph.phone, ph.numberType from User u left join u.phones ph");
		//query=session.createQuery("select u.userId, u.userName, ph.phone, ph.numberType from User u right join u.phones ph");
		query=session.createQuery("select u.userId, u.userName, ph.phone, ph.numberType from User u inner join u.phones ph");
		
		//execute query
		list=query.list();
		//process the result
		for(Object row[]:list){
			   for(Object val:row){
				   System.out.print(val+"   ");
			   }
			   System.out.println();
			}//for
	}

	@Override
	public void loadDataUisngChildsAndJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
	  //get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select ph.phone,ph.numberType,u.userId,u.userName  from PhoneNumber ph full join ph.user u");
		//execute Query
		list=query.list();
		//process the Result
		for(Object row[]:list){
		   for(Object val:row){
			   System.out.print(val+"   ");
		   }
		   System.out.println();
		}//for
		
	}

	@Override
	public void loadDataUsingParentsAndFetchJoins() {
		
	}

	@Override
	public void loadDataUsingParentAndQBC() {
		
	}	
}
