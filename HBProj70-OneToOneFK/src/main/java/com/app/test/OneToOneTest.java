package com.app.test;

import com.app.dao.OneToOneDao;
import com.app.dao.OneToOneDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToOneTest {
	public static void main(String[] args) {
		OneToOneDao dao=null;
		//get the dao from one to one dao factory class
		dao=OneToOneDaoFactory.getInstance();
		
		//dao.saveDataUsingLicense();
		//dao.loadDataUsingLicense();
		dao.deleteDataUsingLicense();

		
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
