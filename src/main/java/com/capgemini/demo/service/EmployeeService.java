package com.capgemini.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.exceptionHandler.EmplyeeNotFoundException;
import com.capgemini.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//List<Employee> empList =  Arrays.asList(new Employee("Richa","1"),new Employee("Mayur","2"),new Employee("Mallika","3"));
		
	public List<Employee> getAllEmp(){		
		return (List)employeeRepository.findAll();
	}
	
	public List<Employee> addEmp (Employee emp){
		employeeRepository.save(emp);
		return (List)employeeRepository.findAll();
	}
	
	public Employee getEmp(String id){
		this.validateInput(id);		
	//	employeeRepository.findOne(id);
		return employeeRepository.findOne(id);
	}
	
	/*public List<Employee> updateEmp (String empId,Employee emp){
		employeeRepository.updateEmployeeRecords(empId, emp.getName());		
		return (List)employeeRepository.findAll();
	}*/
	
	public List<Employee> deleteEmp (Employee emp){
		employeeRepository.delete(emp);;
		return (List)employeeRepository.findAll();
	}
	
	public void validateInput(String id){
		int eid = Integer.parseInt(id);
		if(eid < 0){
			throw new EmplyeeNotFoundException("invalid Id Input");
		}
	}
}
