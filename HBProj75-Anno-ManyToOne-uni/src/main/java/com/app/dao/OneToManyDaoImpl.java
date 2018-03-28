package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.CarCompany;
import com.app.domain.CarModel;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {
	@Override
	public void saveDataUsingCarModel() {
		Session ses=null;
		CarModel carModel1=null,carModel2=null;
		CarCompany company=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		company=new CarCompany();
		company.setName("Toyota");
		company.setEstablished("1978");
		company.setOrigin("Japan");
		
		carModel1=new CarModel();
		carModel1.setName("Fortuner");
		carModel1.setSegment("SUV");
		carModel1.setCompany(company);
		
		carModel2=new CarModel();
		carModel2.setName("Innova");
		carModel2.setSegment("MUV");
		carModel2.setCompany(company);
		//save objects (child to parent)
		try{
		 tx=ses.beginTransaction();
		   ses.save(carModel1); ses.save(carModel2);
		  tx.commit();
		  System.out.println("Child objs and associated parent objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}	
	}
}
