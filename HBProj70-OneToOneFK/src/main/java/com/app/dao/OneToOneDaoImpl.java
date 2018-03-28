package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.License;
import com.app.domain.Person;
import com.app.utility.HibernateUtil;

public class OneToOneDaoImpl implements OneToOneDao {

	@Override
	public void saveDataUsingLicense() {
		Session session=null;
		Transaction tx=null;
		Person person1=null,person2=null;
		License license=null;
		//get session object
		session=HibernateUtil.getSession();
		//create parent and child objects
		person1=new Person();
		person1.setFirstName("Jitendra");
		person1.setLastName("Kumar");
		person1.setAge((byte)24);
		
		person2=new Person();
		person2.setFirstName("Dharmendra");
		person2.setLastName("Kaithal");
		person2.setAge((byte)23);
		
		license=new License();
		license.setType("Two-Wheeler");
		license.setValidFrom(new Date());
		license.setValidTo(new Date(140,12,20));
		
		//map parent to child
		license.setLicenseHolder(person1);
		try {
			tx=session.beginTransaction();
			session.save(license);
			session.save(person2);
			tx.commit();
			System.out.println("Objects saved...");
		}catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void loadDataUsingLicense() {
		Session session=null;
		List<License> list=null;
		Query query=null;
		//get Session
		session=HibernateUtil.getSession();
		//load License object
		query=session.createQuery("from License");
		list=query.list();
		list.forEach(l-> {
			System.out.println("Child==>"+l.getLid()+"   "+l.getValidFrom()+"  "+l.getValidTo());
			Person per=l.getLicenseHolder();
			System.out.println("Parent==>"+per.getPid()+"   "+per.getFirstName()+"   "+per.getLastName()+"   "+per.getAge());
		});
	}

	@Override
	public void deleteDataUsingLicense() {
		Session session=null;
		License lic=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//load license
		lic=session.get(License.class, 1000);
		try {
			tx=session.beginTransaction();
			session.delete(lic);
			tx.commit();
			System.out.println("Object deleted successfully...");
		} catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
}
