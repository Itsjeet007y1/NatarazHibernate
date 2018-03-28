package com.app.domain;

public class Person {
	private int id;
	private String pname;
	private JobType pjob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public JobType getPjob() {
		return pjob;
	}

	public void setPjob(JobType pjob) {
		this.pjob = pjob;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", pjob=" + pjob + "]";
	}
}
