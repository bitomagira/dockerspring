package com.example.demo.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employee {
	@Id
	int id;
	String name;
	String surname;
	String jobtitle;
	
	public employee(int id, String name, String surname, String jobtitle) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.jobtitle = jobtitle;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	
	
}
