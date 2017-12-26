package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int emp_id;
	String emp_name;
	String emp_dept;
	
	public Student()
	{
		
	}
	public Student(int emp_id, String emp_name, String emp_dept) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
	}
	
	@Column(name="emp_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}

	@Override
	public String toString() {
		return "Student [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_dept=" + emp_dept + "]";
	}
	

}
