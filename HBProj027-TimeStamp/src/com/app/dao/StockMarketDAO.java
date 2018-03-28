package com.app.dao;

import com.app.domain.StockShare;

public interface StockMarketDAO {
	public boolean insert(StockShare share);
	public StockShare get(int stockId);
	public boolean update(int stockId, float newValue);
}
