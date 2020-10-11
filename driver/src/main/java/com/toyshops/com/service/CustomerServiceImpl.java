package com.toyshops.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toyshops.com.model.Customer;



public class CustomerServiceImpl implements CustomerService  {

	static  Customer [] CustomerArray;
	static Connection dbConn;
	
	//Constructor to intitalize dbConn 
	public CustomerServiceImpl() throws ClassNotFoundException, SQLException {
		dbConn = DAO.getConnection();
	}
	
	//Inserting recored to data base by passing customer object
	public boolean insert(Customer custobj) throws SQLException {
		// TODO Auto-generated method stub
		
		String insertQuery = "insert into Customer(customerId, firstName, lastName, emailId, password, cityName, stateName, countryName, zip) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = dbConn.prepareStatement(insertQuery);
		
		stmt.setLong(1, custobj.getCustomerId());
		stmt.setString(2, custobj.getFirstName() );
		stmt.setString(3, custobj.getLastName());
		stmt.setString(4, custobj.getEmailId());
		stmt.setString(5, custobj.getPassword());
		stmt.setString(6, custobj.getCityName());
		stmt.setString(7, custobj.getStateName());
		stmt.setString(8, custobj.getCountryName());
		stmt.setInt(9, custobj.getZip());
		
		boolean bln = stmt.execute();
		return bln;
	}

	//Search the recored by customer id & return customer object 
	public Customer search(long custID) throws SQLException  {
		// TODO Auto-generated method stub
		
		String selectQuery = "select customerId, firstName, lastName, emailId from Customer where customerId = ?";
		Customer custobj = new Customer();
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setLong(1, custID);
		ResultSet rset = stmt.executeQuery();
		
		while(rset.next()) {
			custobj.setCustomerId(rset.getLong(1));
			custobj.setFirstName(rset.getString(2));
			custobj.setLastName(rset.getString(3));
			custobj.setEmailId(rset.getString(4));
		}
		
		return custobj;
	}

	//Return all records list of customer object
	public List<Customer> display() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Display all recoreds using prepared Statements
		String selectQuery = "select * from Customer";
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		ResultSet rset = stmt.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		
		while(rset.next()) {
			Customer custobj = new Customer();
			custobj.setCustomerId(rset.getLong(1));
			custobj.setFirstName(rset.getString(2));
			custobj.setLastName(rset.getString(3));
			custobj.setEmailId(rset.getString(4));	
			custobj.setCountryName(rset.getString(8));
			customerList.add(custobj);
		}
		return customerList;
	}

	//Search the recored by customer firstname & return customer object
	public List<Customer> search(String firstname) throws SQLException {

		String selectQuery = "select customerId, firstName, lastName, emailId from Customer where firstName = ?";
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setString(1, firstname);
		ResultSet rset = stmt.executeQuery();
		
		List<Customer> lcust = new ArrayList<Customer>();
		
		while(rset.next()) {
			Customer custobj = new Customer();
			custobj.setCustomerId(rset.getLong(1));
			custobj.setFirstName(rset.getString(2));
			custobj.setLastName(rset.getString(3));
			custobj.setEmailId(rset.getString(4));
			lcust.add(custobj);
		}
		
		return lcust;
		
	}
	
	//Delete  record by comparing with custID
	public boolean deleteRecord(long custID) throws SQLException {
		// TODO Auto-generated method stub
		
		String deleteQuery = "delete from Customer where customerId = ?";
		PreparedStatement stmt = dbConn.prepareStatement(deleteQuery);	
		stmt.setLong(1, custID);
		boolean bln = stmt.execute();
		return bln;
	}
	
	//update recored 
	public boolean updateRecord(Customer custObj) throws SQLException {
		
		//update Customer set firstName = ? , cityName = ? , ... where customerId = ?
		String updateQuery = "update Customer set ";
		int index = 1;
		
		if(custObj.getFirstName() != "") {
			updateQuery = updateQuery + "firstName = ?, ";
		} 
		if(custObj.getLastName() != "") {
			updateQuery = updateQuery + "lastName = ?, ";
		}
		if(custObj.getEmailId() != "") {
			updateQuery = updateQuery + "emailId = ?, ";
		}
		if(custObj.getCityName() != "") {
			updateQuery = updateQuery + "cityName = ?, ";
		}
		if(custObj.getStateName() != "") {
			updateQuery = updateQuery + "stateName = ?, ";
		}
		if(custObj.getZip() != 0) {
			updateQuery = updateQuery + "stateName = ?, ";
		}
		if(custObj.getCountryName() != "") {
			updateQuery = updateQuery + "countryName = ?, ";
		}
		
		updateQuery = updateQuery.substring(0, updateQuery.length()-2) + " " + "where customerId = ?";
		System.out.println("UpdateQuery:  "+updateQuery);
		PreparedStatement stmt = dbConn.prepareStatement(updateQuery);	

		if(custObj.getFirstName() != "") {
			stmt.setString(index, custObj.getFirstName());
			index++;
		} 
		if(custObj.getLastName() != "") {
			stmt.setString(index, custObj.getLastName());
			index++;
		}
		if(custObj.getEmailId() != "") {
			stmt.setString(index, custObj.getEmailId());
			index++;
		}
		if(custObj.getCityName() != "") {
			stmt.setString(index, custObj.getCityName());
			index++;
		}
		if(custObj.getStateName() != "") {
			stmt.setString(index, custObj.getStateName());
			index++;
		}
		if(custObj.getZip() != 0) {
			stmt.setInt(index, custObj.getZip());
			index++;
		}
		if(custObj.getCountryName() != "") {
			stmt.setString(index, custObj.getCountryName());
			index++;
		}
		stmt.setLong(index, custObj.getCustomerId());
		
		boolean bln = stmt.execute();
		System.out.println("Return by excute: "+bln);
		return bln;
		
	}
}
