package de.agutheil.hellocustomer.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages={"de.agutheil.hellocustomer.impl"})
public class AppCon {
	@Bean
	DataSource dataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    builder.setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("test-data.sql");
	    return builder.build();
	}
}
