package com.app.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.Product;

public class DeleteTest1 {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		//BootStrap hibernate framework
		cfg=new Configuration();
		//load hibernate configuration file
		cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		//build session factory object
		sf=cfg.buildSessionFactory();
		//open session using session factory object
		ses=sf.openSession();
		//load object
		Product prd=new Product();
		System.out.println("Before Load: "+prd.hashCode());
		prd=ses.load(Product.class, 109);
		System.out.println("After Load:"+prd.hashCode());
		if(prd!=null) {
			try {
				tx=ses.beginTransaction();
				ses.delete(prd);
				tx.commit();
				System.out.println("Object deleted successfully...");
			} catch(Exception e) {
				tx.rollback();
				System.out.println("Object not found..");
			}
		}
		ses.close();
		sf.close();
	}
}
