package com.app.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.app.domain.Customer;
import com.app.utility.HibernateUtil;

public class CriteriaAPITest {
	public static void main(String[] args) {
		Session session=null;
		List<Customer> list=null;
		Criteria criteria=null;
		//get Session object
		session=HibernateUtil.getSession();
		//create QBC logic
		criteria=session.createCriteria(Customer.class);
		//execute logic
		list=criteria.list();
		
		//process the results
		/*for(Customer c: list) {
			System.out.println(c.getId()+"   "+c.getFirstName()+"   "+c.getLastName());
		}*/
		
		/*//QBC logic with condition
		criteria=session.createCriteria(Customer.class);
		//prepare and add condition
		Criterion cond=Restrictions.between("id", 1, 10);
		criteria.add(cond);
		//Execute QBC logic and process result
		list=criteria.list();
		list.forEach(c-> {
			System.out.println(c.getId()+"   "+c.getFirstName()+"   "+c.getLastName());
		});*/
		
		/*//QBC logic with multiple conditions
		criteria=session.createCriteria(Customer.class);
		//prepare and add condition
		Criterion cond1=Restrictions.ge("id", 20);
		Criterion cond2=Restrictions.le("id", 10);
		Criterion cond3=Restrictions.ilike("lastName","%S");
		//prepare and condition
		Criterion andCond=Restrictions.and(cond1, cond2);
		//prepare or Condition
		Criterion orCond=Restrictions.or(andCond, cond3);
		//add final condition to criteria object
		criteria.add(orCond);
		//Execute QBC logic and process result
		list=criteria.list();
		list.forEach(c-> {
			System.out.println(c.getId()+"   "+c.getFirstName()+"   "+c.getLastName());
		});*/
		
		/*//prepare QBc logic with conditions and Order clauses
		 criteria=session.createCriteria(Customer.class);
	   //prepare condition
		 //Criterion cond=Restrictions.in("lastName",new String[]{"rao","chari"});
		 Criterion cond=Restrictions.in("lastName", "Williams","Davis");
		 //add condition
		 criteria.add(cond);
		 //prepare Order
		 Order order=Order.desc("lastName");
		 //add Order
		 criteria.addOrder(order);
		 //execute QBC logic
		 list=criteria.list();
		 for(Customer ed:list){
			 System.out.println(ed.getId()+"    "+ed.getFirstName()+"   "+ed.getLastName());
		 }*/
		
		//prepare QBC logic with SQL condition based Criterion objs
				criteria=session.createCriteria(Customer.class);
				//prepare cond
				Criterion cond=Restrictions.sqlRestriction(" lastName like '%Davis'");
				//add cond
				criteria.add(cond);
				//execute QBC logic
				 list=criteria.list();
				//process the results
				for(Customer ed:list){
					System.out.println(ed.getId()+"   "+ed.getFirstName()+"   "+ed.getLastName());
				}
	}
}
