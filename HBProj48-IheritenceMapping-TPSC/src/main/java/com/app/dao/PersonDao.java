package com.app.dao;

import java.util.List;

import com.app.domain.Customer;
import com.app.domain.Employee;
import com.app.domain.Person;

public interface PersonDao {
	public String savePerson() throws Exception;
	public List<Person> getPerson() throws Exception;
	public List<Employee> getEmployee() throws Exception;
	public List<Customer> getCustomer() throws Exception;
}
