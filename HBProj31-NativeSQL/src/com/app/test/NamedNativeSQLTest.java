package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.domain.EmpDetails;
import com.app.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		  //get Session
		ses=HibernateUtil.getSession();
		//get Accesss to Named Native SQL Queries and execute them
		//For Query1
		Query query1=ses.getNamedQuery("GET_EMPS_BY_RANGE");
		query1.setInteger("min",1000);
		query1.setInteger("max",3000);
		List<EmpDetails> list1=query1.list();
		for(EmpDetails ed:list1){
			System.out.println(ed);
		}
	//For Query2
		Query query2=ses.getNamedQuery("GET_EMPS_COUNT");
		List<Integer> list2=query2.list();
		int count=list2.get(0);
		System.out.println("Emp count:::"+count);
		
 
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
	}//main
}//class
