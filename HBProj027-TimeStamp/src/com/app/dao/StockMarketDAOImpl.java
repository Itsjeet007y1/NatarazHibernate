package com.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.StockShare;
import com.app.utility.HibernateUtil;

public class StockMarketDAOImpl implements StockMarketDAO {

	@Override
	public boolean insert(StockShare share) {
		Session session=null;
		boolean flag=false;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//save the share object
		try {
			tx=session.beginTransaction();
			session.save(share);
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
			} else
				tx.rollback();
			HibernateUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public StockShare get(int stockId) {
		Session session=null;
		StockShare share=null;
		//get the session object
		session=HibernateUtil.getSession();
		//get share object
		try {
			share=session.get(StockShare.class, stockId);
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return share;
	}

	@Override
	public boolean update(int stockId, float newValue) {
		Session session=null;
		boolean flag=false;
		Transaction tx=null;
		StockShare share=null;
		//get session object
		session=HibernateUtil.getSession();
		//get and update the stock shares
		try {
			tx=session.beginTransaction();
			share=session.get(StockShare.class, stockId);
			share.setCurrentPrice(newValue);
			session.update(share);
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
			} else
				tx.rollback();
			HibernateUtil.closeSession(session);
		}
		return flag;
	}
}
