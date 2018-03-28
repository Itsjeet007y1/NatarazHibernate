package com.app.dao;

public interface OneToManyDao {
	public void saveDataUsingParent();
	public void loadDataUsingParent();
	public void deleteDataUsingParent();
	public void deleteOneChildFromCollectionOfChildsInAParent();
	public void addingNewChildToExistingParent();
	public void deleteAllChildsOfAParent();
}
