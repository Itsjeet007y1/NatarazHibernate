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
	public void loadDataUisngParentsAndJoins() {
		Session session=null;
		List<Object[]> list=null;
		Query query=null;
		//create session object
		session=HibernateUtil.getSession();
		//prepare query
		query=session.createQuery("select u.userId, u.userName, ph.phone, ph.numberType from User u full join u.phones ph");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadDataUsingParentsAndFetchJoins() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadDataUsingParentAndQBC() {
		// TODO Auto-generated method stub
		
	}
	
}
