package com.app.dao;

public class StockMarketDaoFactory {
	public static StockMarketDAO getInstance() {
		return new StockMarketDAOImpl();
	}
}
