package com.app.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.app.domain.EmpDetails;
import com.app.utility.HibernateUtil;

public class NativeSQLTest {
	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		List<Object []>list=null;
		//List<EmpDetails> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		
		/*//prepare Native SQL Query (Select Query)
		query=ses.createSQLQuery("select * from Employee");
		//execute query
		list=query.list();
		//process the List
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+"   ");
			}//for
			System.out.println();
		}//for
*/		
		/*//prepare NativeSQL Query (Entity Select Query)
		 query=ses.createSQLQuery("select * from Employee");
		 //map with domain class
		 query.addEntity(EmpDetails.class);
		//execute query
		list=query.list();
		//process the List
		for(EmpDetails ed:list){
			System.out.println(ed);
		}//for
*/		
		/*//prepare Native SQL scalar select Query
		query=ses.createSQLQuery("SELECT EID,EMAIL FROM EMPLOYEE WHERE LASTNAME=:ln");
		//map scalar results with HB data types
		query.addScalar("EID",StandardBasicTypes.INTEGER);
		query.addScalar("EMAIL",StandardBasicTypes.STRING);
	    //set param values
		query.setString("ln","bachan");
		//execute query
		List<Object[]>list1=query.list();
		//process the result
		for(Object row[]:list1){
			for(Object val:row){
				System.out.println(val.getClass());
				System.out.print(val+"   ");
			}//for
			System.out.println();
		}//for
*/		
		
		//prepare Native SQL non-select SQL Query		
		query=
			ses.createSQLQuery("INSERT INTO EMPLOYEE VALUES(:no,:fname,:lname,:mail)");
		//set param values
		query.setInteger("no",336);
		query.setString("fname","abhishek");
		query.setString("lname","bachchan");
		query.setString("mail","abhi@ABC.com");
		
		//execute Query
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			  int cnt=query.executeUpdate();
			 tx.commit();
			 System.out.println("no.of records effected::"+cnt);
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
