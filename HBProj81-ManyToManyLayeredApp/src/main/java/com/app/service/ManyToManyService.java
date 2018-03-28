package com.app.service;

import java.util.List;

import com.app.dto.ProjectDTO;

public interface ManyToManyService {
	public List<ProjectDTO> getAllProjectWithProgrammer();
	public String deleteProgrammerFromProject(int prgmrId,int projId);
	public List<ProjectDTO> getAllProjectWhereProgrammerIsNotWorking(int prgmrId);
	public String changeProgrammerToAnotherProject(int prgmrId, int oldProjId, int newProjId);
}
