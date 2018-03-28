package com.app.dao;

public interface OneToManyDao {
	public void SaveDataUsingParents();
	public void SaveDataUsingChilds();
	public void loadUsingParents();
	public void loadDataUsingChilds();
}
