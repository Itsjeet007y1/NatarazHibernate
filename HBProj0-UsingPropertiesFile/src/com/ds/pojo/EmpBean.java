//EmpBean.java
package com.ds.pojo;
public class EmpBean {
	//Bean properties
	private int no;
	private String fname,lname,mail;
	
	public EmpBean(){
		System.out.println("EmpBean:0-param constructor");
	}
	
	//write setXxx(-) and getXxx() methods
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
}
