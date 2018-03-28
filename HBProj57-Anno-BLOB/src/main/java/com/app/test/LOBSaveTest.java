package com.app.test;

import org.hibernate.LobHelper;

import com.app.dao.LOBDAO;
import com.app.dao.LOBDAOFactory;
import com.app.domain.Employee;
import com.app.utility.HibernateUtil;

public class LOBSaveTest {

	public static void main(String[] args) {
		LOBDAO dao=null;
		Employee emp=null;
		byte bytes[]=null;
		java.sql.Blob blob=null;
		LobHelper helper=null;
		int id=0;
		//get DAO
		dao=LOBDAOFactory.getInstance();
		//prepare Domain class objects
		emp=new Employee();
		emp.setEname("raja");
		emp.setEaddrs("hyd");
		//use DAO method
		try{
		id=dao.saveData(emp,"C:\\Users\\Jitendra\\Desktop\\james.jpg",
					         "C:\\Users\\Jitendra\\Desktop\\resume.txt");
		 System.out.println("emp saved with "+id);
		}
		catch(Exception e){
			System.out.println("Problem in saving ");
			e.printStackTrace();
		}
		//close SEssion factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
