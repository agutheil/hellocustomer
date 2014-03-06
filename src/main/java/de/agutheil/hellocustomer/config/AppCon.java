package de.agutheil.hellocustomer.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import de.agutheil.hellocustomer.api.CustomerDAO;
import de.agutheil.hellocustomer.api.CustomerService;
import de.agutheil.hellocustomer.impl.DefaultCustomerService;
import de.agutheil.hellocustomer.impl.H2CustomerDAO;

@Configuration
public class AppCon {
	@Bean
	DataSource dataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("test-data.sql");
	    return builder.build();
	}
	@Bean
	CustomerDAO customerDAO(DataSource dataSource){
		return new H2CustomerDAO(dataSource);
	}
	
	@Bean
	CustomerService customerService(CustomerDAO customerDAO){
		return new DefaultCustomerService(customerDAO);
	}
}
