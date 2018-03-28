package com.app.dao;

import com.app.dao.impl.StudentDaoImpl;

public class StudentDaoFactory {
	public static StudentDaoImpl getInstance() {
		return new StudentDaoImpl();
	}
}
