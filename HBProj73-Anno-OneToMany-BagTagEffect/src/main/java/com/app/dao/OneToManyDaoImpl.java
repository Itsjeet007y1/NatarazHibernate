package com.app.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.College;
import com.app.domain.University;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void saveDataUsingUniversity() {
		Session session=null;
		University university=null;
		College college1,college2=null; //error may be
		List<College> children=null;
		boolean flag=false;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//prepare parent child object
		university=new University();
		university.setName("JNTUH");
		university.setRegion("Telangana");
		
		college1=new College();
		college1.setName("CBIET");
		college1.setLocation("Gandipet-Hyd");
		
		college2=new College();
		college2.setName("MREC");
		college2.setLocation("Komapally-Hyd");
		
		children=new ArrayList<College>();
		children.add(college1);
		children.add(college2);
		
		//set children to parent
		university.setColleges(children);
		try {
			tx=session.beginTransaction();
			session.save(university);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Parent and associated objects saved successfully...");
			} else {
				tx.rollback();
				System.out.println("Some problem occured. Please check..");
			}
		}
	}
}
