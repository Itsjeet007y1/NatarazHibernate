package com.app.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.app.utility.HibernateUtil;

@WebListener
public class HibernateObjectsClosingListeners implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		System.out.println("Context Destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Initialized");
		ServletContextListener.super.contextInitialized(sce);
	}
}
