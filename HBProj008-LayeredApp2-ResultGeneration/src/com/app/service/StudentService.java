package com.app.service;

import com.app.bo.StudentBO;
import com.app.dao.IStudentDao;
import com.app.dao.StudentDaoFactory;
import com.app.dto.StudentDTO;

public class StudentService {
	public String generateResult(StudentDTO dto) {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentBO bo=null;
		//calculate the result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3;
		if(avg>=35) {
			result="Pass";
		} else
			result="Fail";
		//set the Student dto object to student bo object
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use Dao object
		IStudentDao dao=StudentDaoFactory.getInstance();
		int no=dao.insert(bo);
		//use StudentDao class object
		
		return no+" Student avg="+avg+" and Result="+result;
	}
}
