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
		cfg=cfg.configure("com/ds/cfg/hibernate.cfg.xml");
		// create HB SessionFactory,Session objs
		SessionFactory factory=cfg.buildSessionFactory();
		Session ses=factory.openSession();
		
		/*//select a record /Load obj
		EmpBean eb=(EmpBean)ses.get(EmpBean.class,1102);
		//Update object
		Transaction tx=ses.beginTransaction();
		   eb.setMail("raja@x.com");*/
		
		EmpBean eb=new EmpBean();
		eb.setNo(102);
		eb.setFname("Rahul");
		eb.setLname("Singh");
		eb.setMail("Rahul.singh@gmail.com");
		ses.save(eb);
		Transaction tx=ses.beginTransaction();
		tx.commit();
		//close objs
	     ses.close();
		factory.close(); 
	}//main
}//class

