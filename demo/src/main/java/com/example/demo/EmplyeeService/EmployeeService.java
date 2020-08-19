package com.example.demo.EmplyeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public Employee addEmployee(Employee emp) {
		return repository.save(emp);
	}

	public Employee findById(int id) {
		try {
			if(repository.findById(id) != null) {
				return repository.findById(id).get();
			}
			else {
				throw new Exception("Record Not found");
			}
		}catch(Exception e) {
			e.getStackTrace();
			return null;
		}
		
		 
	}

	public String deleteEmployee(int id) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent()) {
			repository.deleteById(id);
			return "Record Deleted";
		}
		else {
			return "Record not found";
		}
		
		
	}

	public List getallEmployee() throws Exception {
		if(repository.findAll()==null) {
			throw new Exception("No record Found");
		}
		else {
			Employee emp = new Employee();
			
			return (List) repository.findAll();
		}
		
	}
}
