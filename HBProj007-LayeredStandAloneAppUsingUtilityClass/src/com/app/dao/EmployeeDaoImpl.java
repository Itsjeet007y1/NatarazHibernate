package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.domain.Employee;
import com.app.utility.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public int register(int empId, String empName, double empSal, String empMail) {
		Session session = null;
		Employee emp;
		Transaction tx = null;
		int id = 0;
		session = HibernateUtil.getSession();
		emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpSal(empSal);
		emp.setEmpMail(empMail);
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void modify(int empId, String empMail) {
		Session session = null;
		Employee emp = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		emp = search(empId);
		if (emp != null) {
			try {
				tx = session.beginTransaction();
				session.update(empMail);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		}
	}

	@Override
	public Employee search(int empId) {
		Session session = null;
		Employee emp = null;
		session = HibernateUtil.getSession();
		emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}

	@Override
	public void remove(int empId) {
		Session session = null;
		Employee emp = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		// load object
		emp = search(empId);
		// delete object
		if (emp != null) {
			try {
				tx = session.beginTransaction();
				session.delete(emp);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
		} else {
			System.out.println("Record not Found..");
		}
	}
}
