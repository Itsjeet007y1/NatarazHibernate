package com.app.test;

import java.util.List;

import com.app.dao.PersonDao;
import com.app.dao.PersonDaoFactory;
import com.app.domain.JobType;
import com.app.domain.Person;
import com.app.utility.HibernateUtil;

public class ComponentTest {
	public static void main(String[] args) throws Exception {
	
		PersonDao dao = null;
		List<Person> list=null;
		/*String result = null;
		Person person = null;
		JobType job = null;
		// prepare JobType object
		job = new JobType();
		job.setJob("Programmer");
		job.setDeptNo(1002);
		job.setSalary(50000);
		// prepare Person class object
		person = new Person();
		person.setPname("Hari");
		person.setPjob(job);*/

		// get the instance of dao from PersonDaoFactory class
		dao= PersonDaoFactory.getInstance();
		// save person details
		list=dao.getPerson();
		list.forEach(p-> {
			JobType job=new JobType();
			job=p.getPjob();
			System.out.println(p.getId()+"   "+p.getPname()+"  "+job.getJob()+"   "+job.getDeptNo()+"   "+job.getSalary());
		});
		
		
		HibernateUtil.closeSessionFactory();
	}
}
