package com.app.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static{
		Configuration cfg=null;
		try{
          //create SessionFactory object			
		 cfg=new Configuration();
		 cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
		 //cfg=cfg.configure("/com/nt/cfgs/hibernate-mysql.cfg.xml");
		  if(cfg!=null)
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
