package com.app.service;

import com.app.dao.MobileNumberPortabilityDAO;
import com.app.dao.MobileNumberPortabilityDAOFactory;

public class MobileNumberPortabilityServiceImpl implements MobileNumberPortabilityService {

	@Override
	public String performMNP(long mobileNo) {
		MobileNumberPortabilityDAO dao=null;
		boolean flag=false;
		//get DAO
		dao=MobileNumberPortabilityDAOFactory.getInstance();
		//use DAO
		flag=dao.transfer(mobileNo);
		if(flag)
 		  return "Mobile Number Transffered successfully";
		else
			return "Mobile Number is not Transffered-->contact GIO/Airtel office ";
	}//performMNP

}
