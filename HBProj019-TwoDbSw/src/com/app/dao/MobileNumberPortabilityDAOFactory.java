package com.app.dao;

public class MobileNumberPortabilityDAOFactory {
	public static MobileNumberPortabilityDAO getInstance() {
		return new MobileNumberPortabilityDAOImpl();
	}
}
