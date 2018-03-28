package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.app.domain.EmpDetails;
import com.app.utility.HibernateUtil;

public class QBCProjectionTest {

	public static void main(String[] args) {
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		//QBC with Projections to get Specific multiple col values
		Criteria criteria=ses.createCriteria(EmpDetails.class);
		//prepare Projections for specific col values
		Projection pj_no=Projections.property("no");
		Projection pj_name=Projections.property("mail");
		//add all Projections to ProjectionList
		ProjectionList pj_list=Projections.projectionList();
		pj_list.add(pj_no); pj_list.add(pj_name);
		//add ProjectionList to criteria
		criteria.setProjection(pj_list);
		//prepare and add condition
		Criterion cond=Restrictions.like("mail","%gmail.com");
		criteria.add(cond);
		//execute QBC logic
		List<Object[]>list=criteria.list();
		//process the result
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+"   ");
			}//for
			System.out.println();
		}//for
	
		
	/*//QBC logic for aggragations using Projections
		//prpeare Criteria object
		Criteria criteria=ses.createCriteria(EmpDetails.class);
		//Prepare Projections
		Projection pj_count=Projections.count("no");
		Projection pj_max=Projections.max("no");
		Projection pj_min=Projections.min("no");
		//Add Projections to ProjectionList
		ProjectionList pj_list=Projections.projectionList();
		pj_list.add(pj_count); pj_list.add(pj_max);pj_list.add(pj_min);
		//set ProjectionList to criteria
		criteria.setProjection(pj_list);
		//execute QBC
		List<Object[]> list=criteria.list();
		//process the result
		Object row[]=list.get(0);
		System.out.println("Records count::"+row[0]);
		System.out.println("max value of EID: "+row[1]);
		System.out.println("min value of EID: "+row[2]);*/
		
		/*//prepare Criteria object
		Criteria criteria=ses.createCriteria(EmpDetails.class);
		criteria.setFirstResult(1000);
		criteria.setMaxResults(3000);
		List<EmpDetails> list=criteria.list();
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		
		  //close Hibernate objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
