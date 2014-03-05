package de.agutheil.hellocustomer;

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
			return null;
		}
		
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		return new Customer(DUMMY_START_ID, firstname, lastname);
	}

}
