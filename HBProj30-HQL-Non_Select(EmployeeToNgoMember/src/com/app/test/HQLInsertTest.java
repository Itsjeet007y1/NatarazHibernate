package com.app.test;

import com.app.dao.TransferDAO;
import com.app.dao.TransferDAOFactory;
import com.app.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		TransferDAO dao=null;
		int count=0;
		//get DAO
		dao=TransferDAOFactory.getInstance();
		//Make Employees as NGOs
		count=dao.makeEmployeesAsNGOs(100, 200);
		System.out.println("No.of Employees Joined:::"+count);
		//close Objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

