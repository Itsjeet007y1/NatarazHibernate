package com.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.Customer;
import com.app.domain.Employee;
import com.app.domain.Person;
import com.app.utility.HibernateUtil;

public class PersonDaoImpl implements PersonDao {
	public final String GET_PERSON="from Person";
	public final String GET_EMPLOYEE="from Employee";
	public final String GET_CUSTOMER="from Customer";
	@Override
	public String savePerson() throws Exception {
		Session session=null;
		Transaction tx=null;
		Person per=null;
		Employee emp=null;
		Customer cust=null;
		boolean flag=false;
		String result=null;
		//get session object
		session=HibernateUtil.getSession();
		try {
			//create transaction object
			tx=session.beginTransaction();
			//prepare data to be saved
			//per=new Person();
			/*per.setName("Jitendra");
			per.setCompany("TCS");*/
			emp=new Employee();
			emp.setName("Jitu");
			emp.setCompany("Wipro");
			emp.setDesg("Programmer");
			emp.setSalary(50000);
			cust=new Customer();
			cust.setName("Jeet");
			cust.setCompany("HCL");
			cust.setAddrs("FTP");
			cust.setBillAmt(10000);
			//session.save(per);
			session.save(emp);
			session.save(cust);
			flag=true;
		} catch(HibernateException he) {
			System.out.println("Internal Problem---->"+he.getMessage());
			flag=false;
			throw he;
		} catch(Exception e) {
			System.out.println("Internal Problem---->"+e.getMessage());
			flag=false;
			throw e;
		} finally {
			if(flag==true) {
				tx.commit();
				result="Objects Saved";
			} else {
				tx.rollback();
				result="Object not saved";
			}
			//close session object
			HibernateUtil.closeSession(session);
		}
		return result;
	}

	@Override
	public List<Person> getPerson() throws Exception {
		Session session=null;
		List<Person> list=null;
		Query query=null;
		//get session object
		session=HibernateUtil.getSession();
		try {
			query=session.createQuery(GET_PERSON);
			list=query.list();
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Employee> getEmployee() throws Exception {
		Session session=null;
		List<Employee> list=null;
		Query query=null;
		//get session object
		session=HibernateUtil.getSession();
		try {
			query=session.createQuery(GET_EMPLOYEE);
			list=query.list();
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Customer> getCustomer() throws Exception {
		Session session=null;
		List<Customer> list=null;
		Query query=null;
		//get session object
		session=HibernateUtil.getSession();
		query=session.createQuery(GET_CUSTOMER);
		try {
			list=query.list();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
