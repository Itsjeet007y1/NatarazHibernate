package com.app.Test;

import com.app.dao.EmployeeDAOFactory;
import com.app.dao.IEmployeeDao;
import com.app.domain.Employee;
import com.app.utility.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		IEmployeeDao dao=EmployeeDAOFactory.getInstance();
		//perform operations
		//int id=dao.register(106, "Jeet", 22.22, "jeet@gmail.com");
		//System.out.println(id);
		/*System.out.println(dao.search(101));*/
		Employee emp=new Employee();
		emp=dao.search(102);
		System.out.println("ID: "+emp.getEmpId());
		System.out.println("Name: "+emp.getEmpName());
		System.out.println("Sal: "+emp.getEmpSal());
		System.out.println("Email: "+emp.getEmpMail());
		emp.getEmpMail();
		//dao.remove(101);
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
