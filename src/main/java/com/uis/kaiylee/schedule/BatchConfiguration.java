package com.uis.kaiylee.schedule;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableBatchProcessing
@ComponentScan
//spring boot configuration
@EnableAutoConfiguration
// file that contains the properties
@PropertySource("classpath:application.yml")
public class BatchConfiguration {

	/*
	 * @Value("${database.driver}") private String databaseDriver;
	 * 
	 * @Value("${database.url}") private String databaseUrl;
	 * 
	 * @Value("${database.username}") private String databaseUsername;
	 * 
	 * @Value("${database.password}") private String databasePassword;
	 */
	 
	
	
}
