package com.app.domain;

import java.util.HashSet;
import java.util.Set;

public class Project {
	private int proid;
	private String proname;
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
