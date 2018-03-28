package com.app.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory factory;
	static {
		//create factory object
		Configuration cfg=null;
		try {
			cfg=new Configuration().configure("/com/app/cfgs/hibernateOracle.cfg.xml");
			if(cfg!=null)
				factory=cfg.buildSessionFactory();
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	//get Session object
	public static Session getSession() {
		Session session=null;
		if(factory!=null) {
			session=factory.openSession();
		}
		return session;
	}
	//close session object
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	//close session factory object
	public static void closeSessionFactory() {
		factory.close();
	}
}
