package com.app.test;

import com.app.dao.OneToOneDao;
import com.app.dao.OneToOneDaoFactory;
import com.app.utility.HibernateUtil;

public class OneToOneTest {
	public static void main(String[] args) {
		OneToOneDao dao=null;
		//get the dao from one to one dao factory class
		dao=OneToOneDaoFactory.getInstance();
		
		//dao.saveDataUsingStudent();
		//dao.saveDataUsingLibraryMembership();
		//dao.loadDataUsingStudent();
		//dao.loadDataUsingLibraryMembership();
		//dao.delteDataUsingStudent();
		//dao.delteDataUsingLibraryMembership();
		dao.deleteLibraryMembershipOfAStudent();
		
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
