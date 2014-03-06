package de.agutheil.hellocustomer.api;

public interface CustomerService {
	public Customer findCustomerById(long id);
	public Customer createCustomer(String firstname, String lastname);
}
