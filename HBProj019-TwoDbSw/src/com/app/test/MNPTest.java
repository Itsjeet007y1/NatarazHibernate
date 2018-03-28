package com.app.test;

import com.app.service.MobileNumberPortabilityService;
import com.app.service.MobileNumberPortabilityServiceFactory;
import com.app.utility.HibernateUtilMySql;
import com.app.utility.HibernateUtilOracle;


public class MNPTest {

	public static void main(String[] args) {
		MobileNumberPortabilityService service=null;
	  //get Service class object
		service=MobileNumberPortabilityServiceFactory.getInstance();
	  //use service
		System.out.println(service.performMNP(8406088590L));
		//close factories
	  HibernateUtilOracle.closeSessionFactory();
	  HibernateUtilMySql.closeSessionFactory();
	}//main
}//class