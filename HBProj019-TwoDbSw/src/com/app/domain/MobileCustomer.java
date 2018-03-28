package com.app.domain;

public class MobileCustomer {
	private long mobileNo;
	private String custName;
	private String idProofDoc;
	private String status;
	//default constructor
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getIdProofDoc() {
		return idProofDoc;
	}
	public void setIdProofDoc(String idProofDoc) {
		this.idProofDoc = idProofDoc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
