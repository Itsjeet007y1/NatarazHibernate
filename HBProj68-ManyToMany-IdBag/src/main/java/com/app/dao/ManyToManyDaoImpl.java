package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Programmer;
import com.app.domain.Project;
import com.app.utility.HibernateUtil;

public class ManyToManyDaoImpl implements ManyToManyDao {

	@Override
	public void saveDataUsingParent() {
		Session session=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare parent object
		prgmr1=new Programmer();
		prgmr1.setPid(1001);
		prgmr1.setPname("Nanhi");
		prgmr1.setSalary(123000);
		prgmr2=new Programmer();
		prgmr2.setPid(1002);
		prgmr2.setPname("Munhi");
		prgmr2.setSalary(456000);
		prgmr3=new Programmer();
		prgmr3.setPid(1003);
		prgmr3.setPname("Chunhi");
		prgmr3.setSalary(789000);
		//prepare child objects
		proj1=new Project();
		proj1.setProid(111);
		proj1.setProname("Project1");
		proj2=new Project();
		proj2.setProid(222);
		proj2.setProname("Project2");
		//map children to parent
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		
		prgmr2.getProjects().add(proj1);
		
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
		//map parent to child
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);
		
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);
		
		//save object parent to child
		try {
			tx=session.beginTransaction();
			session.save(prgmr1);
			session.save(prgmr2);
			session.save(prgmr3);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Data saved Parent to child successfully...");
			} else {
				tx.rollback();
				System.out.println("Some problem occured. Please Check...");
			}
			//close the session obect
			HibernateUtil.closeSession(session);
		}
	}

	@Override
	public void saveDataUsingChild() {
		Session session=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare parent object
		prgmr1=new Programmer();
		prgmr1.setPid(1011);
		prgmr1.setPname("Amar");
		prgmr1.setSalary(222222);
		prgmr2=new Programmer();
		prgmr2.setPid(1022);
		prgmr2.setPname("Akbar");
		prgmr2.setSalary(444444);
		prgmr3=new Programmer();
		prgmr3.setPid(1033);
		prgmr3.setPname("Anthony");
		prgmr3.setSalary(666666);
		//prepare child objects
		proj1=new Project();
		proj1.setProid(5555);
		proj1.setProname("Project11");
		proj2=new Project();
		proj2.setProid(6666);
		proj2.setProname("Project22");
		//map children to parent
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		
		prgmr2.getProjects().add(proj1);
		
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
		//map parent to child
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);
		
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);
		
		//save object parent to child
		try {
			tx=session.beginTransaction();
			session.save(proj1);
			session.save(proj2);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Data saved Child to Parent successfully...");
			} else {
				tx.rollback();
				System.out.println("Some problem occured. Please Check...");
			}
			//close the session object
			HibernateUtil.closeSession(session);
		}
	}
}
