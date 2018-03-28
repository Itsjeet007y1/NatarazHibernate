package com.app.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.app.utility.HibernateUtil;

public class ProcedureCallTest {
	public static void main(String[] args) {
		Session session=null;
		//get Session object
		try {
			session=HibernateUtil.getSession();
			Query query = session.getNamedQuery("CALL_PROCEDURE");
			query.setString("initChars", "S%");

			 
			List<Object[]> list = query.list();
			for (Object row[] : list) {
				for (Object val : row) {
					System.out.print(val + " ");
				}
				System.out.println();
			}
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//close session object
		HibernateUtil.closeSession(session);
		//close session factory object
		HibernateUtil.closeSessionFactory();
	}
}
