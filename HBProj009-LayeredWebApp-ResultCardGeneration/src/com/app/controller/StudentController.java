package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dto.StudentDTO;
import com.app.service.impl.StudentServiceImpl;
import com.app.utility.HibernateUtil;
import com.app.vo.StudentVO;

public class StudentController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		// general Setting
		pw = response.getWriter();
		StudentVO vo = null;
		StudentDTO dto = null;
		StudentServiceImpl service = null;
		response.setContentType("text/html");
		// read form data and copy to StudentVO object
		vo = new StudentVO();
		vo.setSno(request.getParameter("sno"));
		vo.setSname(request.getParameter("sname"));
		vo.setM1(request.getParameter("m1"));
		vo.setM2(request.getParameter("m2"));
		vo.setM3(request.getParameter("m3"));
		// copy the data from vo object to dto object
		dto = new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		// use Student Service class
		service = new StudentServiceImpl();
		try {
			String result = service.generateResult(dto);
			if (result != null) {
				pw.println("<h1 style='color:green'>"+result+" :) </h1>");
			} else {
				pw.println("Something went wrong!! Please check...");
			}
			HibernateUtil.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
