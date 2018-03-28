package com.app.dao;

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
		Set<College> children=null;
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
		
		children=new HashSet<College>();
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

	@Override
	public void loadDataUsingUniversity() {
		Session session=null;
		Query query=null;
		List<University> list=null;
		//get session object
		session=HibernateUtil.getSession();
		//prepare query object
		query=session.createQuery("from University");
		//execute query
		list=query.list();
		list.forEach(u-> {
			System.out.println("Parents==>"+u.getUnid()+"  "+u.getName()+"  "+u.getRegion());
			//get associated colleges
			Set<College> clist=new HashSet<College>();
			clist=u.getColleges();
			clist.forEach(c-> {
				System.out.println("Childs or Colleges=>"+c.getCid()+"  "+c.getName()+"  "+c.getLocation());
			});
		});
	}

	@Override
	public void loadDataUsingUniversityWithQBC() {
		Session session=null;
		Criteria criteria=null;
		List<University> ulist=null;
		//get session object
		session=HibernateUtil.getSession();
		//create criteria
		criteria=session.createCriteria(University.class);
		//execute criterial object
		ulist=criteria.list();
		//get child and parent objects
		ulist.forEach(u-> {
			System.out.println("Universities=>"+u.getUnid()+"   "+u.getName()+"  "+u.getRegion());
			//get colleges
			Set<College> clist=new HashSet<College>();
			clist=u.getColleges();
			clist.forEach(c-> {
				System.out.println("Colleges=>"+c.getCid()+"   "+c.getName()+"   "+c.getLocation());
			});
		});
	}

	@Override
	public void deleteDataUsingUniversity() {
		University university=null;
		Session session=null;
		Transaction tx=null;
		Set<College> children=null;
		//get Session object
		session=HibernateUtil.getSession();
		//load parent object
		university=session.get(University.class, 1);
		//get associated children or colleges
		children=university.getColleges();
		//delete parent
		try {
			tx=session.beginTransaction();
			session.delete(university);
			tx.commit();
			System.out.println("Object with associated children deleted..");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void deleteCollegesOfUniversity() {
		Session session=null;
		University uni=null;
		Transaction tx=null;
		Set<College> child=null;
		//get Session object
		session=HibernateUtil.getSession();
		//load parent object
		uni=session.get(University.class, 1);
		//get associate child of parent
		child=uni.getColleges();
		//delete children
		try {
			tx=session.beginTransaction();
			child.removeAll(child);
			tx.commit();
			System.out.println("All children of associated parent deleted..");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
