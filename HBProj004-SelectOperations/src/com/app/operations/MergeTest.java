package com.app.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.Product;

public class MergeTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		Product prd=null,prd1=null;
		//BootStrap Hibernate framework
		cfg=new Configuration();
		//load configuration file
		cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		//build sessionFactory object
		sf=cfg.buildSessionFactory();
		//open session object
		ses=sf.openSession();
		//prepare object
		prd=new Product();
		prd.setProductId(1012);
		prd.setProductName("Rin");
		prd.setQuantity(10);
		prd.setPrice(22);
		try {
			tx=ses.beginTransaction();
			prd1=(Product)ses.merge(prd);
			ses.merge(prd1);
			System.out.println("Object is saved/updated...");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		//close objects
		ses.close();
		sf.close();
	}
}
