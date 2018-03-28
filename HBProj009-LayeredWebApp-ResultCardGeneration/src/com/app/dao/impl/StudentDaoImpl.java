package com.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.bo.StudentBO;
import com.app.dao.IStudentDao;
import com.app.utility.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public int insert(StudentBO bo) throws Exception {
		Session session=null;
		int id=0;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			id=(int)session.save(bo);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}
}
