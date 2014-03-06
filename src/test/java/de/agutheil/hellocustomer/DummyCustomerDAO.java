package de.agutheil.hellocustomer;

import de.agutheil.hellocustomer.api.Customer;
import de.agutheil.hellocustomer.api.CustomerDAO;

public class DummyCustomerDAO implements CustomerDAO {
	
	public static final int DUMMY_START_ID = 666;
	
	private Customer customer;

	public DummyCustomerDAO(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Customer findCustomerById(long id) {
		if (customer.getId() == id) {
			return customer;
		} else {
			throw new RuntimeException();
		}
		
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		return new Customer(DUMMY_START_ID, firstname, lastname);
	}

}
