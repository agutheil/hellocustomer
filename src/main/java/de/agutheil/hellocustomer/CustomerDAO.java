package de.agutheil.hellocustomer;

public interface CustomerDAO {

	Customer findCustomerById(long id);

	Customer createCustomer(String firstname, String lastname);

}
