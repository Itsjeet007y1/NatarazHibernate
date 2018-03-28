package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.MobileCustomer;
import com.app.utility.HibernateUtilMySql;
import com.app.utility.HibernateUtilOracle;

public class MobileNumberPortabilityDAOImpl implements MobileNumberPortabilityDAO {

	@Override
	public boolean transfer(long mobileNo) {
		Session oraSession,mysqlSession=null;
		MobileCustomer customer=null;
		Transaction oraTx=null,mySqlTx=null;
		boolean mysqlFlag=false,oraFlag=false,finalResultFlag=false;
		//get mysql  Session
		mysqlSession=HibernateUtilMySql.getSession();
		//get Oracle Session
		oraSession=HibernateUtilOracle.getSession();
		//get object from oracle
		customer=oraSession.get(MobileCustomer.class, mobileNo);
		//sotre object into mysql
		try {
			//store into mysql db
			mySqlTx=mysqlSession.beginTransaction();
			customer.setStatus("Active");
			mysqlSession.save(customer);
			mysqlFlag=true;
			oraTx=oraSession.beginTransaction();
			oraSession.delete(customer);
			oraFlag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			mysqlFlag=false;
			oraFlag=false;
		} catch(Exception e) {
			e.printStackTrace();
			mysqlFlag=false;
			oraFlag=false;
		}
		finally {
			if(oraFlag==false || mysqlFlag==false){
				oraTx.rollback();
				mySqlTx.rollback();
				System.out.println("MNP Failed");
				finalResultFlag=false;
			}
			else{
				oraTx.commit();
				mySqlTx.commit();	
				System.out.println("MNP succeded");
				finalResultFlag=true;
			}
			//close objects
			HibernateUtilOracle.closeSession(oraSession);
			HibernateUtilMySql.closeSession(mysqlSession);
			//OracleHibernateUtil.closeSessionFactory();
			//MysqlHibernateUtil.closeSessionFactory();
		}//finally
		
		return finalResultFlag;
	}
}
