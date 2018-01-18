package com.capgemini.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

	@Query("update empRecords set employeeName =:empName where employeeId =:empId")
	public List<Employee> updateEmployeeRecords(@Param("empId") String empId, @Param("empName") String empName);
}
