package com.app.service.impl;

import com.app.bo.StudentBO;
import com.app.dao.StudentDaoFactory;
import com.app.dao.impl.StudentDaoImpl;
import com.app.dto.StudentDTO;
import com.app.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	
	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo;
		StudentDaoImpl dao;
		//basic calculation
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3;
		if(avg>35) {
			result=" Student Passed with "+avg+"% marks";
		} else
			result=" Student Failed with "+avg+"% marks";
		//copy StudentDto object to studentbo object
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use StudentDao object
		dao=StudentDaoFactory.getInstance();
		int no=dao.insert(bo);
		return no+result;
	}
}
