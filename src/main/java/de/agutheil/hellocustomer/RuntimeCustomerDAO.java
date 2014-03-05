package de.agutheil.hellocustomer;

import java.util.HashMap;
import java.util.Map;

public class RuntimeCustomerDAO implements CustomerDAO {
	
	public static final long START_ID=1000;
	private long currentId;
	private Map<Long ,Customer> customers;
	

	public RuntimeCustomerDAO() {
		customers = new HashMap<Long ,Customer>();
		currentId = START_ID;
	}

	@Override
	public Customer findCustomerById(long id) {
		return customers.get(id);
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		Customer customer = new Customer(currentId++,firstname,lastname);
		customers.put(customer.getId(), customer);
		return customer;
	}

}
