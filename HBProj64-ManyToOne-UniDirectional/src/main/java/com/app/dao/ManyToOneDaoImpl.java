package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.app.domain.Department;
import com.app.domain.Employee;
import com.app.utility.HibernateUtil;

public class ManyToOneDaoImpl implements ManyToOneDao {

	@Override
	public void saveDataUsingChilds() {
		Session session=null;
		Department dept=null;
		boolean flag=false;
		Transaction tx=null;
		Employee emp1=null,emp2=null;
		//get session object
		session=HibernateUtil.getSession();
		//prepare parent and child objects
		dept=new Department();
		dept.setDeptNo(1);
		dept.setDeptName("IT");
		dept.setDeptHead("Smith");
		emp1=new Employee();
		emp1.setEmpNo(101);
		emp1.setEmpName("Anderson");
		emp1.setSalary(80000);
		emp2=new Employee();
		emp2.setEmpNo(102);
		emp2.setEmpName("Jeet");
		emp2.setSalary(90000);
		//set dept to emp1 and emp2 Many to one
		emp1.setDept(dept);
		emp2.setDept(dept);
		try {
			tx=session.beginTransaction();
			//save objects
			session.save(emp1);
			session.save(emp2);
			flag=true;
		} catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Object saved successfully...");
			} else {
				tx.rollback();
				System.out.println("Object not saved");
			}
		}
	}

	@Override
	public void loadDataUsingChilds() {
		Session session=null;
		Query query=null;
		List<Employee> list=null;
		//get session object
		session=HibernateUtil.getSession();
		//load childs objects
		query=session.createQuery("from Employee");
		list=query.list();
		list.forEach(l-> {
			Department dept;
			dept=l.getDept();
			System.out.println("child:"+l.getEmpNo()+"   "+l.getEmpName()+"   "+l.getSalary());
			System.out.println("Parent:"+dept.getDeptNo()+"   "+dept.getDeptName()+"   "+dept.getDeptHead());
		});
	}

	@Override
	public void deleteDataUsingChilds() {
		Session session=null;
		Query query=null;
		List<Employee> list=null;
		Transaction tx=null;
		//get Session object
		session=HibernateUtil.getSession();
		//load child object
		query=session.createQuery("from Employee");
		list=query.list();
		//delete child object
		try {
			tx=session.beginTransaction();
			for(Employee ed:list) {
				session.delete(ed);
			}
			tx.commit();
			System.out.println("Childs and its associated parent objects deleted..");
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOneChildOfAParent() {
		
		/*//Bad Code
		Session session=null;
		Employee emp=null;
		Transaction tx=null;
		//get Session object
		session=HibernateUtil.getSession();
		//load the child object
		emp=session.get(Employee.class, 101);
		//delete the loaded child
		try {
			tx=session.beginTransaction();
			session.delete(emp);
			tx.commit();
			System.out.println("One child associated to parent deleted...");
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//Good Code
		Session session=null;
		Query query=null;
		Transaction tx=null;
		//get Session Object
		session=HibernateUtil.getSession();
		//create hql query object
		String hql="delete from Employee where empNo=:eid";
		//execute query
		query=session.createQuery(hql);
		query.setInteger("eid", 101);
		try {
			tx=session.beginTransaction();
			query.executeUpdate();
			tx.commit();
			System.out.println("deleting only child even though cascade=all");
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void addNewChildToExistingParent() {
		Session session=null;
		Department dept=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//load the Department(parent) object
		dept=session.get(Department.class, 1);
		//prepate Employee(child) data to insert
		Employee emp=new Employee();
		emp.setEmpNo(105);
		emp.setEmpName("Michel");
		emp.setSalary(12000);
		emp.setDept(dept);
		//save the objects
		try {
			tx=session.beginTransaction();
			session.save(emp);
			tx.commit();
			System.out.println("New chidl to existing parent added successfully...");
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void addExistingChildToNewDepartment() {
		Session session=null;
		Employee emp=null;
		Department dept=null;
		Transaction tx=null;
		//create session object
		session=HibernateUtil.getSession();
		//load existing child object
		emp=session.get(Employee.class, 102);
		//prepare parent objects
		dept=new Department();
		dept.setDeptNo(2);dept.setDeptName("Science");dept.setDeptHead("Hari");
		//now add these dept details to loaded child object
		try {
			tx=session.beginTransaction();
			emp.setDept(dept);
			tx.commit();
			System.out.println("Existing employee's parent changed to new added parent...");
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void deleteAllChildsOfAParent() {
		Session session=null;
		Transaction tx=null;
		int result=0;
		//create session object
		session=HibernateUtil.getSession();
		//create Hql query
		Query query=session.createQuery("delete from Employee where empNo=:dn");
		query.setInteger("dn", 105);
		//execute the statement
		try {
			tx=session.beginTransaction();
			result=query.executeUpdate();
			tx.commit();
			System.out.println("No of rows affected are: "+result);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
