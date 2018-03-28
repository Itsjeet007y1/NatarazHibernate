package com.app.test;

import com.app.dao.OneToManyDao;
import com.app.dao.OneToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToManyTest {
	public static void main(String[] args) {
		OneToManyDao dao=null;
		//get Dao object
		dao=OneToManyDaoFactory.getInstance();
		
		dao.loadDataUisngParentsAndJoins();
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
