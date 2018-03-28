package com.app.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		cfg=new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
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
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
