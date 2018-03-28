package com.app.dao;

public interface OneToManyDao {
	public void saveDataUsingUniversity();
	public void loadDataUsingUniversity();
	public void loadDataUsingUniversityWithQBC();
	public void deleteDataUsingUniversity();
	public void deleteCollegesOfUniversity();
}
