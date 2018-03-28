package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.domain.Student;
import com.app.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		Session ses = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// get Access to Named Native SQL Query and execute ti
		Query query = ses.getNamedQuery("CALL_PROCEDURE");
		query.setString("initChars", "R%");

		List<Student> list=query.list();
		System.out.println(list);
		 for(Student st:list){
			 System.out.println(st);
		 }
		
		 
		/*List<Object[]> list = query.list();
		for (Object row[] : list) {
			for (Object val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}*/
		
	/*	List<Object[]> list=query.list();
		list.forEach(st-> {
			for(Object val1:st) {
				System.out.print(val1+"  ");
			}
			System.out.println();
		});*/
		
		// close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}// main
}// class
