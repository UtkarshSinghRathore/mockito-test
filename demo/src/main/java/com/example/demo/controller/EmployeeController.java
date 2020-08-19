package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmplyeeService.EmployeeService;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addorUpdate")
	public Employee addEmplyee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@GetMapping("/{Id}")
	public Employee findEmployeebyId(@PathVariable("Id") int id) {
		return service.findById(id);
		
	}
	@DeleteMapping("/{Id}")
	public String deleteEmployee(@PathVariable("Id") int id)
	{
		return service.deleteEmployee(id);
	}
	@GetMapping("/employees")
	public List getAllEmployees() throws Exception {
		return service.getallEmployee();
	}
	
}
