package com.app.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		//create Session factory object
		try {
			cfg=new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml");
			if(cfg!=null) {
				factory=cfg.buildSessionFactory();
			}
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//get Session object method
	public static Session getSession() {
		Session session=null;
		if(factory!=null) {
			session=factory.openSession();
		}
		return session;
	}
	//close session object method
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	//close session factory object method
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
