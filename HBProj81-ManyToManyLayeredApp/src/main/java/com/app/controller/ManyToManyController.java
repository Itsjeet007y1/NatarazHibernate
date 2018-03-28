package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.delegate.ManyToManyBusinessDeligate;
import com.app.dto.ProjectDTO;
import com.app.errors.InternalProblemException;

public class ManyToManyController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String paramValue=null;
		ManyToManyBusinessDeligate deligate=null;
		boolean isException=false;
		List<ProjectDTO> listDTO=null;
		RequestDispatcher rd=null;
		int prgmrNo=0;
		int projNo=0;
		int oldProj=0;
		int newProj=0;
		String prgmrDeletionMsg=null;
		String changeProjectMsg=null;
		
		//get additional request param value
		paramValue=req.getParameter("param");
		if(paramValue.equals("allDetails")) {
			deligate=new ManyToManyBusinessDeligate();
			try {
				listDTO=deligate.delegateForGetAllProjectWithProgrammer();
				//keep listDTO in request scope
				req.setAttribute("listDTO", listDTO);
				//forward request to details.jsp
				rd=req.getRequestDispatcher("/Details.jsp");
				rd.forward(req, res);
			} catch(InternalProblemException ipe) {
				isException=true;
				ipe.printStackTrace();
			}
		}//if
		
		else if(paramValue.equals("link1")) {
			prgmrNo=Integer.parseInt(req.getParameter("prgmrid"));
			projNo=Integer.parseInt(req.getParameter("projid"));
			//use deligate
			deligate=new ManyToManyBusinessDeligate();
			try {
				prgmrDeletionMsg=deligate.removeProgrammerFromProjectDeligate(prgmrNo, projNo);
				listDTO=deligate.delegateForGetAllProjectWithProgrammer();
				//keep listDTO in request scope
				req.setAttribute("listDTO", listDTO);
				req.setAttribute("prgmrMsg", prgmrDeletionMsg);
				req.setAttribute("prgmrID", prgmrNo);
				//forward request to details.jsp
				rd=req.getRequestDispatcher("/Details.jsp");
				rd.forward(req, res);
			} catch(InternalProblemException ipe) {
				isException=true;
				ipe.printStackTrace();
			}
		}//if
		
		else if(paramValue.equals("link2")) {
			 prgmrNo=Integer.parseInt(req.getParameter("prgmrid"));
			 projNo=Integer.parseInt(req.getParameter("projid"));
			 try{
			 //use Delegate
				 deligate=new ManyToManyBusinessDeligate();
			 listDTO=deligate.getAllProjectWhereProgrammerIsNotWorkingDelegate(prgmrNo);
			 //keep listDTO in request scope
			 req.setAttribute("listDTO",listDTO);
			req.setAttribute("prgmrId",prgmrNo);
			req.setAttribute("projId", projNo);
			 rd=req.getRequestDispatcher("/ChangeProject.jsp");
			 rd.forward(req,res);
			 }
			 catch(InternalProblemException ipe){
				 isException=true;
				 ipe.printStackTrace();
			 }
		}//if
		
		else if(paramValue.equals("changeProject")){
			 prgmrNo=Integer.parseInt(req.getParameter("h_prgmrId"));
			 oldProj=Integer.parseInt(req.getParameter("h_oldprojId"));
			 newProj=Integer.parseInt(req.getParameter("new_projectId"));
			 //use Delegate
			 deligate=new ManyToManyBusinessDeligate();
			 try{
				changeProjectMsg=deligate.changeProgrammerToAnotherProjectDelegate(prgmrNo, oldProj, newProj);
				 listDTO=deligate.delegateForGetAllProjectWithProgrammer();
				 //keep listDTO in request scope
				 req.setAttribute("listDTO",listDTO);
				 req.setAttribute("prgmrMsg", changeProjectMsg);
				 req.setAttribute("prgmrId",prgmrNo);
				 //forward request to details.jsp
				 rd=req.getRequestDispatcher("/Details.jsp");
				 rd.forward(req,res);
			 }
			 catch(InternalProblemException e){
				 e.printStackTrace();
				 isException=true;
			 }
		 }//if
		if(isException){
			 rd=req.getRequestDispatcher("err.jsp");
			 rd.forward(req,res);
		 }
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
}
