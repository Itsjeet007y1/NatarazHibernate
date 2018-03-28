package com.app.test;

import com.app.dao.OneToManyDao;
import com.app.dao.OneToManyDaoFactory;

public class OneToManyTest {
	public static void main(String[] args) {
		OneToManyDao dao=null;
		//get dao
		dao=OneToManyDaoFactory.getInstance();
		//save object
		//dao.SaveDataUsingParents();
		//dao.loadDataUsingParent();
		dao.deleteOneChildFromCollectionOfChildsInAParent();
	}
}
