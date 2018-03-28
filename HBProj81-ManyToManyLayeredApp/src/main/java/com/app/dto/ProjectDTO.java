package com.app.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProjectDTO implements Serializable {
	private int proid;
	private String proname;
	private Set<ProgrammerDTO> programmers=new HashSet<ProgrammerDTO>();
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
	public Set<ProgrammerDTO> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<ProgrammerDTO> programmers) {
		this.programmers = programmers;
	}
}
