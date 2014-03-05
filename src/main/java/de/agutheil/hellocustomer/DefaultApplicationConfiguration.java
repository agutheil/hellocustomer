package de.agutheil.hellocustomer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages="de.agutheil.hellocustomer")
public class DefaultApplicationConfiguration {
	@Bean
	CustomerDAO customerDAO(){
		CustomerDAO customerDAO = new RuntimeCustomerDAO();
		customerDAO.createCustomer("Martin", "Fowler");
		customerDAO.createCustomer("Robert", "Martin");
		return customerDAO;
	}
}
