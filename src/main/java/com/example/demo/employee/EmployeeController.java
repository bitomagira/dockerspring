package com.example.demo.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService myService;
	
	@RequestMapping("/employees")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Employee> getEmployee()
	{
		return myService.getAllEmployees();
	}
	@RequestMapping(method = RequestMethod.POST,value="/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return myService.saveEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return myService.findEmployee(id);		
	}
	
	
	@RequestMapping(method = RequestMethod.PATCH,value = "/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Map<String,String> user) {
		
		Employee employee = myService.findEmployee(id);
		//employee.setSurname(user.get("surname"));
		myService.saveEmployee(employee);
		return employee;
	}

}
