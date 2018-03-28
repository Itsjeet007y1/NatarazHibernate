package com.app.dao;

public class EmployeeDAOFactory {
	public static IEmployeeDao getInstance() {
		return new
				EmployeeDaoImpl();
	}
}
