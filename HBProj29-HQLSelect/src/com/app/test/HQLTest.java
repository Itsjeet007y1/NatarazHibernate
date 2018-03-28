package com.app.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.domain.BookDetails;
import com.app.utility.HibernateUtil;

public class HQLTest {
	public static void main(String[] args) {
		Session session=null;
		//get Session object
		session=HibernateUtil.getSession();
		//create Query
		Query query=session.createQuery("from BookDetails where catagory=?2");
		//execute hql
		query.setParameter("2", "php");
		List<BookDetails> list=query.list();
		//iterate the list
		/*for(BookDetails bd:list) {
			System.out.println(bd.getBookId()+"--------- "+bd.getBookName()+"-------------"+bd.getAuthor()+"------------"+bd.getStatus()+"-------------"+bd.getCatagory());
		}*/
		list.forEach(bd-> {
			System.out.println(bd.getBookId()+"-- "+bd.getBookName()+"--"+bd.getAuthor()+"--"+bd.getStatus()+"--"+bd.getCatagory());
		});
	}
}
