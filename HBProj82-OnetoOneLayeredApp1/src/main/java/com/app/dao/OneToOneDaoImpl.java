package com.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Student;
import com.app.dto.StudentDTO;
import com.app.utility.HibernateUtil;

public class OneToOneDaoImpl implements OneToOneDao {

	public static final String GET_ALL_STUDENT_AND_THEIR_LIBRARYDETAILS="from Student";
	
	@Override
	public List<Student> getAllStudentsAndTheirLibraryMembershipDetails() {
		Session session=null;
		Query query=null;
		List<Student> studentDomain=null;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare query object
		query=session.createQuery(GET_ALL_STUDENT_AND_THEIR_LIBRARYDETAILS);
		studentDomain=query.list();
		return studentDomain;
	}

	@Override
	public int insertStudentWithLibraryDetails(Student std) {
		Session session=null;
		Transaction tx=null;
		int sid=0;
		//get session object
		session=HibernateUtil.getSession();
		//save the object
		try {
			//begin Transaction
			tx=session.beginTransaction();
			sid=(Integer)session.save(std);
			tx.commit();
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return sid;
	}

	@Override
	public int deleteStudentWithLibraryDetails(int sno) {
		Session session=null;
		Student std=null;
		Transaction tx=null;
		//get Session object
		session=HibernateUtil.getSession();
		//get the object from student
		std=session.get(Student.class, sno);
		//delete the object
		try {
			//begin Transaction 
			tx=session.beginTransaction();
			session.delete(std);
			tx.commit();
			return 1;
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			return 0;
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		}
	}
}
