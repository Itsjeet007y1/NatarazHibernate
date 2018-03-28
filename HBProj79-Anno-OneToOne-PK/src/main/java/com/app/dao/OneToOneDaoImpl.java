package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.FacebookAccount;
import com.app.domain.UberAccount;
import com.app.utility.HibernateUtil;

public class OneToOneDaoImpl implements OneToOneDao {

	@Override
	public void saveDataUsingFaceBookAccount() {
		Session session=null;
		FacebookAccount fbAcc=null;
		UberAccount uber=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare objects
		fbAcc=new FacebookAccount();
		fbAcc.setFbId(101);
		fbAcc.setName("Jitendra");
		fbAcc.setFollowers(150);
		
		uber=new UberAccount();
		uber.setName("ItsJeetonUber");
		uber.setMobileNo(8406088592l);
		
		//map parent to child and child to parent
		uber.setFacebookDetails(fbAcc);
		fbAcc.setUberDetails(uber);
		//save data parent to child
		try {
			tx=session.beginTransaction();
			session.save(fbAcc);
			flag=true;
		} catch(HibernateException he) {
			flag=false;
			throw he;
		} catch(Exception e) {
			flag=false;
			throw e;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved successfully..");
			} else {
				tx.rollback();
				System.out.println("Some problem occured..Objects are not saved...");
			}
			//close session object
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void saveDataUsingUberAccount() {
		Session session=null;
		FacebookAccount fbAcc=null;
		UberAccount uber=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare objects
		fbAcc=new FacebookAccount();
		fbAcc.setFbId(102);
		fbAcc.setName("Sandeep");
		fbAcc.setFollowers(160);
		
		uber=new UberAccount();
		uber.setName("Sandy");
		uber.setMobileNo(8406055555l);
		
		//map parent to child and child to parent
		uber.setFacebookDetails(fbAcc);
		fbAcc.setUberDetails(uber);
		//save data child to parent
		try {
			tx=session.beginTransaction();
			session.save(uber);
			flag=true;
		} catch(HibernateException he) {
			flag=false;
			throw he;
		} catch(Exception e) {
			flag=false;
			throw e;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved successfully..");
			} else {
				tx.rollback();
				System.out.println("Some problem occured..Objects are not saved...");
			}
			//close session object
			HibernateUtil.closeSession();
		}
	}
}
