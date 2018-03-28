package com.app.test;

import com.app.dao.StockMarketDAO;
import com.app.dao.StockMarketDaoFactory;
import com.app.domain.StockShare;
import com.app.utility.HibernateUtil;

public class ObjectTimeStampTest {
	public static void main(String[] args) {
		StockMarketDAO dao=null;
		StockShare share=null;
		//get Dao
		dao=StockMarketDaoFactory.getInstance();
		/*//prepare share
		share=new StockShare();
		share.setStockName("KingFisher");
		share.setOwnerCompany("UBCL");
		share.setCurrentPrice(80.0f);
		System.out.println("Object Saved?"+dao.insert(share));*/
		
		System.out.println("Object Updated?:"+dao.update(1, 79.99f));
		System.out.println("Object updated at:"+dao.get(1).getLastUpdated());
		//close session factory
		HibernateUtil.closeSessionFactory();
	}
}
