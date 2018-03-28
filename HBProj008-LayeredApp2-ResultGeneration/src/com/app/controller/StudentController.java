package com.app.controller;

import com.app.dto.StudentDTO;
import com.app.service.StudentService;

public class StudentController {
	public String process(int sno, String sname, int m1,int m2, int m3) {
		StudentDTO dto=null;
		StudentService service=null;
		String result=null;
		//set the value in StudentDto class
		dto=new StudentDTO();
		dto.setSno(sno);
		dto.setSname(sname);
		dto.setM1(m1);
		dto.setM2(m2);
		dto.setM3(m3);
		//use studentservice class
		service=new StudentService();
		result=service.generateResult(dto);
		return result;
	}
}
