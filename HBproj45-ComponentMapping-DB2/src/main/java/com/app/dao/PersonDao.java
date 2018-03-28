package com.app.dao;

import java.util.List;

import com.app.domain.Person;

public interface PersonDao {
	//public void savePerson(Person person);
	public List<Person> getPerson() throws Exception;
}
