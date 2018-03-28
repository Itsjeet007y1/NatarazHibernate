package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;

public interface EmployeeService {
   public  int  getPageCount();
   public List<EmployeeDTO>  getReportData(int pageNo);
}
