package com.app.dao;

public interface ManyToManyDao {
	public void saveDataUsingProgrammer();
	public void saveDataUsingProject();
	public void addNewParentToExistingChild();
	public void changingExistingProgrammerToExistingProject();
	public void loadObjectUsingParent();
}
