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
		//get Object/Load object
		policy=(InsurancePolicy)ses.get(InsurancePolicy.class, 101);
		
		if(policy!=null){
			System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getPremium());
		}
		else{
			System.out.println("Object not found");
		}
		/*try{
		Thread.sleep(60000);
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
