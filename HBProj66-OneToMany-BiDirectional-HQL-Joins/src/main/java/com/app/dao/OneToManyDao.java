package com.app.dao;

public interface OneToManyDao {
	public void loadDataUisngParentsAndJoins();
	public void loadDataUisngChildsAndJoins();
	public void loadDataUsingParentsAndFetchJoins();
	public void loadDataUsingParentAndQBC();
}
