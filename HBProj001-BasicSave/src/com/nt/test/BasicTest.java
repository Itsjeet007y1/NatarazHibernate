package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		
		//activate hibernate framework (BootStrapping hibernate)
		cfg=new Configuration();
		
		//load and read both xml files
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//build Session Factory
		sf=cfg.buildSessionFactory();
		
		//open session
		ses=sf.openSession();
		
		//Prepare transaction object
		tx=ses.beginTransaction();
		
		//prepare domain class objec having data
		EmpDetails emp=new EmpDetails();
		emp.setFname("Jitendra");
		emp.setLname("Kumar");
		emp.setMail("con2Jitendra@gmail.com");
		
		EmpDetails emp1=new EmpDetails();
		emp1.setFname("Sonal");
		emp1.setLname("Kumar");
		emp1.setMail("Sonal123@gmail.com");
		
		//insert or update the data
		ses.save(emp);
		ses.save(emp1);
		tx.commit();
		ses.flush();
		//close all the connections
		ses.close();
		sf.close();
	}
}
