package com.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="project_student")
public class Student {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int sno;
	private String sname;
	private String sadd;
	@OneToOne(targetEntity=LibraryMembership.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="studentDetails")
	private LibraryMembership libraryDetails;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", libraryDetails=" + libraryDetails
				+ "]";
	}
}
