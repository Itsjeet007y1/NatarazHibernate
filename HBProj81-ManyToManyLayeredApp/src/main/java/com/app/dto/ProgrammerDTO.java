package com.app.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProgrammerDTO implements Serializable {
	private int pid;
	private String pname;
	private double salary;
	private Set<ProjectDTO> projects=new HashSet<ProjectDTO>();
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Set<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(Set<ProjectDTO> projects) {
		this.projects = projects;
	}
}
