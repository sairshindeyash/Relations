package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/{id}")
	public Employee getEmpbyId(@PathVariable Integer id) {
		System.out.println("id====" + id);
		return employeeService.getEmployeeById(id).get();
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "employee with empid " + id + " deleted";
	}

	@GetMapping(value="/employeesByDepartment/{id}")
	public List<Employee> getEmployeesInADepartment(@PathVariable Integer id) {
		System.out.println("from controller id======" + id);
		return employeeService.getAllEmployeesInADepartment(id);
	}

}
