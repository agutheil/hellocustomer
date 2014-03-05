package de.agutheil.hellocustomer;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultCustomerServiceTest {
	static final long CUSTOMER_ID = 1;
	static final String CUSTOMER_FIRST_NAME = "John";
	static final String CUSTOMER_LAST_NAME = "Doe";
	
	CustomerService customerService;
	@Test
	public void testThatDefaultCustomerServiceExists() {
		customerService = new DefaultCustomerService(null);
	}
	
	@Test
	public void testThatCustomerIsFoundById() {
		CustomerDAO customerDAO = new DummyCustomerDAO(new Customer(CUSTOMER_ID, CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME));
		customerService = new DefaultCustomerService(customerDAO);
		Customer customer = customerService.findCustomerById(CUSTOMER_ID);
		assertEquals(CUSTOMER_ID, customer.getId());
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstname());
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastname());
	}
	
	@Test
	public void testThatCustomerIsCreated() {
		CustomerDAO customerDAO = new DummyCustomerDAO(new Customer(CUSTOMER_ID, CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME));
		customerService = new DefaultCustomerService(customerDAO);
		Customer customer = customerService.createCustomer(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME);
		assertNotNull(customer);
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstname());
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastname());
	}

}
