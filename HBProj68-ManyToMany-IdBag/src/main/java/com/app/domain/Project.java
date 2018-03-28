package com.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private int proid;
	private String proname;
	private List<Programmer> programmers=new ArrayList<Programmer>();
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
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}
	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + ", programmers=" + programmers + "]";
	}
}
