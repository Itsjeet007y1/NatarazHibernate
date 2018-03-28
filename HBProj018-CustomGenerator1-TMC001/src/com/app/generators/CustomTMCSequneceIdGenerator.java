package com.app.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomTMCSequneceIdGenerator implements IdentifierGenerator {
	private static final String GET_CUSTID_FROM_SEQ = "SELECT TMC_CUSTID_SEQUENCE.NEXTVAL FROM DUAL";

	@Override
	public Serializable generate(SessionImplementor session, Object domain) throws HibernateException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int val = 0;
		try {
			// get jdbc connection
			con = session.connection();
			// create prepare object statement
			ps = con.prepareStatement(GET_CUSTID_FROM_SEQ);
			// execute sequence and get result set
			rs = ps.executeQuery();
			// get sequence vlaue from result set
			if (rs.next()) {
				val = rs.getInt(1);
			}
			if (val < 9) {
				return "TMC000" + val;
			} else if (val < 99) {
				return "TMC00" + val;
			} else if (val < 999) {
				return "TMC0" + val;
			} else
				return "TMC" + val;
		} catch (SQLException se) {
			se.printStackTrace();
			return "Problem in ID Generation";
		} catch (Exception e) {
			e.printStackTrace();
			return "Problem in ID Generation";
		}
	}
}
