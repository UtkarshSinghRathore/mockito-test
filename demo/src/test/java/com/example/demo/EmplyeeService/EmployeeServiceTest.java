package com.example.demo.EmplyeeService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;



@SpringBootTest
class EmployeeServiceTest {
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository Repository;
	
	@Test 
	void testAddEmployee() {
		Employee employee = new Employee(2, "Utkarsh", 18, "utkarsh@123", 15000);
		when(Repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}
//
//	@Test
//	void testFindById() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testDeleteEmployee() {
		Employee employee = new Employee(2, "Utkarsh", 18, "utkarsh@123", 15000);
		service.deleteEmployee(2);
		verify(Repository,times(2)).delete(employee);
	}

	@Test
	void testGetallEmployee() throws Exception {
		when(Repository.findAll()).thenReturn(java.util.stream.Stream.
				of(new Employee(1, "Utkarsh", 18, "utkarshsinghrathore1", 15000),new Employee(2, "Akshay",
						28, "ak@123", 1234)).collect(Collectors.toList()));
		
		assertEquals(2, service.getallEmployee().size());
	}

}
