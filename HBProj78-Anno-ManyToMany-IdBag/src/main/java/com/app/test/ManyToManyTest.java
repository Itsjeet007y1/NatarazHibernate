package com.app.test;

import com.app.dao.ManyToManyDao;
import com.app.dao.ManyToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class ManyToManyTest {
	public static void main(String[] args) {
		ManyToManyDao dao;
		//get dao object from ManyToManyDaoFactory
		dao=ManyToManyDaoFactory.getInstance();
		
		dao.saveDataUsingPatient();
		
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
