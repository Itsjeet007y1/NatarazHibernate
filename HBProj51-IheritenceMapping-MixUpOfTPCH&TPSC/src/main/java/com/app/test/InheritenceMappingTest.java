package com.app.test;

import org.hibernate.HibernateException;

import com.app.dao.PersonDao;
import com.app.dao.PersonDaoFactory;
import com.app.utility.HibernateUtil;

public class InheritenceMappingTest {
	public static void main(String[] args) {
		

		PersonDao dao=null;
		String result=null;
		//get instance of dao from daofactory
		dao=PersonDaoFactory.getInstance();
		//save the object
		try {
			result=dao.savePerson();
			System.out.println(result);
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close session factory object
			HibernateUtil.closeSessionFactory();
		}
		
		
		/*// TO Retrieve Person Data
			
		//get dao object from dao factory
		PersonDao dao=null;
		List<Person> list=null;
		List<Employee> list1=null;
		List<Customer> list2=null;
		dao=PersonDaoFactory.getInstance();
		//get Person data
		try {
			list=dao.getPerson();
			System.out.println("-----------------------------------------------------------");
			System.out.println("Getting Person Details");
			System.out.println("-----------------------------------------------------------");
			list.forEach(p-> {
				System.out.println(p.getId()+"-------"+p.getName()+"-------"+p.getCompany());
			});
			System.out.println("-----------------------------------------------------------");
			System.out.println("Getting Employee Details");
			System.out.println("-----------------------------------------------------------");
			list1=dao.getEmployee();
			list1.forEach(e-> {
				System.out.println(e.getId()+"-------"+e.getName()+"-------"+e.getCompany()+"-------"+e.getDesg()+"-------"+e.getSalary());
			});
			System.out.println("-----------------------------------------------------------");
			System.out.println("Getting Customer Details");
			System.out.println("-----------------------------------------------------------");
			list2=dao.getCustomer();
			list2.forEach(c-> {
				System.out.println(c.getId()+"-------"+c.getName()+"--------"+c.getCompany()+"--------"+c.getAddrs()+"---------"+c.getBillAmt());
			});
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
	}	
}
