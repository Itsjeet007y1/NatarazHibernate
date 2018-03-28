package com.app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name="patient_tab_idbag")
public class Patient {
	@Id
	@GenericGenerator(name="gen1",strategy="sequence",parameters=@Parameter(name="sequence_name",value="pat_seq"))
	@GeneratedValue(generator="gen1")
	private int pid;
	private String name;
	private int age;
	@ManyToMany(targetEntity=Doctor.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="doctors_patients_idbag",joinColumns=@JoinColumn(name="patient_id",referencedColumnName="pid"),
							inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName="docId"))
	@CollectionId(columns=@Column(name="doc_pat_index"),type=@Type(type="int"),generator="gen1")
	@GenericGenerator(name="gen1",strategy="increment")
	private List<Doctor> doctors=new ArrayList<Doctor>();
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", age=" + age + ", doctors=" + doctors + "]";
	}
}
