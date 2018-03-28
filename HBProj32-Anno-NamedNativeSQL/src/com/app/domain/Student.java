package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student_tab")
@NamedNativeQueries(value={@NamedNativeQuery(name="GET_STUDS_BY_ADDRS",
                                                          query="SELECT * FROM STUDENT_TAB WHERE STADD=:addrs",
                                                          resultClass=Student.class),
		                                               @NamedNativeQuery(name="DELETE_STUDS_BY_ADDRS",
		                                                                                      query="DELETE FROM STUDENT_TAB WHERE STADD=:addrs")

                                                      })
public class Student {
	@Column(name="stno")
	@Id
	private int sno;
	@Column(name="stname")
	private String sname;
	@Column(name="stadd")
	@Transient
	private String sadd;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
   
	
}
