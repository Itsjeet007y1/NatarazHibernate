package com.app.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		try {
			//create session factory object
			cfg=new Configuration();
			cfg=cfg.configure("/com/app/cfgs/hibernate.cfg.xml");
			if(cfg!=null) {
				factory=cfg.buildSessionFactory();
			}
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
	public static Session getSession() {
		Session session=null;
		if(factory!=null) {
			session=factory.openSession();
		}
		return session;
	}
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
}
