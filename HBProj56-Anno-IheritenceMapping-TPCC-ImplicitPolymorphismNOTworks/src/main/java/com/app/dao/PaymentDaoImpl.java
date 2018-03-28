package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.ChequePayment;
import com.app.domain.CreditCardPayment;
import com.app.domain.Payment;
import com.app.utility.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao {
	private static final String GET_PAYMENTS="from Payment";
	private static final String GET_CHEQUE_PAYMENTS="from ChequePayment";
	private static final String GET_CREDIT_CARD_PAYMENTS="from CreditCardPayment";
	
	@Override
	public String savePayment() throws Exception {
		Session session=null;
		boolean flag=false;
		Transaction tx=null;
		Payment p=null;
		CreditCardPayment ccp=null;
		ChequePayment cp=null;
		String result=null;
		//get Session object
		session=HibernateUtil.getSession();
		try {
			//begin Transaction 
			tx=session.beginTransaction();
			//prepare objects
			p=new Payment();
			p.setAmount(123456);
			cp=new ChequePayment();
			cp.setAmount(150000);
			cp.setChequeNo(222222222);
			cp.setChequeType("Usual");
			ccp=new CreditCardPayment();
			ccp.setAmount(500000);
			ccp.setCcNo(51110112);
			ccp.setCcType("Mastero");
			//save the object
			session.save(p);session.save(cp);session.save(ccp);
			flag=true;
		} catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		} finally {
			if(flag==true)  {
				tx.commit();
				result="Object Saved successfully...";
			} else
				tx.rollback();
				result="Object Saved successfully...";
		}
		return result;
	}

	@Override
	public List<Payment> getAllPayment() throws Exception {
		Session session=null;
		Query query=null;
		List<Payment> pList=null;
		//get Session object
		session=HibernateUtil.getSession();
		//create HQL query object
		query=session.createQuery(GET_PAYMENTS);
		//get the payments details
		pList=new ArrayList<Payment>();
		pList=query.list();
		return pList;
	}

	@Override
	public List<ChequePayment> getAllChequePayment() throws Exception {
		Session session=null;
		Query query=null;
		List<ChequePayment> cpList=null;
		//Get Session object
		session=HibernateUtil.getSession();
		//Create Query object
		query=session.createQuery(GET_CHEQUE_PAYMENTS);
		//Get all the cheque payment list using query object
		cpList=query.list();
		return cpList;
	}

	@Override
	public List<CreditCardPayment> getAllCreditCardPayment() throws Exception {
		Session session=null;
		Query query=null;
		List<CreditCardPayment> ccpList=null;
		//get Session object
		session=HibernateUtil.getSession();
		//get the list of credit card payments
		query=session.createQuery(GET_CREDIT_CARD_PAYMENTS);
		ccpList=query.list();
		return ccpList;
	}
	
	
	
}
