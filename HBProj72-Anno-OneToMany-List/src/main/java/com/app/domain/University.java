package com.app.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="University_tab1")
public class University {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int unid;
	private String name;
	private String region;
	@OneToMany(targetEntity=College.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	@JoinColumn(name="affiliatedTo",referencedColumnName="unid")
	@Fetch(value=FetchMode.JOIN)
	@OrderColumn(name="list_indx")//jpa annotation
	//@IndexColumn(name="list_indx")// Hibernate annotation
	private List<College> colleges;
	public int getUnid() {
		return unid;
	}
	public void setUnid(int unid) {
		this.unid = unid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<College> getColleges() {
		return colleges;
	}
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	@Override
	public String toString() {
		return "University [unid=" + unid + ", name=" + name + ", region=" + region + ", colleges=" + colleges + "]";
	}
}
