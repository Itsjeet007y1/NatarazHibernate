package com.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.bo.StudentBO;
import com.app.dao.IStudentDao;
import com.app.utility.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int insert(StudentBO bo) {
		Session session=null;
		Transaction tx=null;
		int no=0;
		session=HibernateUtil.getSession();
		//save object
		try {
			tx=session.beginTransaction();
			no=(Integer)session.save(bo);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return no;
	}
}
