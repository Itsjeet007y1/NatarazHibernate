package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Employee;
import com.app.utility.HibernateUtil;

public class TestClient {
	public static void main(String[] args) {
		Employee emp=null;
		Transaction tx=null;
		Session session=null;
		//set the values
		emp=new Employee();
		emp.setEmpNo(999);
		emp.setEmpName("Rahul");
		emp.setEmpSal(22.22);
		emp.setEmpMail("jeet.62.jp@gmail.com");
		//save the value
		session=HibernateUtil.getSession();
		//begin transaction
		tx=session.beginTransaction();
		int id=(int)session.save(emp);
		if(id!=0) {
			System.out.println("Saved with id: "+id);
		} else 
			System.out.println("Some problem occured");
	}
}
