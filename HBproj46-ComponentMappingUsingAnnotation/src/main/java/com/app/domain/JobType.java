package com.app.domain;

public class JobType {
	private String job;
	private int deptNo;
	private float salary;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "JobType [job=" + job + ", deptNo=" + deptNo + ", salary=" + salary + "]";
	}
}
