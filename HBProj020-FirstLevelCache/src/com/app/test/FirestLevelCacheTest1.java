package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.app.domain.Project;
import com.app.utitlity.HibernateUtil;

public class FirestLevelCacheTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Project proj=null,proj1=null,proj2=null,proj3=null;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//Load object
		proj=ses.get(Project.class,1001); //gets from DB keeps L1 cache
		System.out.println(proj.getProjectId()+"  "+proj.getProjName()+" "+proj.getClient()+" "+proj.getTeamSize()+" "+proj.getStartDate());
		//Load object
		proj1=ses.get(Project.class, 1001); //get from L1 cache
		System.out.println(proj1.getProjectId()+"  "+proj1.getProjName()+" "+proj1.getClient()+" "+proj1.getTeamSize()+" "+proj1.getStartDate());
		System.out.println(proj.hashCode()+"  "+proj1.hashCode());
		System.out.println("proj==proj1?::"+(proj==proj1));
		 ses.evict(proj1); //removes Project type obj whose id 101 from L1 cache
		proj2=ses.get(Project.class, 1001); //gets from DB and puts in L1 cache
		System.out.println(proj2.getProjectId()+"  "+proj2.getProjName()+" "+proj2.getClient()+" "+proj2.getTeamSize()+" "+proj2.getStartDate());
		 ses.clear(); //empties total L1 cache
		proj3=ses.get(Project.class, 1001); //gets from DB and puts in L1 cache
		System.out.println(proj3.getProjectId()+"  "+proj3.getProjName()+" "+proj3.getClient()+" "+proj3.getTeamSize()+" "+proj3.getStartDate());
		}
		catch(HibernateException e){
			 e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}//main
}//class
