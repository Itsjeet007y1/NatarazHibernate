package com.app.test;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.type.Type;

import com.app.domain.BankAccount;


public class MetaDataClient {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/app/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session ses = factory.openSession();

		BankAccount account = ses.get(BankAccount.class, 10l);
		System.out.println(account.getAcno()+" "+account.getHolderName()+" "+account.getBalance());

		ClassMetadata mdata = factory.getClassMetadata(BankAccount.class);
		AbstractEntityPersister persister = (AbstractEntityPersister) mdata;

		String tableName = persister.getTableName();
		String[] idCols = persister.getIdentifierColumnNames();
		Type idType = persister.getIdentifierType();// should have been
													// getIdentifierTypes

		String[] columnNames = persister.getPropertyNames();
		Type[] columnTypes = persister.getPropertyTypes();

		System.out.println("Table Name :" + tableName);

		// This gives id column ie Primary Key,Composite Key
		System.out.println("Id col name"+Arrays.toString(idCols));
		System.out.println("\n Id col type=" + idType.getName());
		System.out.println("\n Other columns are");
		for (int i = 0; i < columnNames.length; i++) {
			System.out.println(columnNames[i] + " : "	+ columnTypes[i].getName());
			}

		ses.close();
		 factory.close();
	}// main

}// class
