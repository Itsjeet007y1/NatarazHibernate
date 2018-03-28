package com.app.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.domain.PhoneNumber;
import com.app.domain.User;
import com.app.utility.HibernateUtil;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void saveDataUsingParent() {
		Session session = null;
		User user = null;
		PhoneNumber ph1, ph2 = null;
		Set<PhoneNumber> childs = null;
		// get session object
		session = HibernateUtil.getSession();
		// create parent object
		user = new User();
		user.setUserId(101);
		user.setUserName("Jitu");
		// create child object
		ph1 = new PhoneNumber();
		ph1.setPhone(8406088592L);
		ph1.setNumberType("Permanent");
		ph2 = new PhoneNumber();
		ph2.setPhone(8127558055L);
		ph2.setNumberType("Old Number");
		childs = new HashSet<PhoneNumber>();
		childs.add(ph1);
		childs.add(ph2);
		// set childs to parent
		user.setPhones(childs);
		// save object parent to child
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
			System.out.println("User data saved");
		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
			System.out.println("Internal Problem..");
		}
	}

	@Override
	public void loadDataUsingParent() {
		Session session = null;
		Query query = null;
		List<User> userList = null;
		Set<PhoneNumber> phoneSet = null;
		// get Session object
		session = HibernateUtil.getSession();
		// create query object
		query = session.createQuery("from User");
		// execute query and fetch data
		userList = query.list();
		for (User u : userList) {
			System.out.println("Parent Record-->" + u.getUserId() + "-----" + u.getUserName());
			// child using parent
			phoneSet = u.getPhones();
			//phoneSet.isEmpty();     ............................enable & disable this line and configure lazy=true,false and extra in hibernate configuration file to see the effects
			/*for (PhoneNumber p : phoneSet) {
				System.out.println("Child Records-->" + p.getPhone() + "----" + p.getNumberType());
			}*/
		}
	}

	@Override
	public void deleteDataUsingParent() {
		Session session = null;
		User user = null;
		Transaction tx = null;
		// get Session object
		session = HibernateUtil.getSession();
		// load parent object
		user = session.get(User.class, 102);
		// delete child object associated with parent object
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			System.out.println("Parent object and associated child object deleted...");
		} catch (Exception e) {
			tx.rollback();
		} // catch
	}// method

	@Override
	public void deleteOneChildFromCollectionOfChildsInAParent() {
		Session session = null;
		User user = null;
		Set<PhoneNumber> childs = null;
		PhoneNumber ph = null;
		Transaction tx = null;
		// get Session object
		session = HibernateUtil.getSession();
		// load parent
		user = session.get(User.class, 101);
		// get child from a parent
		childs = user.getPhones();
		// load child objec from db whom u want to delete
		ph = (PhoneNumber) session.get(PhoneNumber.class, (Long) 8127558055l);
		// delete child from collections of childs
		try {
			tx = session.beginTransaction();
			childs.remove(ph);
			tx.commit();
			System.out.println("Removing child from collection of child operation successfull...");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void addingNewChildToExistingParent() {
		Session session = null;
		User user = null;
		Set<PhoneNumber> childs = null;
		PhoneNumber ph3 = null;
		Transaction tx = null;
		// get Session object
		session = HibernateUtil.getSession();
		// load existing parent object
		user = session.get(User.class, 101);
		// get Existing child of a parent
		childs = user.getPhones();
		// create new child
		ph3 = new PhoneNumber();
		ph3.setPhone(4455669988l);
		ph3.setNumberType("General");
		try {
			tx = session.beginTransaction();
			childs.add(ph3);
			tx.commit();
			System.out.println("new Phone number added to existing phoneNumber..");
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void deleteAllChildsOfAParent() {
		Session session=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		//get session object
		session=HibernateUtil.getSession();
		//load parent
		user=session.get(User.class, 101);
		//get all childs
		childs=user.getPhones();
		//delete all childs
		 try {
			 tx=session.beginTransaction();
			 childs.removeAll(childs);
			 tx.commit();
			 System.out.println("All childs associated to parent deleted successfully...");
		 }catch(Exception e) {
			 tx.rollback();
		 }	
	}
}
