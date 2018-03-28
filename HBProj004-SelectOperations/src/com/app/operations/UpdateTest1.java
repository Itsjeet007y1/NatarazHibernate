package com.app.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.Product;

public class UpdateTest1 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null; 
		Transaction tx=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		//load Cfg file
		cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		//Build Sesssion Factory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//Update object (partial object modification) (Version2)
		//load object
		prod=ses.get(Product.class,1020);
		if(prod!=null){
			prod.setPrice(6467);
		 try{
		  tx=ses.beginTransaction();
		    ses.update(prod);
		  tx.commit();
		  System.out.println("Object updated");
		 }
		 catch(Exception e){
			tx.rollback();
			System.out.println("Object not updated");
		 }
		}
		else{
			System.out.println("record not found");
		}

		//close objs
		ses.close();
		factory.close();
	}//main
}//class
