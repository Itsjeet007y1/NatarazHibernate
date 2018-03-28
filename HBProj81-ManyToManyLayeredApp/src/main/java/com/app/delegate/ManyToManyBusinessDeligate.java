package com.app.delegate;

import java.util.List;

import org.hibernate.HibernateException;

import com.app.dto.ProjectDTO;
import com.app.errors.InternalProblemException;
import com.app.service.ManyToManyService;
import com.app.service.ManyToManyServiceImpl;

public class ManyToManyBusinessDeligate {
	
	public List<ProjectDTO> delegateForGetAllProjectWithProgrammer() throws InternalProblemException {
		ManyToManyService service=null;
		List<ProjectDTO> listProjects=null;
		//use service
		try {
			service=new ManyToManyServiceImpl();
			listProjects=service.getAllProjectWithProgrammer();
		} catch(HibernateException he) {
			throw new InternalProblemException(he.getMessage());
		} catch(Exception e) {
			throw new InternalProblemException(e.getMessage());
		}
		return listProjects;
	}
	
	public String removeProgrammerFromProjectDeligate(int prgmrId, int projId) throws InternalProblemException{
		ManyToManyService service=null;
		String resultMsg=null;
		try {
			//use service
			service=new ManyToManyServiceImpl();
			resultMsg=service.deleteProgrammerFromProject(prgmrId, projId);
		} catch(HibernateException he) {
			throw new InternalProblemException(he.getMessage());
		} catch(Exception e) {
			throw new InternalProblemException(e.getMessage());
		}
		return resultMsg;
	}
	
	public List<ProjectDTO> getAllProjectWhereProgrammerIsNotWorkingDelegate(int prgmrId) throws InternalProblemException {
		ManyToManyService service=null;	
		List<ProjectDTO> listProjectsDTO=null;
		try {
			//use service
			service=new ManyToManyServiceImpl();
			listProjectsDTO=service.getAllProjectWhereProgrammerIsNotWorking(prgmrId);
		} catch(HibernateException he) {
			throw new InternalProblemException(he.getMessage());
		} catch(Exception e) {
			throw new InternalProblemException(e.getMessage());
		}
		return listProjectsDTO;
	}
	
	public String changeProgrammerToAnotherProjectDelegate(int prgmrId, int oldProjId, int newProjId) throws InternalProblemException{
		ManyToManyService service=null;
		String updateMsg=null;
		try {
			service=new ManyToManyServiceImpl();
			updateMsg=service.changeProgrammerToAnotherProject(prgmrId, oldProjId, newProjId);
		} catch(HibernateException he) {
			throw new InternalProblemException(he.getMessage());
		} catch(Exception e) {
			throw new InternalProblemException(e.getMessage());
		}
		return updateMsg;
	}
}
