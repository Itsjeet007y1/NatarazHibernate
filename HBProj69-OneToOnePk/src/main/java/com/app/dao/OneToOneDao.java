package com.app.dao;

public interface OneToOneDao {
	public void saveDataUsingStudent();
	   public void saveDataUsingLibraryMembership();
	   public void loadDataUsingStudent();
	   public void loadDataUsingLibraryMembership();
	   public void delteDataUsingStudent();
	   public void delteDataUsingLibraryMembership();
	   public void deleteLibraryMembershipOfAStudent();
}
