package de.agutheil.hellocustomer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DefaultCustomerServiceIntegrationTest.class,
		DefaultCustomerServiceTest.class })
public class CustomerTests {

}
