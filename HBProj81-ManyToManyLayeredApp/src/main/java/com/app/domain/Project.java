package com.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="layered_projects")
public class Project {
	@Id
	@GenericGenerator(name="gen1",strategy="sequence",parameters=@Parameter(name="sequence_name",value="proj_sequence"))
	@GeneratedValue(generator="gen1")
	private int proid;
	private String proname;
	@ManyToMany(targetEntity=Programmer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="Programmers_Projects",
											joinColumns=@JoinColumn(name="project_id",referencedColumnName="proid"),
											inverseJoinColumns=@JoinColumn(name="programmer_id",referencedColumnName="pid"))
	private Set<Programmer> programmers=new HashSet<Programmer>();
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	} 
}
