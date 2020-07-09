package com.olmedo.evfinal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

	@Autowired
	DataSource datasource;
	
	
}
