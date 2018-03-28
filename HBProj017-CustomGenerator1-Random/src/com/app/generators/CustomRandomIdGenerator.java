package com.app.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIdGenerator implements IdentifierGenerator {
	public CustomRandomIdGenerator() {
		System.out.println("Custome Id generator: 0 Param constructor !!");
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		System.out.println("Custome Id generator: generator(-,-) !!");
		Random rad=null;
		int idVal=0;
		//generate psuedo Random number as id value
		rad=new Random();
		idVal=rad.nextInt(10000);
		return idVal;
	}
}
