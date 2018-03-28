package com.app.test;

import com.app.dao.OneToManyDao;
import com.app.dao.OneToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToManyTest {
	public static void main(String[] args) {
		OneToManyDao dao=null;
		//get Dao object
		dao=OneToManyDaoFactory.getInstance();
		
		//dao.SaveDataUsingParents();
		//dao.SaveDataUsingChilds();
		//dao.loadUsingParents();
		dao.loadDataUsingChilds();
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
