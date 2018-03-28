package com.app.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.app.domain.Product;

public class DeleteTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Transaction tx=null;
		Session ses=null;
		Product prd=null;
		//BootStrap hibernate
		cfg=new Configuration();
		//load configuration file
		cfg.configure("com/app/cfgs/hibernate.cfg.xml");
		//build session factory object
		sf=cfg.buildSessionFactory();
		//create session
		ses=sf.openSession();
		//delete object version 1
		
		/*prd=new Product();
		prd.setProductId(102);
		try {
			tx=ses.beginTransaction();
			ses.delete(prd);
			tx.commit();
			System.out.println("Object Deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Object not found");
		}*/
		
		
		/*//For inserting the data in database
		prd=new Product();
		prd.setProductId(108);
		prd.setProductName("Hello");
		prd.setQuantity(5);
		prd.setPrice(50);
		tx=ses.beginTransaction();
		ses.save(prd);
		tx.commit();
		System.out.println("Saved..");*/
		
		
		//delete version 2
		//get object
		prd=new Product();
		System.out.println("Before Getting:"+prd.hashCode());
		prd=ses.get(Product.class, 111);
		//System.out.println("After Getting:"+prd.hashCode());
		if (prd!=null) {
			System.out.println("After Getting:" + prd.hashCode());
			try {
				tx = ses.beginTransaction();
				ses.delete(prd);
				tx.commit();
				System.out.println("Object deleted..");
			} catch (Exception e) {
				tx.rollback();
			} 
		} else {
			System.out.println("object not found");
		}
	}
}
