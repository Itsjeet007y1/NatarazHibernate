package com.app.dao;

import java.util.List;

import com.app.bo.EmployeeBO;

public interface EmployeeDao {
	public long getEmployeeCount();
	public List<EmployeeBO> getEmployeeDetails(int startPos);
}
