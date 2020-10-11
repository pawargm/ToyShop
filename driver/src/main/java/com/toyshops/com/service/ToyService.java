package com.toyshops.com.service;

import java.sql.SQLException;
import java.util.List;

import com.toyshops.com.model.Customer;
import com.toyshops.com.model.Toy;

public interface ToyService {
	public boolean insert(Toy toyobj) throws SQLException;
	public Toy search(long toyID) throws SQLException;
	public List<Toy> display() throws SQLException ;
	public boolean deleteRecord(long toyId) throws SQLException;
	public boolean updateRecord(Toy toyObj) throws SQLException; 
}
