package com.app.test;

import com.app.dao.ManyToManyDao;
import com.app.dao.ManyToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class ManyToManyWithIdBagTest {

	public static void main(String[] args) {
		ManyToManyDao dao=null;
		//get dao object from factory	
		dao=ManyToManyDaoFactory.getInstance();
		
		/*save the object using parent*/
		//dao.saveDataUsingParent();
		
		/*save objec using child*/
		dao.saveDataUsingChild();
		
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
