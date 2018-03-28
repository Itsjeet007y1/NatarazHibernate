package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Doctor;
import com.app.domain.Patient;
import com.app.utility.HibernateUtil;

public class ManyToManyDaoImpl implements ManyToManyDao {

	@Override
	public void saveDataUsingPatient() {
		Session session=null;
		Doctor doc1,doc2=null;
		Patient pat1,pat2,pat3=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session object
		session=HibernateUtil.getSession();
		//prepare objects
		doc1=new Doctor();
		doc1.setName("Mr. Thomson");
		doc1.setSpecialization("Skin Specialist");
		
		doc2=new Doctor();
		doc2.setName("Mr. Peter");
		doc2.setSpecialization("Heart Specialist");
		
		pat1=new Patient();
		pat1.setName("Harry");
		pat1.setAge(24);
		
		pat2=new Patient();
		pat2.setAge(12);
		pat2.setName("Lucy");
		
		pat3=new Patient();
		pat3.setAge(55);
		pat3.setName("Mr. Arnold");
		
		//map doctors to patient
		pat1.getDoctors().add(doc1);
		pat1.getDoctors().add(doc2);
		
		pat2.getDoctors().add(doc1);
		
		pat3.getDoctors().add(doc1);
		pat3.getDoctors().add(doc2);
		
		//map patient to doctors
		doc1.getPatients().add(pat1);
		doc1.getPatients().add(pat2);
		
		doc2.getPatients().add(pat1);
		doc2.getPatients().add(pat3);
		doc2.getPatients().add(pat3);
		//save the objects
		try {
			tx=session.beginTransaction();
			session.save(pat1);
			session.save(pat2);
			session.save(pat3);
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
				System.out.println("Object saved==> Patient to doctors..");
			} else {
				tx.rollback();
				System.out.println("Something went wrong!! Please check..");
			}
			//close session object
			HibernateUtil.closeSession();
		}
	}
}
