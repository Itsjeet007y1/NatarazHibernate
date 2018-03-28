package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurencePolicy;

public class LoadOperation {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		InsurencePolicy policy=null;
		//start hibernate
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//get session object
		sf=cfg.buildSessionFactory();
		ses=sf.openSession();
		//get object/load object
		policy=ses.load(InsurencePolicy.class, 1001);
		if(policy!=null) {
			System.out.println(policy.getPolicyId()+","+policy.getPolicyName()+","+policy.getTenure()+","+policy.getPremium());
		}
		else {
			System.out.println("Objec not Found");
		}
		ses.close();
		sf.close();
	}
}
