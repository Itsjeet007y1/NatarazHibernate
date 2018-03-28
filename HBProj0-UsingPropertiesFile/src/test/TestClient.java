package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ds.pojo.EmpBean;

public class TestClient {
	public static void main(String[] args) {
		
		//Activate HB Framework
		Configuration cfg=new Configuration();
		
		//using properties file here rather using configuration file
		cfg.addResource("com/ds/cfg/Employee.hbm.xml");

		SessionFactory factory=cfg.buildSessionFactory();
		Session ses=factory.openSession();
		
		EmpBean eb=new EmpBean();
		eb.setNo(106);
		eb.setFname("Stuart");
		eb.setLname("williamson");
		eb.setMail("stuart.willi@gmail.com");
		ses.save(eb);
		Transaction tx=ses.beginTransaction();
		tx.commit();
		//close objs
	     ses.close();
		factory.close(); 
	}//main
}//class

