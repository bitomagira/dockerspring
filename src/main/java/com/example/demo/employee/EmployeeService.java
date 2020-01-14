package com.example.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	@Autowired
	private Employeerepo myrepo;
	
	public List<employee> getAllEmployees(){
		return myrepo.findAll();
	}

	public employee saveemployee(employee employee) {
		myrepo.save(employee);
		return employee;
	}
	
	public employee findEmployee(int id) {
		return myrepo.findById(id).get();
	}
}
