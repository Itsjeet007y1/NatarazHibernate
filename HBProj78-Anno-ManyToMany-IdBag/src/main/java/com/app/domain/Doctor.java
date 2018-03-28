package com.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="doctor_tab_idbag")
public class Doctor {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int docId;
	private String name;
	private String specialization;
	@ManyToMany(targetEntity=Patient.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="doctors")
	private Set<Patient> patients=new HashSet<Patient>();
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", name=" + name + ", specialization=" + specialization + ", patients="
				+ patients + "]";
	}
}
