package com.app.test;

import com.app.dao.ManyToManyDao;
import com.app.dao.ManyToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class ManyToManyTest {
	public static void main(String[] args) {
		ManyToManyDao dao;
		//get dao object from ManyToManyDaoFactory
		dao=ManyToManyDaoFactory.getInstance();
		
		/*save the object using Programmers*/
		dao.saveDataUsingProgrammer();
		
		/*save objects using projects*/
		//dao.saveDataUsingProject();
		
		/*add parent data to existing child*/
		//dao.addNewParentToExistingChild();
		
		/*changing existing programmer to another existing project*/
		//dao.changingExistingProgrammerToExistingProject();
		
		/*load data using parent*/
		//dao.loadObjectUsingParent();
		
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
