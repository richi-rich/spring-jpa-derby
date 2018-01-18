package com.capgemini.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.demo.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

	/*@Modifying(clearAutomatically = true)
	@Query("update emprecords set emprecords.employeeName =:empName where emprecords.employeeId =:empId")
	public void updateEmployeeRecords(@Param("empId") String empId, @Param("empName") String empName);
*/}
