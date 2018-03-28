package com.app.domain;

public class NGOMember {
	private int mid;
	private String fname;
	private String lname;
	private String mail;
	
	public NGOMember() {
		System.out.println("EmpDetails:0-param constructor");
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
}
