package com.app.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.Product;

public class SynchronizationTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		//BootStrap hibernate
		cfg=new Configuration();
		//load hibernate configuration file
		cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		//build session factory object
		sf=cfg.buildSessionFactory();
		//open session object
		ses=sf.openSession();
		try {
			//create product class object and fetch the records
			Product prd=new Product();
			//create Transaction object
			tx=ses.beginTransaction();
			prd=ses.get(Product.class, 1011);
			tx.commit();
			System.out.println(prd.getProductId());
			System.out.println(prd.getProductName());
			System.out.println(prd.getQuantity());
			System.out.println(prd.getPrice());
		} catch(Exception e) {
			tx.rollback();
		}
		ses.close();
		sf.close();
	}
}
