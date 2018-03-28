package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		Employee emp=new Employee();
		emp.setEmpNo(700);
		emp.setEmpName("Itsjeet");
		emp.setEmpSal(22.22);
		emp.setEmpMail("jeet.62.jp@gmail.com");
		ses.save(emp);
		tx.commit();
		ses.close();
		sf.close();
	}
}
