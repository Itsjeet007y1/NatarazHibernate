package com.app.domains;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prgmr_prjct_info")
public class ProgrammersProjectsInfo {
	@EmbeddedId
	private IdClass ids;
	@Column(name="prgmName",length=20)
	private String programmerName;
	@Column(name="prjctName",length=20)
	private String projectName;
	@Column(name="status",length=20)
	private String status;
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
