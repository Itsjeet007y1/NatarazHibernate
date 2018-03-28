package com.app.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static{
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder=null;
		StandardServiceRegistry registry=null;
		try{
          //create SessionFactory object			
		 cfg=new Configuration();
		 cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		//create service Builder
		 builder=new StandardServiceRegistryBuilder();
		 //create service Registry
		 registry=builder.applySettings(cfg.getProperties()).build();
		 //create session factory
		 factory=cfg.buildSessionFactory();	
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	   }//static
	
	public static void closeSessionFactory(){
		if(factory!=null)
			factory.close();
	}
	
	public static Session getSession(){
		Session ses=null;
		if(factory!=null){
			ses=factory.openSession();
		}
		return ses;
	}
	
	public static void closeSession(Session ses){
		if(ses!=null){
			ses.close();
		}
	}

}
