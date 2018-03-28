package com.app.domain;

public class EmpDetails {
	private int no;
	private String firstName, lastName, mail;

	// Default Constructor
	public EmpDetails() {
		super();
	}
	//setters ang getters
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "EmpDetails [no=" + no + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + "]";
	}

}
