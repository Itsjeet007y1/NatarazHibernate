package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.LibraryMembership;
import com.app.domain.Student;
import com.app.utility.HibernateUtil;

public class OneToOneDaoImpl implements OneToOneDao {

	@Override
	public void saveDataUsingStudent() {
		Session session=null;
		Student std=null;
		boolean flag=false;
		LibraryMembership lm=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//prepare parent and child object
		std=new Student();
		std.setSname("Jitendra");
		//std.setSid(101);
		std.setAddress("Fatehpur");
		lm=new LibraryMembership();
		//lm.setLid(11);
		lm.setDoj(new Date());
		//map child to parent and parent to child
		std.setLibraryDetails(lm);
		lm.setStudentDetails(std);
		try {
			tx=session.beginTransaction();
			session.save(std);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Object saved..");
			} else {
				tx.rollback();
			}
			//close the session object
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public void saveDataUsingLibraryMembership() {
		Session session=null;
		Student std1=null;
		LibraryMembership lib=null;
		boolean flag=false;
		Transaction tx=null;
		//Get session object
		session=HibernateUtil.getSession();
		//prepare child and parent object
		std1=new Student();
		std1.setSname("Dharmendra");
		std1.setAddress("Fatehpur");
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		//map parent to child and child to parent
		std1.setLibraryDetails(lib);
		lib.setStudentDetails(std1);
		try {
			tx=session.beginTransaction();
			session.save(lib);
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
				System.out.println("Objects are saved..");
			} else {
				tx.rollback();
				System.out.println();
				System.out.println("Objects are not saved..");
			}
		}
	}

	@Override
	public void loadDataUsingStudent() {
		Session session=null;
		List<Student> stdList=null;
		Query query=null;
		//get session object
		session=HibernateUtil.getSession();
		//load all parents
		query=session.createQuery("from Student");
		stdList=query.list();
		//display data
		stdList.forEach(s-> {
			System.out.println("parent:"+s.getSid()+"   "+s.getSname()+"   "+s.getAddress());
			//get child of each parent
			LibraryMembership lib=null;
			lib=s.getLibraryDetails();
			System.out.println("Child:"+lib.getLid()+"   "+lib.getDoj());
		});
	}

	@Override
	public void loadDataUsingLibraryMembership() {
		Session session=null;
		Query query=null;
		List<LibraryMembership> libList=null;
		
		//get session object
		session=HibernateUtil.getSession();
		//load parents
		query=session.createQuery("from LibraryMembership");
		libList=query.list();
		libList.forEach(c-> {
			System.out.println("Child-->"+c.getLid()+"   "+c.getDoj());
			Student std=null;
			std=c.getStudentDetails();
			System.out.println("Parent-->"+std.getSid()+"   "+std.getSname()+"   "+std.getAddress());
		});//forEach method
	}//method

	@Override
	public void delteDataUsingStudent() {
		Session session=null;
		Student std=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//load parent object
		std=session.get(Student.class, 3);
		//delete parent object
		try {
			tx=session.beginTransaction();
			session.delete(std);
			tx.commit();
			System.out.println("Object is deleted..");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delteDataUsingLibraryMembership() {
		Session session=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//load child object
		lib=session.get(LibraryMembership.class, 2);
		//delete the child  and associated parent if cascade value is all
		try {
			tx=session.beginTransaction();
			session.delete(lib);
			tx.commit();
			System.out.println("Object deleted..");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void deleteLibraryMembershipOfAStudent() {
		Session session=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		//get session object
		session=HibernateUtil.getSession();
		//create query object for specific deletion operation
		query=session.createQuery("delete from LibraryMembership where lid=:id");
		try {
			tx=session.beginTransaction();
			query.setParameter("id", 1);
			result=query.executeUpdate();
			tx.commit();
			System.out.println("Record "+result+" deleted..");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.getMessage();
			tx.rollback();
		}
	}

}
