package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.domain.InsurancePolicy;

public class SaveOperationTest {
	public static void main(String[] args) {
		InsurancePolicy ip=null;
		Session session=null;
		Transaction tx=null;
		//get session object
		session=new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory().openSession();
		tx=session.beginTransaction();
		//prepare ip object
		ip=new InsurancePolicy();
		ip.setPolicyId(102	);
		ip.setPolicyName("Jivan");
		ip.setPremium(01);
		ip.setTenure(9);
		int id=(int)session.save(ip);
		tx.commit();
		System.out.println("Objec saved id:"+id);
	}
}
