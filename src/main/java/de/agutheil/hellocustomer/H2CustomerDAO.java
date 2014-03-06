package de.agutheil.hellocustomer;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("h2customerDAO")
public class H2CustomerDAO implements CustomerDAO {
	
	public static final long START_ID = 1000;
	
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
		        "select id, first_name, last_name from t_actor where id = ?",
		        new Object[]{id},
		        new RowMapper<Customer>() {
		            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	Customer customer = new Customer();
		            	customer.setFirstname(rs.getString("first_name"));
		            	customer.setLastname(rs.getString("last_name"));
		            	customer.setId(rs.getLong("id"));
		                return customer;
		            }
		        });
		return customer;
	}

	@Override
	public Customer createCustomer(String firstname, String lastname) {
		this.jdbcTemplate.update(
		        "insert into customer (id, first_name, last_name) values (?, ?, ?)",
		        currentID++, firstname, lastname);
		return findCustomerById(currentID);
	}

}
