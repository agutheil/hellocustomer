package de.agutheil.hellocustomer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.agutheil.hellocustomer.api.Customer;
import de.agutheil.hellocustomer.api.CustomerDAO;
import de.agutheil.hellocustomer.api.CustomerService;

//@Service("customerService")
public class DefaultCustomerService implements CustomerService {
	
	private CustomerDAO customerDAO;

	@Autowired
	public DefaultCustomerService(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Override
	public Customer findCustomerById(long id) {
		return customerDAO.findCustomerById(id);
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		return customerDAO.createCustomer(firstname, lastname);
	}

}
