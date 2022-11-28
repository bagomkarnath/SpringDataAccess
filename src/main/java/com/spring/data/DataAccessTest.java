package com.spring.data;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.data.access.config.AppConfig;
import com.spring.data.access.dao.EmployeeDAO;
import com.spring.data.access.model.Employee;

public class DataAccessTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeDAO employeeDAO = ctx.getBean(EmployeeDAO.class);
		
		System.out.println("Show all Employees");
		
		employeeDAO.getAllEmployees().forEach(emp -> { System.out.println(emp); });
		
		System.out.println("--------------------------");
		
		System.out.println("Create an employee");
		
		Employee empNew = new Employee(2007, "Albert", "Einstien", "Franco Apartment", "Vizag");
		
		System.out.println("New Employee is : " + empNew);
		
		employeeDAO.createEmployee(empNew);
		
		System.out.println("--------------------------");
		
		System.out.println("Find new employee with id 2007");
		
		System.out.println(employeeDAO.getEmployeeById(2007));
		
		System.out.println("--------------------------");
		
		System.out.println("Update new employee firstName - Srinivas, lastName - B with id 2007");
		
		empNew.setFirstName("Srinivas");
		empNew.setLastName("B");
		
		System.out.println(employeeDAO.updateEmployee(empNew) ? "Successfully updated" : "Update failed"); 
		
		System.out.println("--------------------------");
		
		System.out.println("delete employee with id 2007");
		
		employeeDAO.deleteEmployee(empNew);
		
		employeeDAO.getAllEmployees().forEach(emp -> { System.out.println(emp); });
		
		ctx.close();
	}
}
