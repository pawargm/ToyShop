package com.toyshops.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toyshops.com.model.Customer;
import com.toyshops.com.model.RentalToy;
import com.toyshops.com.model.Toy;

public class ToyRentalService {

	static Connection dbConn;
	
	//rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status .
	public ToyRentalService() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		dbConn = DAO.getConnection();
	}
	
	public boolean insert(RentalToy toyobj) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "insert into RentalToy(rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = dbConn.prepareStatement(insertQuery);
		
		stmt.setLong(1, toyobj.getRentalId());
		stmt.setLong(3, toyobj.getToyId());
		stmt.setLong(2, toyobj.getCustomerId());
		stmt.setDate(4, toyobj.getStartDate());
		stmt.setDate(5, toyobj.getEndDate());
		stmt.setFloat(6, toyobj.getRentalAmtPerDay());
		stmt.setFloat(7, toyobj.getTotalAmount());
		stmt.setFloat(8, toyobj.getFineRupees());
		stmt.setString(9, toyobj.getStatus());
		
		boolean bln = stmt.execute();
		return bln;
	}

	public RentalToy search(long rentalId) throws SQLException {
		// TODO Auto-generated method stub
		
		//rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status
		
		String selectQuery = "select * from RentalToy where rentalId = ?";
		RentalToy toyobj = new RentalToy();
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setLong(1, rentalId);
		ResultSet rset = stmt.executeQuery();
		
		while(rset.next()) {
			toyobj.setRentalId(rset.getLong(1));
			toyobj.setCustomerId(rset.getLong(2));
			toyobj.setToyId(rset.getLong(3));
			toyobj.setStartDate(rset.getDate(4));
			toyobj.setEndDate(rset.getDate(5));
			toyobj.setRentalAmtPerDay(rset.getFloat(6));
			toyobj.setTotalAmount(rset.getFloat(7));
			toyobj.setFineRupees(rset.getFloat(8));
			toyobj.setStatus(rset.getString(9));
		}
		return toyobj;
	}

	public List<RentalToy> display() throws SQLException {

		String selectQuery = "select * from rentaltoy";
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		ResultSet rset = stmt.executeQuery();
		List<RentalToy> lstToy = new ArrayList<RentalToy>();
		
		while(rset.next()) {
			
			RentalToy toyobj = new RentalToy();

			toyobj.setRentalId(rset.getLong(1));
			toyobj.setCustomerId(rset.getLong(2));
			toyobj.setToyId(rset.getLong(3));
			toyobj.setStartDate(rset.getDate(4));
			toyobj.setEndDate(rset.getDate(5));
			toyobj.setRentalAmtPerDay(rset.getFloat(6));
			toyobj.setTotalAmount(rset.getFloat(7));
			toyobj.setFineRupees(rset.getFloat(8));
			toyobj.setStatus(rset.getString(9));

			lstToy.add(toyobj);
		}
		return lstToy;
	}
	

	public boolean deleteRecord(long rentaltoyId) throws SQLException {
		// TODO Auto-generated method stub
		String deleteQuery = "delete from rentaltoy where rentalId = ?";
		PreparedStatement stmt = dbConn.prepareStatement(deleteQuery);	
		stmt.setLong(1, rentaltoyId);
		boolean bln = stmt.execute();
		return bln;

	}

	public boolean updateRecord(RentalToy toyObj) throws SQLException {
		// TODO Auto-generated method stub
		
		//update toy set toyName = ? , toyType = ? , ... where  toyId = ?
		//rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status
		
		String updateQuery = "update rentaltoy set ";
		int index = 1;
		
		
		if(toyObj.getCustomerId() != 0) {
			updateQuery = updateQuery + "customerId = ?, ";
		}
		if(toyObj.getToyId() != 0) {
			updateQuery = updateQuery + "toyId = ?, ";
		}
		if(toyObj.getStartDate() != null) {
			updateQuery = updateQuery + "startDate = ?, ";
		}
		if(toyObj.getEndDate() != null) {
			updateQuery = updateQuery + "endDate = ?, ";
		}
		if(toyObj.getRentalAmtPerDay() != 0) {
			updateQuery = updateQuery + "rentalAmtPerDay = ?, ";
		}
		if(toyObj.getTotalAmount() != 0) {
			updateQuery = updateQuery + "totalAmount = ?, ";
		}
		if(toyObj.getFineRupees() != 0) {
			updateQuery = updateQuery + "fineRupees = ?, ";
		}
		if(toyObj.getStatus() != "") {
			updateQuery = updateQuery + "status = ?, ";
		}
		updateQuery = updateQuery.substring(0, updateQuery.length()-2) + " " + "where rentalId = ?";
		System.out.println("UpdateQuery:  "+updateQuery);
		PreparedStatement stmt = dbConn.prepareStatement(updateQuery);	
		

		if(toyObj.getCustomerId() != 0) {
			stmt.setLong(index, toyObj.getCustomerId());
			index++;
		}
		if(toyObj.getToyId() != 0) {
			stmt.setLong(index, toyObj.getToyId());
			index++;
		}
		if(toyObj.getStartDate() != null) {
			stmt.setDate(index, toyObj.getStartDate());
			index++;
		}
		if(toyObj.getEndDate() != null) {
			stmt.setDate(index, toyObj.getEndDate());
			index++;
		}
		if(toyObj.getRentalAmtPerDay() != 0) {
			stmt.setFloat(index, toyObj.getRentalAmtPerDay());
			index++;
		}
		if(toyObj.getTotalAmount() != 0) {
			stmt.setFloat(index, toyObj.getTotalAmount());
			index++;
		}
		if(toyObj.getFineRupees() != 0) {
			stmt.setFloat(index, toyObj.getFineRupees());
			index++;
		}
		if(toyObj.getStatus() != "") {
			stmt.setString(index, toyObj.getStatus());
			index++;
		}
	
		stmt.setLong(index, toyObj.getRentalId());
		boolean bln = stmt.execute();
		System.out.println("Return by excute: "+bln);
		return bln;

	}

	public Toy toyRentDetails(long toyId) throws ClassNotFoundException, SQLException  {
		
		ToyServiceImpl toyservice = new ToyServiceImpl();
		Toy toyObj = toyservice.search(toyId);
		return toyObj;
	}

	public Customer getRentalDetails(long customerId) throws ClassNotFoundException, SQLException {
		CustomerService custService = new CustomerServiceImpl();
		Customer custObj = custService.search(customerId);
		return custObj;
	}
	
	public float getTotalRentAmount(long rentalId) throws SQLException {
		
		RentalToy rentObj = search(rentalId);
		
		return rentObj.getRentalAmtPerDay() * 30;
		
	}
	
	
	public List<RentalToy> searchByToyId(long toyId) throws SQLException {
		// TODO Auto-generated method stub
		
		//rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status
		
		String selectQuery = "select rentalId from RentalToy where toyId = ?";
		
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setLong(1, toyId);
		ResultSet rset = stmt.executeQuery();
		
		List<RentalToy> lstRentalToy = new ArrayList<RentalToy>();
		
		while(rset.next()) {
			RentalToy toyobj = new RentalToy();
			toyobj.setRentalId(rset.getLong(1));
			lstRentalToy.add(toyobj);
		}
		return lstRentalToy;
	}

	
	
	public boolean bookToy(long toyId, String status) throws SQLException {
	
		
		List<RentalToy> lstRentalToy = searchByToyId(toyId);
		boolean res = false;
		for(RentalToy tmpobj: lstRentalToy) {
			tmpobj.setStatus(status);
			res = res || updateRecord(tmpobj);
		}
		return res;
	} 
	
	public Toy returnToy(long toyId) throws ClassNotFoundException, SQLException {
		return toyRentDetails(toyId);
	}
	
	
}
