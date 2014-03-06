package de.agutheil.hellocustomer.api;

public interface CustomerDAO {

	Customer findCustomerById(long id);

	Customer createCustomer(String firstname, String lastname);

}
