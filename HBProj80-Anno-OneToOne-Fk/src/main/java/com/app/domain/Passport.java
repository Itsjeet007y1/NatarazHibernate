package com.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="anno_passport_tab")
public class Passport {
	@Id
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="gen1",sequenceName="passport_seq",initialValue=100,allocationSize=10)
	private int passportNo;
	private String pname;
	private String country;
	@OneToOne(targetEntity=Person.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="person_details",referencedColumnName="aadharNo")
	private Person personDetails;
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Person getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(Person personDetails) {
		this.personDetails = personDetails;
	}
}
