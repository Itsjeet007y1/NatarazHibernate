package com.app.test;

import com.app.controller.StudentController;
import com.app.utility.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		StudentController controller=null;
		String result=null;
		controller=new StudentController();
		result=controller.process(102, "Jeet", 78, 99, 88);
		System.out.println(result);
		//close session
		HibernateUtil.closeSession();
		//close Session Factory 
		HibernateUtil.closeSessionFactory();
	}
}
