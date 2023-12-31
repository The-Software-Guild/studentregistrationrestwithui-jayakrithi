package com.wileyedge.userRestfulwebservice;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.wileyedge.userRestfulwebservice")
@PropertySource("classpath:mysql.properties")
public class UserRestfulwebserviceApplication {
	
	//The config data in mysql.properties is added in Environment,
	// if @PropertySource("classpath:mysql.properties") is given
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(UserRestfulwebserviceApplication.class, args);
	}
	
	@Bean
	@ConditionalOnMissingBean
	public DataSource datasource() {
		System.out.println("Inside datasource method");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  
	   dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	   dataSource.setUrl("jdbc:mysql://localhost:3307/userdb?createDatabaseIfNotExist=true");
	   dataSource.setUsername("root");
	   dataSource.setPassword("root");
	   return dataSource;
		
	}
	
	/*include entityManagerFactory bean only if a dataSource bean is present. 
	 * sequence matters.define dataSource bean prior. */
	
	@Bean(name = "entityManagerFactory")
	@ConditionalOnBean(name = "dataSource")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("Inside LocalContainerEntityManagerFactoryBean method");
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasource());
		em.setPackagesToScan("com.wileyedge.*");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	public Properties additionalProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",env.getProperty("mysql-hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("mysql-hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("mysql-hibernate.show_sql"));
		return hibernateProperties;
	}
}
