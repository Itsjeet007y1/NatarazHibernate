package com.app.domain;

public class Employee {
	private int no;
	private String fname,lname,mail;
	public Employee() {
		System.out.println("Employee: 0-param constructor...");
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Employee [no=" + no + ", fname=" + fname + ", lname=" + lname + ", mail=" + mail + "]";
	}
}
