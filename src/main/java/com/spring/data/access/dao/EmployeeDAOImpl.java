package com.spring.data.access.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.data.access.model.Employee;
import com.spring.data.access.model.EmployeeMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	JdbcTemplate jdbcTemplate;
	
	private final String QUERY_FIND_EMPLOYEE_BY_ID = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
	private final String QUERY_FIND_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";
	private final String QUERY_CREATE_EMPLOYEE = "INSERT INTO EMPLOYEE(EMP_ID,FIRST_NAME, LAST_NAME, ADDRESS, CITY) VALUES(?,?,?,?,?)";
	private final String QUERY_DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
	private final String QUERY_UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, CITY = ? WHERE EMP_ID = ?";
	
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return jdbcTemplate.queryForObject(QUERY_FIND_EMPLOYEE_BY_ID, new EmployeeMapper(), id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(QUERY_FIND_ALL_EMPLOYEE, new EmployeeMapper());
	}

	@Override
	public boolean createEmployee(Employee emp) {
		return jdbcTemplate.update(QUERY_CREATE_EMPLOYEE, emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getAddress(), emp.getCity()) > 0;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		return jdbcTemplate.update(QUERY_UPDATE_EMPLOYEE, emp.getFirstName(), emp.getLastName(), emp.getAddress(), emp.getCity(), emp.getId()) > 0;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		return jdbcTemplate.update(QUERY_DELETE_EMPLOYEE, emp.getId()) > 0;
	}

}
