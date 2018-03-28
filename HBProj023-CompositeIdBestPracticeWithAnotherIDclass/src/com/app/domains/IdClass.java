package com.app.domains;

import java.io.Serializable;

public class IdClass implements Serializable {
	private int programmerId;
	private int projectId;
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
}
