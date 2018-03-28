package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.app.bo.EmployeeBO;
import com.app.utility.HibernateUtil;
import com.app.utility.ReportParameters;

public class EmployeeDaoImpl implements EmployeeDao {

	public long getEmployeeCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection pj_count=null;
		List<Object> list=null;
		long count=0;
		 //get HB Session
		ses=HibernateUtil.getSession();
		//write QBC logic
		criteria=ses.createCriteria(EmployeeBO.class);
		pj_count=Projections.rowCount();
		criteria.setProjection(pj_count);
		list=criteria.list();
		count=(Long)list.get(0);
		return count; 
	}

	public List<EmployeeBO> getEmployeeDetails(int startPos) {
		Session ses=null;
		Criteria criteria;
		List<EmployeeBO> listBO=null;
		 // get Session
		ses=HibernateUtil.getSession();
		//write QBC logic
		criteria=ses.createCriteria(EmployeeBO.class);
		//set pagination params
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(ReportParameters.PAGE_SIZE);
		//execute QBC
		listBO=criteria.list();
		return listBO;
	}
}
