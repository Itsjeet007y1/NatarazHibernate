package com.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.Programmer;
import com.app.domain.Project;
import com.app.utility.HibernateUtil;

public class ManyToManyDaoImpl implements ManyToManyDao {

	public void saveDataUsingProgrammer() {
		Session session=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		
		//get Session object
		session=HibernateUtil.getSession();
		
		//prepare Programmer object ready
		prgmr1=new Programmer();
		prgmr1.setPid(101);
		prgmr1.setPname("Jitendra");
		prgmr1.setSalary(100000);
		
		prgmr2=new Programmer();
		prgmr2.setPid(102);
		prgmr2.setPname("Lucky");
		prgmr2.setSalary(22000);
		
		prgmr3=new Programmer();
		prgmr3.setPid(103);
		prgmr3.setPname("Himasnhu");
		prgmr3.setSalary(20000);
		
		//prepare Project objects ready
		proj1=new Project();
		proj1.setProid(11);
		proj1.setProname("Cybernetics");
		
		proj2=new Project();
		proj2.setProid(22);
		proj2.setProname("WareHouse");
		
		//map programmer to project
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		prgmr2.getProjects().add(proj1);
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
		/*//map project to programmer
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);*/
		
		//save object 
		try {
			tx=session.beginTransaction();
			session.save(prgmr1);
			session.save(prgmr2);
			session.save(prgmr3);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Objects saved successfully...");
			} else {
				tx.rollback();
				System.out.println("Some Problem occured. Please check...");
			}
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void saveDataUsingProject() {
		Session session=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		
		//get Session object
		session=HibernateUtil.getSession();
		
		//prepare Programmer object ready
		prgmr1=new Programmer();
		prgmr1.setPid(101);
		prgmr1.setPname("Jitendra");
		prgmr1.setSalary(100000);
		
		prgmr2=new Programmer();
		prgmr2.setPid(102);
		prgmr2.setPname("Lucky");
		prgmr2.setSalary(22000);
		
		prgmr3=new Programmer();
		prgmr3.setPid(103);
		prgmr3.setPname("Himasnhu");
		prgmr3.setSalary(20000);
		
		//prepare Project objects ready
		proj1=new Project();
		proj1.setProid(11);
		proj1.setProname("Cybernetics");
		
		proj2=new Project();
		proj2.setProid(22);
		proj2.setProname("WareHouse");
		
		//map programmer to project
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		prgmr2.getProjects().add(proj1);
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
		//map project to programmer
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj1.getProgrammers().add(prgmr3);
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr3);
		
		//save object 
		try {
			tx=session.beginTransaction();
			session.save(proj1);
			session.save(proj2);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Objects saved successfully...");
			} else {
				tx.rollback();
				System.out.println("Some Problem occured. Please check...");
			}
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void addNewParentToExistingChild() {
		Session session=null;
		Project proj1=null;
		Programmer prgmr=null;
		Set<Programmer> parent=null,prgmrs1=null;
		Transaction tx=null;
		// get session
		session=HibernateUtil.getSession();
		//load existing child
		proj1=session.get(Project.class, 11);
		//create new parent
		prgmr=new Programmer();
		prgmr.setPid(105);prgmr.setPname("Chetan");prgmr.setSalary(80000);
		//get all parent of loaded child
		parent=proj1.getProgrammers();
		try {
			tx=session.beginTransaction();
			//add new parent to existing parent of a child
			parent.add(prgmr);
			tx.commit();
			System.out.println("New parent to existing child added..");
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void changingExistingProgrammerToExistingProject() {
		Session session=null;
		Programmer prgmr=null;
		Transaction tx=null;
		Project proj=null,proj1=null;
		Set<Programmer> prgmrs=null,prgmr1=null;
		//get Session object
		session=HibernateUtil.getSession();
		//load existing programmer(parent)
		prgmr=session.get(Programmer.class, 101);
		//load project where programmer is currently working
		proj=session.get(Project.class, 11);
		//get all programmer of above project
		prgmrs=proj.getProgrammers();
		//load project where programmer wants to move
		proj1=session.get(Project.class, 22);
		//load all programmer of above project
		prgmr1=proj1.getProgrammers();
		//add programmer 22 and remove from 11
		try {
			tx=session.beginTransaction();
			prgmr1.add(prgmr);
			prgmrs.remove(prgmr);
			tx.commit();
			System.out.println("Programmer is moved from one project to another project");
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void loadObjectUsingParent() {
		Session session=null;
		Query query=null;
		List<Programmer> list=null;
		Set<Project> projs=null;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare query
		query=session.createQuery("from Programmer");
		//execute query
		list=query.list();
		for(Programmer prgmr:list) {
			System.out.println("Parent-->"+prgmr);
			//get child of each parent
			projs=prgmr.getProjects();
			for(Project proj:projs) {
				System.out.println("Childs-->"+proj);
			}
		}
		
		
		
		/*list.forEach(p-> {
			System.out.println("Parent-->"+p);
			//get child of each parent
			Set<Project> proj=p.getProjects();
			proj.forEach(pr-> {
				System.out.println("Child-->"+pr);
			});
		});*/
	}
}
