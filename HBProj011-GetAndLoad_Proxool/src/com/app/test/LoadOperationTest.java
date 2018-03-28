package com.app.test;

import java.util.Arrays;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.app.domain.IInsurancePolicy;
import com.app.domain.InsurancePolicy;



public class LoadOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		//InsurancePolicy policy=null;
		IInsurancePolicy ipolicy=null;
		//create SessionFactory
		factory=new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//create Session 
		ses=factory.openSession();
		//load object
		try{
		ipolicy=(InsurancePolicy)ses.load(InsurancePolicy.class,101);
		System.out.println(ipolicy.getPolicyId()+" "+ipolicy.getPolicyName()+" "+ipolicy.getTenure()+" "+ipolicy.getPremium());
		}
		catch(ObjectNotFoundException onfe){
			System.out.println("Record not found");
		}

		//close objs
		ses.close();
		factory.close();
		
		

	}

}
