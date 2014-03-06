package de.agutheil.hellocustomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RuntimeApplicationConfiguration.class})
public class DefaultCustomerServiceIntegrationTest {
	
	static final long CUSTOMER_ID = 1;
	static final String CUSTOMER_FIRST_NAME = "John";
	static final String CUSTOMER_LAST_NAME = "Doe";
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void testThatCustomerIsCreated() {
		Customer customer = customerService.createCustomer(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME);
		assertNotNull(customer);
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstname());
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastname());
	}
	
	@Test
	public void testThatCustomerIsFoundById() {
		Customer customer = customerService.createCustomer(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME);
		customer = customerService.findCustomerById(customer.getId());
		assertNotNull(customer.getId());
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstname());
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastname());
	}
	
	
}
