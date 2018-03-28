package com.app.domains;

public class ProgrammersProjectsInfo {
	private IdClass ids;
	private String programmerName;
	private String projecName;
	private String status;
	//default Constructor
	public ProgrammersProjectsInfo() {
		super();
	}
	//setters and getters
	public IdClass getIds() {
		return ids;
	}
	public void setIds(IdClass ids) {
		this.ids = ids;
	}
	public String getProgrammerName() {
		return programmerName;
	}
	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}
	public String getProjecName() {
		return projecName;
	}
	public void setProjecName(String projecName) {
		this.projecName = projecName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProgrammersProjectsInfo [ids=" + ids + ", programmerName=" + programmerName + ", projecName="
				+ projecName + ", status=" + status + "]";
	}
}
