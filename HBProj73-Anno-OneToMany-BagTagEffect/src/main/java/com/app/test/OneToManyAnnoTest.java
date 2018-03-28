package com.app.test;

import com.app.dao.OneToManyDao;
import com.app.dao.OneToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToManyAnnoTest {
	public static void main(String[] args) {
		OneToManyDao dao=null;
		//get the dao from one to one dao factory class
		dao=OneToManyDaoFactory.getInstance();
		
		dao.saveDataUsingUniversity();
	
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
