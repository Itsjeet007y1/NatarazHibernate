package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Student;
import com.app.utility.HibernateUtil;

public class AnnoNamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//get Access Named Native SQL Queries and execute them
		//Query1
		Query query1=ses.getNamedQuery("GET_STUDS_BY_ADDRS");
		query1.setString("addrs","hyd");
		List<Student> list1=query1.list();
		for(Student st:list1){
			System.out.println(st);
		}
		//Query2
		Query query2=ses.getNamedQuery("DELETE_STUDS_BY_ADDRS");
		query2.setString("addrs","hyd");
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			  int result=query2.executeUpdate();
			  System.out.println("no.of records deleted:::"+result);
			 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		
		
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
