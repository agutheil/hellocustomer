package de.agutheil.hellocustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

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
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
