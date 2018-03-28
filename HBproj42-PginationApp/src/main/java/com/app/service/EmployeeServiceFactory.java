package com.app.service;

public class EmployeeServiceFactory {
	
	public static EmployeeService getInstance(){
		return new EmployeeServiceImpl();
	}

}
