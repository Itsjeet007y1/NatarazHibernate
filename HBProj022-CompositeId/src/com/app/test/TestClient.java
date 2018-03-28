package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.ProgrammersProjectsInfo;
import com.app.utility.HibernateUtil;

public class TestClient {
	public static void main(String[] args) {
		Session session=null;
		Transaction tx=null;
		ProgrammersProjectsInfo idVal=null;
		ProgrammersProjectsInfo info=null;
		//get Session object
		session=HibernateUtil.getSession();
		//set the values to bean class
		info=new ProgrammersProjectsInfo();
		info.setProgrammerId(109);
		info.setProgrammerName("Jeet");
		info.setProjectId(1003);
		info.setProjectName("WareHouse");
		info.setStatus("Completed");
		//save the id values and save the object
		try {
			tx=session.beginTransaction();
			idVal=new ProgrammersProjectsInfo();
			idVal=(ProgrammersProjectsInfo)session.save(info);
			tx.commit();
			System.out.println("Saved Successfully with Following Details....");
			System.out.println("Programmers Id:"+idVal.getProgrammerId());
			System.out.println("Projects Id:"+idVal.getProjectId());
		} catch(HibernateException he) {
			he.printStackTrace();
			//System.out.println("Row with having composite Pk value Already exists.. Try with another Id value..");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();		
				System.out.println("Session Objects Closed..");
			}
		}
	}
}
