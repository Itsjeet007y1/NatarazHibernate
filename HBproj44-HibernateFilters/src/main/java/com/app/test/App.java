package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.app.domain.EmpDetails;
import com.app.utility.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		List<EmpDetails> list=null;
		List<Object> list1=null;
		Criteria criteria=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//enable filter and set parameter values
		   filter=ses.enableFilter("FIND_EMP_BY_RANGE");
		   filter.setParameter("min",1000);
		   filter.setParameter("max",3000);
		 //execute NativeSQL logics
		   query=ses.createQuery("from EmpDetails");
		   list=query.list();
		   for(EmpDetails ed:list){
			   System.out.println(ed.getNo()+"   "+ed.getFirstName()+"   "+ed.getLastName()+"   "+ed.getMail());
		   }
		   
		   
  /*      //execute QBC logics
		   criteria=ses.createCriteria(EmpDetails.class);
		   list=criteria.list();
		   for(EmpDetails ed:list){
			   System.out.println(ed);
		   }*/
		   
		   
/*		  //execute logics (HQL)
		 query=ses.createQuery("from EmpDetails");
		 list=query.list();
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 
		 //disable filter
		 ses.disableFilter("EMPS_BY_RANGE");
		 query=ses.createQuery("select count(*) from EmpDetails");
		 list1=query.list();
		 System.out.println("Records count:::"+list1.get(0));
*/		 
		 //close objs
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
		
	}

}
