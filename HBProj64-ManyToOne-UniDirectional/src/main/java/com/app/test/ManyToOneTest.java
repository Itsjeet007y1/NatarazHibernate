package com.app.test;

import com.app.dao.ManyToOneDao;
import com.app.dao.ManyToOneDaoFactory;

public class ManyToOneTest {
	public static void main(String[] args) {
		ManyToOneDao dao=null;
		//get dao object from factory 
		dao=ManyToOneDaoFactory.getInstance();
		
		/*save the object*/
		//dao.saveDataUsingChilds();
		
		/*get data using child*/
		//dao.loadDataUsingChilds();
		
		/*delete childs and its associated parents*/
		//dao.deleteDataUsingChilds();
		
		/*delete one child of a parent*/
		//dao.deleteOneChildOfAParent();
		
		/*add new child to existing parent*/
		//dao.addExistingChildToNewDepartment();
		
		/*delete one parent and all associated child objects*/
		dao.deleteAllChildsOfAParent();
	}
}
