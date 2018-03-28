package com.app.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.app.domain.Employee;

public class Level2CacheTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session1=null;
		Query query=null;
		Employee e1=null;
		
		//get configuration object
		cfg=new Configuration().configure("com/app/cfgs/hibernate.cfg.xml");
		//get session factory object
		factory=cfg.buildSessionFactory();
		//get Session object
		session1=factory.openSession();
		
		//create query object
		query=session1.createQuery("from Employee");
		
		//query cache settings
		query.setCacheable(true);
		query.setCacheRegion("region1");   //enable and disable line 31 and 32 to see the effect of query cache
		
		List<Employee> elist1=query.list();
		elist1.forEach(el->{
			System.out.println("Employee:"+el.getNo()+"   "+el.getFname()+"  "+el.getLname()+"   "+el.getMail());
		});
		System.out.println("--------------------------------------------------------------");
		List<Employee> elist2=query.list();
		elist2.forEach(el->{
			System.out.println("Employee:"+el.getNo()+"   "+el.getFname()+"  "+el.getLname()+"   "+el.getMail());
		});
		//close objects
		session1.close();
		factory.close();
	}
}
