package de.agutheil.hellocustomer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.agutheil.hellocustomer.api.Customer;
import de.agutheil.hellocustomer.api.CustomerDAO;
import de.agutheil.hellocustomer.api.CustomerService;
import de.agutheil.hellocustomer.config.AppCon;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppCon.class})
public class DefaultCustomerServiceIntegrationTest {
	
	static final long CUSTOMER_ID = 1;
	static final String CUSTOMER_FIRST_NAME = "John";
	static final String CUSTOMER_LAST_NAME = "Doe";
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void testThatCustomerIsCreatedAndFoundById() {
		test();
	}

	private void test() {
		Customer customer = customerService.createCustomer(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME);
		customer = customerService.findCustomerById(customer.getId());
		assertNotNull(customer.getId());
		assertEquals(CUSTOMER_FIRST_NAME, customer.getFirstname());
		assertEquals(CUSTOMER_LAST_NAME, customer.getLastname());
	}
	
	
}
