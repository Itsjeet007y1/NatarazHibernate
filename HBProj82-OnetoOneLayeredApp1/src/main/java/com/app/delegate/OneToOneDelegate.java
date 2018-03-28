package com.app.delegate;

import java.util.List;

import com.app.dao.OneToOneDao;
import com.app.dao.OneToOneDaoFactory;
import com.app.domain.Student;
import com.app.dto.StudentDTO;
import com.app.exceptions.DataRetrievingException;
import com.app.exceptions.DeletionProblemException;
import com.app.exceptions.StudentAlreadyExistException;

public class OneToOneDelegate {
	public List<Student> getAllStudentsAndTheirDetailsDelegate() throws DataRetrievingException{
		OneToOneDao dao=null;
		List<Student> stdList=null;
		//get dao object
		dao=OneToOneDaoFactory.getInstance();
		//get the data from dao object
		try {
			stdList=dao.getAllStudentsAndTheirLibraryMembershipDetails();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stdList;
	}
	public int insertStudentsAndTheirLibraryDetailsDelgate(Student std) throws StudentAlreadyExistException{
		OneToOneDao dao=null;
		int n=0;
		//get dao class object
		dao=OneToOneDaoFactory.getInstance();
		//use dao class object
		n=dao.insertStudentWithLibraryDetails(std);
		return n;
	}
	public int deleteStudentAndTheirLibraryDetailsDelegate(int sid) throws DeletionProblemException{

		OneToOneDao dao=null;
		//get dao class object
		dao=OneToOneDaoFactory.getInstance();
		//use dao class object
		int sno=dao.deleteStudentWithLibraryDetails(sid);
		return sno;
	}
}
