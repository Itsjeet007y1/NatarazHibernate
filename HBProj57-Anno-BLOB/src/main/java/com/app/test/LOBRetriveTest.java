package com.app.test;

import com.app.dao.LOBDAO;
import com.app.dao.LOBDAOFactory;
import com.app.domain.Employee;
import com.app.utility.FileUtility;
import com.app.utility.HibernateUtil;

public class LOBRetriveTest {

	public static void main(String[] args) {
		LOBDAO dao=null;
		Employee emp=null;
		java.sql.Clob clob=null;
		java.sql.Blob blob=null;
		//get DAO
		dao=LOBDAOFactory.getInstance();
		//invoke methods
		try{
		 emp=dao.loadData(1);
		 clob=emp.getEresume();
		 blob=emp.getEphoto();
		 System.out.println(emp.getEid()+"  "+emp.getEname()+" "+emp.getEaddrs());
		 System.out.println(FileUtility.createFileFromClob(clob, "resume1.txt"));
		 System.out.println(FileUtility.createFileFromBlob(blob, "javababa.jpg"));
		 
		}
		catch(Exception e){
			System.out.println("Problem in saving ");
			e.printStackTrace();
		}
		//close SEssion factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
