package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		System.out.println("In service"+id);
		return employeeRepository.findById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getAllEmployeesInADepartment(Integer id) {
		System.out.println("from service id======"+id);
		return employeeRepository.findByDepartmentId(id);
	}

}
