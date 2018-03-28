package com.app.dao;

import java.util.List;

import com.app.domain.Student;
import com.app.dto.StudentDTO;

public interface OneToOneDao {
	public List<Student> getAllStudentsAndTheirLibraryMembershipDetails();
	public int insertStudentWithLibraryDetails(Student std);
	public int deleteStudentWithLibraryDetails(int sno);
}
