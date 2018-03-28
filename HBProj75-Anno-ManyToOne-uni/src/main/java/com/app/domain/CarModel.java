package com.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CarModel")
public class CarModel {
	@Id
	@GenericGenerator(name="gen1",strategy="sequence",
         parameters=@Parameter(name="sequence_name",value="mid_sequence"))
	@GeneratedValue(generator="gen1")
	private int mid;
	private String name;
	private String segment;
	@ManyToOne(targetEntity=CarCompany.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="carCompany",referencedColumnName="cid")
	private CarCompany company;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public CarCompany getCompany() {
		return company;
	}
	public void setCompany(CarCompany company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "CarModel [mid=" + mid + ", name=" + name + ", segment=" + segment + ", company=" + company + "]";
	}
}
