package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.domain.InsurancePolicy;

public class GetOperationTest {
	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		//get Session object
		factory=new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get SEssion
		ses=factory.openSession();
		//prepare and set insurance policy values
		InsurancePolicy policy1=new InsurancePolicy();
		policy1.setPolicyId(1003);policy1.setPolicyName("Hello2");policy1.setPremium(101);policy1.setTenure(506);
		ses.save(policy1);
		//get Object/Load object
		policy=ses.get(InsurancePolicy.class, 1003);
		if(policy!=null){
			System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getPremium());
		}
		else{
			System.out.println("Object not found");
		}
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
