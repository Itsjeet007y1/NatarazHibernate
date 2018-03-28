package com.app.dto;

public class StudentDTO {
	private int sno;
	private String sname;
	private String saddr;
	private LibraryMembershipDTO libraryDetails;
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
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public LibraryMembershipDTO getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembershipDTO libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
}
