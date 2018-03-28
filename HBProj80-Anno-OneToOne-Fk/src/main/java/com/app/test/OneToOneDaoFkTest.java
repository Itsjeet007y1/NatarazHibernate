package com.app.test;

import com.app.dao.OneToOneDao;
import com.app.dao.OneToOneDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToOneDaoFkTest {
	public static void main(String[] args) {
		OneToOneDao dao=null;
		//get dao object from factory
		dao=OneToOneDaoFactory.getInstance();
		
		dao.saveDataUsingPassport();
		
		//close session object
		HibernateUtil.closeSessionFactory();
	}
}
