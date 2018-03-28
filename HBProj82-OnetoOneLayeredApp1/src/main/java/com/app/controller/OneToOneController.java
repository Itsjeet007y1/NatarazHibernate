package com.app.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.delegate.OneToOneDelegate;
import com.app.domain.LibraryMembership;
import com.app.domain.Student;
import com.app.exceptions.DataRetrievingException;
import com.app.exceptions.DeletionProblemException;
import com.app.exceptions.StudentAlreadyExistException;

@WebServlet("/controller")
public class OneToOneController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		OneToOneDelegate delegate = null;
		List<Student> stdList = null;
		RequestDispatcher rd = null;
		String param = null;
		param = req.getParameter("param");
		if (param.equalsIgnoreCase("link1")) {
			// get student object from delegate
			delegate = new OneToOneDelegate();
			try {
				stdList = delegate.getAllStudentsAndTheirDetailsDelegate();
			} catch (DataRetrievingException e) {
				e.printStackTrace();
			}
			// create request dispatcher object
			rd = req.getRequestDispatcher("/Details.jsp");
			req.setAttribute("stdList", stdList);
			rd.forward(req, res);
		}
		
		if(param.equalsIgnoreCase("link2")) {
			Student std=null;
			int n=0;
			String msg=null;
			//get the form data
			String sname=req.getParameter("sname");
			String sadd=req.getParameter("sadd");
			//set the form data to OneToOneDTO class
			std=new Student();
			std.setSname(sname);
			std.setSadd(sadd);
			LibraryMembership lm=new LibraryMembership();
			lm.setDoj(new java.util.Date());
			std.setLibraryDetails(lm);
			lm.setStudentDetails(std);
			//use the delegate class object
			try {
				delegate=new OneToOneDelegate();
				n=delegate.insertStudentsAndTheirLibraryDetailsDelgate(std);
			} catch (StudentAlreadyExistException e) {
				e.printStackTrace();
			}
			//form one successful message and send to UI Page
			if(n!=0)
				msg="Student data with its associated library Details saved with id: "+n;
			else
				msg="Something went wrong.. Please Check";
			rd=req.getRequestDispatcher("/Register.jsp");
			req.setAttribute("insertMsg", msg);
			rd.forward(req, res);
		}
		
		if(param.equalsIgnoreCase("link3")) {
			int sno=0;
			int id=0;
			String msg=null;
			//get form parameter data
			sno=Integer.parseInt(req.getParameter("sno"));
			//use delegate object
			try {
				delegate=new OneToOneDelegate();
				id=delegate.deleteStudentAndTheirLibraryDetailsDelegate(sno);
				msg="Student with Sno "+sno+" deleted with their library details";
				req.setAttribute("msg", msg);
				if(id!=0) {
					stdList=delegate.getAllStudentsAndTheirDetailsDelegate();
					req.setAttribute("stdList", stdList);
					rd=req.getRequestDispatcher("/Details.jsp");
					rd.forward(req, res);
				}
				else {
					rd=req.getRequestDispatcher("/Error.jsp");
					rd.forward(req, res);
				}
			} catch (DeletionProblemException | DataRetrievingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
