package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="employee")
@FilterDef(name="FIND_EMP_BY_RANGE",parameters={@ParamDef(name="min",type="int"),
																												@ParamDef(name="max",type="int")})
@Filter(name="FIND_EMP_BY_RANGE",condition="EID>=:min and EID<=:max")
public class EmpDetails {
	@Id
	@Column(name="eid")
	private int no;
	private String firstName, lastName;
	@Column(name="email")
	private String mail;

	// Default Constructor
	public EmpDetails() {
		super();
	}
	//setters ang getters
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "EmpDetails [no=" + no + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + "]";
	}

}
