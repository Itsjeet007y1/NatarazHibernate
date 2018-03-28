package com.app.domain;

import java.io.Serializable;

public class ProgrammersProjectsInfo implements Serializable {
	private int programmerId;
	private int projectId;
	private String programmerName;
	private String projectName;
	private String status;
	//default Constructor
	public ProgrammersProjectsInfo() {
		super();
	}
	//setters and getters
	public int getProgrammerId() {
		return programmerId;
	}
	public void setProgrammerId(int programmerId) {
		this.programmerId = programmerId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProgrammerName() {
		return programmerName;
	}
	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
