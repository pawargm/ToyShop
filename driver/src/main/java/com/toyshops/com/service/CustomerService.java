package com.toyshops.com.service;

import java.sql.SQLException;
import java.util.List;

import com.toyshops.com.model.Customer;

public interface CustomerService {
	
	public boolean insert(Customer custobj) throws SQLException;
	public Customer search(long custID) throws SQLException;
	public List<Customer> display() throws ClassNotFoundException, SQLException;
	public boolean deleteRecord(long custID) throws SQLException;
	public boolean updateRecord(Customer custObj) throws SQLException;
	
}
