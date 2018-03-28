package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.bo.EmployeeBO;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoFactory;
import com.app.dto.EmployeeDTO;
import com.app.utility.ReportParameters;

public class EmployeeServiceImpl implements EmployeeService {

	public int getPageCount() {
		int pagesCount=0;
		long recordsCount=0;
		EmployeeDao dao=null;
		//get & use DAO
		dao=EmployeeDaoFactory.getInstance();
		recordsCount=dao.getEmployeeCount();
		pagesCount=(int)recordsCount/ReportParameters.PAGE_SIZE;
		
		if(recordsCount%ReportParameters.PAGE_SIZE!=0)
			pagesCount++;
		return pagesCount;
	}

	public List<EmployeeDTO> getReportData(int pageNo) {
		  int startPos=0;
		  EmployeeDao dao=null;
		  List<EmployeeBO> listBO=null;
		  List<EmployeeDTO> listDTO=null;
		  EmployeeDTO dto=null;
         //get StartPos to get records for  pagination
		  startPos=(pageNo*ReportParameters.PAGE_SIZE)-ReportParameters.PAGE_SIZE;
		  //get & use DAO
			dao=EmployeeDaoFactory.getInstance();
		   listBO=dao.getEmployeeDetails(startPos);
		   //convert ListBO to ListDTO
		   listDTO=new ArrayList<EmployeeDTO>();
		   for(EmployeeBO bo:listBO){
			   dto=new EmployeeDTO();
			   dto.setEid(bo.getEid());
			   dto.setFirstName(bo.getFirstName());
			   dto.setLastName(bo.getLastName());
			   dto.setEmail(bo.getEmail());
			   listDTO.add(dto);
		   }
		return listDTO;
	}//method
}//class
