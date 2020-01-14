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
	public List<employee> getEmployee()
	{
		return myService.getAllEmployees();
	}
	@RequestMapping(method = RequestMethod.POST,value="/employees")
	public employee createEmployee(@RequestBody employee employee) {
		return myService.saveemployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}")
	public employee getneEmployee(@PathVariable int id) {
		return myService.findEmployee(id);		
	}
	
	
	@RequestMapping(method = RequestMethod.PATCH,value = "/employees/{id}")
	public employee updateemployee(@PathVariable int id, @RequestBody Map<String,String> user) {
		
		employee employee = myService.findEmployee(id);
		employee.setSurname(user.get("surname"));
		myService.saveemployee(employee);
		return employee;
	}

}
