package de.agutheil.hellocustomer.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import de.agutheil.hellocustomer.api.Customer;
import de.agutheil.hellocustomer.api.CustomerDAO;

//@Repository("customerDAO")
public class H2CustomerDAO implements CustomerDAO {
	
	public static final int START_ID = 1000;
	
	private long currentID = START_ID;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public H2CustomerDAO(DataSource dataSource) {
		super();
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	
	public Customer findCustomerById(long id) {
		Customer customer = this.jdbcTemplate.queryForObject(
		        "select ID, FIRSTNAME, LASTNAME from CUSTOMER where ID = ?",
		        new Object[]{id},
		        new RowMapper<Customer>() {
		            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	Customer customer = new Customer();
		            	customer.setFirstname(rs.getString("FIRSTNAME"));
		            	customer.setLastname(rs.getString("LASTNAME"));
		            	customer.setId(rs.getLong("ID"));
		                return customer;
		            }
		        });
		return customer;
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		currentID = currentID + 10;
		this.jdbcTemplate.update(
		        "insert into CUSTOMER (ID, FIRSTNAME, LASTNAME) values (?,?, ?)",
		         currentID, firstname, lastname);
		return new Customer(currentID, firstname, lastname);
	}

}
