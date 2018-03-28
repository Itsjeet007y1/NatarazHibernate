package com.app.vo;

public class StudentVO {
	private String sname;
	private String saddr;
	private LibraryMembershipVO libraryDetails;
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
	public LibraryMembershipVO getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembershipVO libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
}
