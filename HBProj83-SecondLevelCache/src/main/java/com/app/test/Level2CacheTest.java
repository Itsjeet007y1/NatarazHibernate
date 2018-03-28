package com.app.test;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.domain.Employee;

public class Level2CacheTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session1=null,session2=null;
		Employee e1=null,e2=null,e3=null,e4=null,e5=null,e6=null,e7=null;
		
		//get configuration object
		cfg=new Configuration().configure("com/app/cfgs/hibernate.cfg.xml");
		//get session factory object
		factory=cfg.buildSessionFactory();
		//get Session object
		session1=factory.openSession();
		session2=factory.openSession();
		
		//load object from database and put it in levele1(session) cache and level2(session factory) cache
		e1=session1.load(Employee.class, 334);
		System.out.println(e1);
		
		//load object from level1 cache
		e2=session1.load(Employee.class, 334);
		System.out.println(e2);
		
		//load object from level2(session factory cache) and keep it in session2(level1) cache
		e3=session2.load(Employee.class, 334);
		System.out.println(e3);
		
		//load L1 cache of session1
		e4=session2.get(Employee.class, 334);
		System.out.println(e4);
		
		//remove object from L1 cache (session1)
		session1.evict(e1);
		
		//remove object from L2 cache (session2)
		session2.evict(e2);
		
		//load object from level2 cache and keep in level1 cache (session1)
		e5=session1.load(Employee.class, 334);
		System.out.println("e5:"+e5);
		
		//remove from L1 cache
		System.out.println("E5: now l2 will clear");
		//session1.evict(e5);
		
		//remove from session factory cache Level2
		Cache cache=factory.getCache();
		cache.evictAllRegions();
		
		//load object from db and keep it in L2 and L1 cache
		e6=session1.load(Employee.class, 334);
		System.out.println(e6);
		
		//Remove from L1 cache
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//load data (get from database load in L2 and L1)
		e7=session1.load(Employee.class, 334);
		System.out.println(e7);
		
		//close objects
		session1.close();
		session2.close();
		factory.close();
	}
}
