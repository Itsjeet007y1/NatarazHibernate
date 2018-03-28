package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Type;

@Entity
@Table(name="student")
@NamedNativeQuery(name="CALL_PROCEDURE",
query="{call P_GET_STUDS_BY_NAMECHARS(?,:initChars)}",
callable=true,
resultClass=com.app.domain.Student.class
)

public class Student {
	@Id
	@Column(name="no")
	private int sno;
	@Column(name="name")
	private String sname;
	@Column(name="addrs")
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

/*create or replace procedure
P_GET_STUDS_BY_NAMECHARS(details out sys_refcursor,domain in varchar2)
	as begin
	open details for
	select name, addrs from student where name like domain;
end;
*/
