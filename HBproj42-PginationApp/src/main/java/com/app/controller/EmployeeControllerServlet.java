package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dto.EmployeeDTO;
import com.app.service.EmployeeService;
import com.app.service.EmployeeServiceFactory;

@WebServlet(urlPatterns="/controller")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   int pageNo=0;
	   EmployeeService service=null;
	   int pageCount=0;
	   List<EmployeeDTO> listDTO=null;
	   RequestDispatcher rd=null;
	   //read pageNO from request parameter
	   pageNo=Integer.parseInt(req.getParameter("pageNo"));
	   //get & use Service class
	   service=EmployeeServiceFactory.getInstance();
	   pageCount=service.getPageCount();
	   listDTO=service.getReportData(pageNo);
	   //keep data in request Scope
	   req.setAttribute("linksCount",pageCount);
	   req.setAttribute("reportData",listDTO);
	   //forward request report.jsp
	   rd=req.getRequestDispatcher("/report.jsp");
	   rd.forward(req, res);
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
