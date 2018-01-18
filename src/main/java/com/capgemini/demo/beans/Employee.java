package com.capgemini.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="empRecords")
public class Employee {

	@Column(name="employeeName")
	String name;
	
	@Id
	@Column(name="employeeId")
	String id;
	
	Employee() {
	}
	
	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
		
}
