package com.app.dao;

import com.app.domain.Employee;

public interface IEmployeeDao {
	public int register(int empId, String empName, double empSal, String empMail);
	public void modify(int empId, String empMail);
	public Employee search(int empId);
	public void remove(int empId);
}
