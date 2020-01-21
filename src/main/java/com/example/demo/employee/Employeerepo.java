package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Employeerepo extends JpaRepository<Employee, Integer>{
	

}
