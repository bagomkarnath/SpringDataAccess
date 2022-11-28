package com.spring.data.access.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("EMP_ID"));
		emp.setFirstName(rs.getString("FIRST_NAME"));
		emp.setLastName(rs.getString("LAST_NAME"));
		emp.setAddress(rs.getString("ADDRESS"));
		emp.setCity(rs.getString("CITY"));
		return emp;
	}

}
