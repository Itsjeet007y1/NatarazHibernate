package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.pojo.Employee;

public class Test {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg=cfg.configure("com/nt/config/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Employee emp=new Employee();
		emp.setEmpId(101);
		emp.setfName("Jitendra");
		emp.setLname("Kumar");
		emp.setMail("jeet.62.jp@gmail.com");
		ses.save(emp);
		Transaction tx=ses.beginTransaction();
		tx.commit();
		ses.close();
		sf.close();
	}
}
