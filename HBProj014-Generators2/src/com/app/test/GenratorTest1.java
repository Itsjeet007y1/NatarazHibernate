package com.app.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.BankTxDetails;
import com.app.utility.HibernateUtil;

public class GenratorTest1 {
	public static void main(String[] args) {
		Session session=null;
		BankTxDetails details=null;
		boolean flag=false;
		String idVal=null;
		Transaction tx=null;	
		//get session object
		session=HibernateUtil.getSession();
		//save the object
		try {
			tx=session.beginTransaction();
			//for (int i = 0; i < 5; i++) {
				
			//prepare BankTxDetails object
				details = new BankTxDetails();
				/*details.setTxId(301);*/
				details.setTxName("Hi");
				details.setTxAmount(8475);
				details.setTxDate(new Date());
				idVal = (String)session.save(details);
				flag = true;
			//}
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		if(flag==true) {
			tx.commit();
			System.out.println("Data saved with id: "+idVal);
		} if(flag==false) {
			tx.rollback();
			System.out.println("Data not saved !!");
		}
		//close connections
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
}
