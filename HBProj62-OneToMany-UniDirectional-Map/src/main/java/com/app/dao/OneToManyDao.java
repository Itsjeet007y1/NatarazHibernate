package com.app.dao;

public interface OneToManyDao {
	public void SaveDataUsingParents();
    public void deleteOneChildFromCollectionOfChildsInAParent();
}
