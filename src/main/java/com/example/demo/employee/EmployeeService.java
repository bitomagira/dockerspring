package com.example.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository myrepo;
	
	public List<Employee> getAllEmployees(){
		return myrepo.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		myrepo.save(employee);
		return employee;
	}
	
	public Employee findEmployee(int id) {
		return myrepo.findById(id).get();
	}
}
