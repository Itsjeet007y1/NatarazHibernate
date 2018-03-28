package com.app.dto;

import java.util.Date;

public class LibraryMembershipDTO {
	private int lid;
	private Date doj;
	private StudentDTO studentDetails;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public StudentDTO getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDTO studentDetails) {
		this.studentDetails = studentDetails;
	}
}
