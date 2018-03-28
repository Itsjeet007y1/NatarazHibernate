package com.app.utitlity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	//public static ThreadLocal<Session> threadLocal=new ThreadLocal();
	public static SessionFactory factory;
	static {
		factory=new Configuration().configure("com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}
	public static Session getSession() {
		Session session=null;
		if(threadLocal.get()==null) {
			session=factory.openSession();
			threadLocal.set(session);
		} else {
			session=threadLocal.get();
		}
		return session;
	}
	public static void closeSession() {
		Session session=null;
		if(threadLocal.get()!=null) {
			session=threadLocal.get();
			session.close();
			threadLocal.remove();
		}
	}
	public static void closeSessionFactory() {
		factory.close();
	}
}
