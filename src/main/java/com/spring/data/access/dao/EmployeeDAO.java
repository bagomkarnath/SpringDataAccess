package com.spring.data.access.dao;

import java.util.List;

import com.spring.data.access.model.Employee;

public interface EmployeeDAO {
	Employee getEmployeeById(int id);//read
	List<Employee> getAllEmployees(); // read all
	boolean createEmployee(Employee emp); //create
	boolean updateEmployee(Employee emp); //update
	boolean deleteEmployee(Employee emp); //delete
}
