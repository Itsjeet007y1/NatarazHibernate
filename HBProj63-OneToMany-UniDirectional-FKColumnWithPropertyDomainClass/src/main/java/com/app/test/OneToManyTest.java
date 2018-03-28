package com.app.test;

import com.app.dao.OneToManyDao;
import com.app.dao.OneToManyDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToManyTest {
	public static void main(String[] args) {
		OneToManyDao dao=null;
		//get Dao
		dao=OneToManyDaoFactory.getInstance();
		/*1.save objects*/
		dao.saveDataUsingParent();

		/*2.fethc data using parent*/
		//dao.loadDataUsingParent();
		
		/*3.delete parent and its related child data*/
		//dao.deleteDataUsingParent();
		
		/*4.delete One Child From Collection Of Childs In A Parent*/
		//dao.deleteOneChildFromCollectionOfChildsInAParent();
		
		/*5.addinng new child to existing parent*/
		//dao.addingNewChildToExistingParent();
		
		/*6.delete all childs of a parent*/
		//dao.deleteAllChildsOfAParent();
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
