package com.capgemini.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.service.EmployeeService;

@RestController
public class crudEmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emp")
	public String greetEmployee(){
		return "Hello Employee Portal";
	}
	
	@RequestMapping("/getAllEmp")
	public List<Employee> getAllEmployeeList(){
		return employeeService.getAllEmp();
	}
	
	@RequestMapping(value="/getEmp/{id}")
	public Employee getEmployee(@PathVariable("id") String id){		
		return employeeService.getEmp(id);
	}
	
	@RequestMapping(value="/addEmp", method= RequestMethod.POST)
	public List<Employee> addEmployee(@RequestBody Employee employee){
		return employeeService.addEmp(employee);
	}
	
	/*@RequestMapping(value="/updateEmp/{id}", method= RequestMethod.POST)
	public List<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") String id){
		return employeeService.updateEmp(id,employee);
	}*/
	
	@RequestMapping(value="/deleteEmp", method= RequestMethod.POST)
	public List<Employee> deleteEmployee(@RequestBody Employee employee){
		return employeeService.deleteEmp(employee);
	}	
}



