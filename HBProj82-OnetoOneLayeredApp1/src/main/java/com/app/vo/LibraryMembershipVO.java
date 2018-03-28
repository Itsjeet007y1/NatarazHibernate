package com.app.vo;

public class LibraryMembershipVO {
	private String doj;
	private StudentVO studentDetails;
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public StudentVO getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentVO studentDetails) {
		this.studentDetails = studentDetails;
	}
}
