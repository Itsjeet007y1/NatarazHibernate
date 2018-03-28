package com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.dao.ManyToManyDao;
import com.app.dao.ManyToManyDaoFactory;
import com.app.domain.Programmer;
import com.app.domain.Project;
import com.app.dto.ProgrammerDTO;
import com.app.dto.ProjectDTO;

public class ManyToManyServiceImpl implements ManyToManyService {

	@Override
	public List<ProjectDTO> getAllProjectWithProgrammer() {
		ManyToManyDao dao = null;
		List<Project> listProjects = null;
		List<ProjectDTO> listProjectsDTO = null;
		Set<Programmer> setProgrammers = null;
		Set<ProgrammerDTO> setProgrammersDTO = null;
		ProjectDTO projectDTO = null;
		ProgrammerDTO programmerDTO = null;
		// use dao
		dao = ManyToManyDaoFactory.getInstance();
		listProjects = dao.ListAllProjectWithProgrammers();
		// copy listDomain to listDTO
		listProjectsDTO = new ArrayList<ProjectDTO>();
		for (Project project : listProjects) {
			projectDTO = new ProjectDTO();
			projectDTO.setProid(project.getProid());
			projectDTO.setProname(project.getProname());
			setProgrammers = project.getProgrammers();
			setProgrammersDTO = new HashSet<ProgrammerDTO>();
			for (Programmer programmer : setProgrammers) {
				programmerDTO = new ProgrammerDTO();
				programmerDTO.setPid(programmer.getPid());
				programmerDTO.setPname(programmer.getPname());
				programmerDTO.setSalary(programmer.getSalary());
				setProgrammersDTO.add(programmerDTO);
			} // for
			projectDTO.setProgrammers(setProgrammersDTO);
			listProjectsDTO.add(projectDTO);
		} // for
		return listProjectsDTO;
	}

	@Override
	public String deleteProgrammerFromProject(int prgmrId, int projId) {
		ManyToManyDao dao = null;
		int result = 0;
		// use dAO
		dao = ManyToManyDaoFactory.getInstance();
		result = dao.removeProgrammerFromProject(prgmrId, projId);
		if (result == 0)
			return "Programmer deletion failed";
		else
			return "programmer deleted";
	}

	@Override
	public List<ProjectDTO> getAllProjectWhereProgrammerIsNotWorking(int prgmrId) {
		ManyToManyDao dao=null;
		List<Project> listProjs=null;
	    List<ProjectDTO> listProjsDTO=null;
	    ProjectDTO projectDTO=null;
		   //use dAO
		 dao=ManyToManyDaoFactory.getInstance();
	      listProjs=dao.listOtherProjectsInfoWhereProgrammerNotWorking(prgmrId);
	      //Convert ListProject to ListProjectDTO
	      listProjsDTO =new ArrayList();
	      for(Project proj:listProjs){
	    	  projectDTO=new ProjectDTO();
	    	  projectDTO.setProid(proj.getProid());
	    	  projectDTO.setProname(proj.getProname());
	    	  listProjsDTO.add(projectDTO);
	      }//for
			return listProjsDTO;
	}

	@Override
	public String changeProgrammerToAnotherProject(int prgmrId, int oldProjId, int newProjId) {
		ManyToManyDao dao=null;
		 int result=0;
		 //use DAO
		 dao=ManyToManyDaoFactory.getInstance();
		 result=dao.moveProgrammerToAnotherExistingProject(prgmrId, oldProjId, newProjId);
		 if(result==0)
			 return "Prorammer is not moved to Another Project";
		 else
			 return "Programmer no:"+prgmrId+" is moved new Project no:"+newProjId+" from old Project"+oldProjId;
		}//method
	}
