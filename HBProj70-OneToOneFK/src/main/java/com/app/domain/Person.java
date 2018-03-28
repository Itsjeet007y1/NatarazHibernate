package com.app.domain;

public class Person {
	private int pid;
	private String firstName,lastName;
	private byte age;
	public Person() {
		System.out.println("Person: 0-param constructor.");
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
