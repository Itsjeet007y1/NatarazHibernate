package com.app.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	//get factory object
	static {
		factory=new Configuration().configure("com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}
	//get session object method
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
	//close session object
	public static void closeSession() {
		if(threadLocal.get()!=null) {
			threadLocal.get().close();
			threadLocal.remove();
		}
	}
	//close session factory object
	public static void closeSessionFactory() {
		factory.close();
	}
}
