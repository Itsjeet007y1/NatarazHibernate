package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domains.IdClass;
import com.app.domains.ProgrammersProjectsInfo;
import com.app.utility.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		Session session=null;
		Transaction tx=null;
		IdClass idVal,idVal1=null;
		ProgrammersProjectsInfo info=null;
		//get Session Object
		session=HibernateUtil.getSession();
		tx=session.beginTransaction();
		//prepare the object
		idVal=new IdClass();
		idVal.setProgrammerId(101);
		idVal.setProjectId(1001);
		info=new ProgrammersProjectsInfo();
		info.setIds(idVal);
		info.setProgrammerName("Jeet");
		info.setProjecName("WareHouse");
		info.setStatus("Working On..");
		//save the object
		idVal1=new IdClass();
		idVal1=(IdClass)session.save(info);
		tx.commit();
		System.out.println("Object saved with :");
		System.out.println("ProgrammerID:"+idVal1.getProgrammerId());
		System.out.println("ProjectId:"+idVal1.getProjectId());
	}
}
