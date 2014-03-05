package de.agutheil.hellocustomer;

public interface CustomerService {
	public Customer findCustomerById(long id);
	public Customer createCustomer(String firstname, String lastname);
}
