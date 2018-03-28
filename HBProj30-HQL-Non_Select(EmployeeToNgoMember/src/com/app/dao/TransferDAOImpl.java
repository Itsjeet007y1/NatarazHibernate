package com.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.utility.HibernateUtil;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public int makeEmployeesAsNGOs(int startNo, int endNo) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int count=0;
	   //get Session
		ses=HibernateUtil.getSession();
	   //get Named Query
		query=ses.getNamedQuery("COPY_EMPS_TO_NGOs");
		//set param values
		query.setInteger("min",startNo);
		query.setInteger("max",endNo);
		try{
			tx=ses.beginTransaction();
			 count=query.executeUpdate();
			tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		return count;
	}//method
}//class
