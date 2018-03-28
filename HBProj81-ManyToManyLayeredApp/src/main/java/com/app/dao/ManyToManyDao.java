package com.app.dao;

import java.util.List;

import com.app.domain.Project;

public interface ManyToManyDao {
	public List<Project> ListAllProjectWithProgrammers();
	public int removeProgrammerFromProject(int prgmrId,int projId);
	public List<Project> listOtherProjectsInfoWhereProgrammerNotWorking(int prgmrId);
	public int moveProgrammerToAnotherExistingProject(int prgmrId, int oldProjId, int newProjId);
}
