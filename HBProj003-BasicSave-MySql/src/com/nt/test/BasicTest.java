package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class BasicTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Transaction tx=null;
		Session ses=null;
		 
		cfg=new Configuration();
		cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		ses=sf.openSession();
		tx=ses.beginTransaction();
		Employee emp=new Employee();
		emp.setEmpId(101);
		emp.setEmpName("Jeet");
		emp.setEmpSal(22.22);
		emp.setEmpMail("Jeet.62.jp@gmail.com");
		ses.save(emp);
		tx.commit();
		System.out.println("Done");
	}
}
