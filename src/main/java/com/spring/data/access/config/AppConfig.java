package com.spring.data.access.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring.data.access")
@PropertySource("classpath:database.properties")
public class AppConfig {
	
	private final String DATABASE_URL = "database.mysql.url";
	private final String DATABASE_DRIVER = "database.mysql.driver";
	private final String DATABASE_USERNAME = "database.mysql.username";
	private final String DATABASE_PASSWORD = "database.mysql.password";

	@Autowired
	Environment environment;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(DATABASE_URL));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DATABASE_DRIVER));
		driverManagerDataSource.setUsername(environment.getProperty(DATABASE_USERNAME));
		driverManagerDataSource.setPassword(environment.getProperty(DATABASE_PASSWORD));
		
		return driverManagerDataSource;
	}
}
