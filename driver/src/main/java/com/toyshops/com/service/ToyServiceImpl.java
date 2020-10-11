package com.toyshops.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toyshops.com.model.Toy;

public class ToyServiceImpl implements ToyService {

	static Toy [] ToyArray ;
	static Connection dbConn;
	
	public ToyServiceImpl() throws ClassNotFoundException, SQLException {
		dbConn = DAO.getConnection();
	}
	
	
	public boolean insert(Toy toyobj) throws SQLException {
		// TODO Auto-generated method stub
		String insertQuery = "insert into Toy(toyId, toyName, toyType, price, minAge, maxAge, quantity, rentalAmount) values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = dbConn.prepareStatement(insertQuery);
		
		stmt.setLong(1, toyobj.getToyId());
		stmt.setString(2, toyobj.getToyName());
		stmt.setString(3, toyobj.getToyType());
		stmt.setFloat(4, toyobj.getPrice());
		stmt.setInt(5, toyobj.getMinAge());
		stmt.setInt(6, toyobj.getMaxAge());
		stmt.setInt(7, toyobj.getQuantity());
		stmt.setFloat(8, toyobj.getRentalAmount());
		
		boolean bln = stmt.execute();
		return bln;
	}

	public Toy search(long toyID) throws SQLException {
		// TODO Auto-generated method stub
		
		//toyId, toyName, toyType, price, minAge, maxAge, quantity, rentalAmount
		
		String selectQuery = "select * from toy where toyId = ?";
		Toy toyobj = new Toy();
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setLong(1, toyID);
		ResultSet rset = stmt.executeQuery();
		
		while(rset.next()) {
			toyobj.setToyId(rset.getLong(1));
			toyobj.setToyName(rset.getString(2));
			toyobj.setToyType(rset.getString(3));
			toyobj.setPrice(rset.getFloat(4));
			toyobj.setMinAge(rset.getInt(5));
			toyobj.setMaxAge(rset.getInt(6));
			toyobj.setQuantity(rset.getInt(7));
			toyobj.setRentalAmount(rset.getFloat(8));
		}

		
		return toyobj;
	}

	public List<Toy> display() throws SQLException {

		String selectQuery = "select * from toy";
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		ResultSet rset = stmt.executeQuery();
		List<Toy> lstToy = new ArrayList<Toy>();
		
		while(rset.next()) {
			
			Toy toyobj = new Toy();
			toyobj.setToyId(rset.getLong(1));
			toyobj.setToyName(rset.getString(2));
			toyobj.setToyType(rset.getString(3));
			toyobj.setPrice(rset.getFloat(4));
			toyobj.setMinAge(rset.getInt(5));
			toyobj.setMaxAge(rset.getInt(6));
			toyobj.setQuantity(rset.getInt(7));
			toyobj.setRentalAmount(rset.getFloat(8));
			lstToy.add(toyobj);
		}
		return lstToy;
	}
	
	public List<Toy> search(String toyName) throws SQLException {
	
		String selectQuery = "select * from toy where toyName = ?";
		
		PreparedStatement stmt = dbConn.prepareStatement(selectQuery);
		stmt.setString(1, toyName);
		ResultSet rset = stmt.executeQuery();
		List<Toy> lstToy = new ArrayList<Toy>();
		
		while(rset.next()) {
			
			Toy toyobj = new Toy();
			toyobj.setToyId(rset.getLong(1));
			toyobj.setToyName(rset.getString(2));
			toyobj.setToyType(rset.getString(3));
			toyobj.setPrice(rset.getFloat(4));
			toyobj.setMinAge(rset.getInt(5));
			toyobj.setMaxAge(rset.getInt(6));
			toyobj.setQuantity(rset.getInt(7));
			toyobj.setRentalAmount(rset.getFloat(8));
			lstToy.add(toyobj);
		}
		return lstToy;
	}

	public boolean deleteRecord(long toyId) throws SQLException {
		// TODO Auto-generated method stub
		String deleteQuery = "delete from toy where toyId = ?";
		PreparedStatement stmt = dbConn.prepareStatement(deleteQuery);	
		stmt.setLong(1, toyId);
		boolean bln = stmt.execute();
		return bln;

	}

	public boolean updateRecord(Toy toyObj) throws SQLException {
		// TODO Auto-generated method stub
		
		//update toy set toyName = ? , toyType = ? , ... where  toyId = ?
		//toyId, toyName, toyType, price, minAge, maxAge, quantity, rentalAmount
		
		String updateQuery = "update toy set ";
		int index = 1;
		
		if(toyObj.getToyName() != "") {
			updateQuery = updateQuery + "toyName = ?, ";
		} 
		if(toyObj.getToyType() != "") {
			updateQuery = updateQuery + "toyType = ?, ";
		}
		if(toyObj.getPrice() != 0) {
			updateQuery = updateQuery + "price = ?, ";
		}
		if(toyObj.getMinAge() != 0) {
			updateQuery = updateQuery + "minAge = ?, ";
		}
		if(toyObj.getMaxAge() != 0) {
			updateQuery = updateQuery + "maxAge = ?, ";
		}
		if(toyObj.getQuantity() != 0) {
			updateQuery = updateQuery + "quantity = ?, ";
		}
		if(toyObj.getRentalAmount() != 0) {
			updateQuery = updateQuery + "rentalAmount = ?, ";
		}
		
		updateQuery = updateQuery.substring(0, updateQuery.length()-2) + " " + "where toyId = ?";
		System.out.println("UpdateQuery:  "+updateQuery);
		PreparedStatement stmt = dbConn.prepareStatement(updateQuery);	
		
		if(toyObj.getToyName() != "") {
			stmt.setString(index, toyObj.getToyName());
			index++;
		} 
		if(toyObj.getToyType() != "") {
			stmt.setString(index, toyObj.getToyType());
			index++;
		}
		if(toyObj.getPrice() != 0) {
			stmt.setFloat(index, toyObj.getPrice());
			index++;
		}
		if(toyObj.getMinAge() != 0) {
			stmt.setInt(index, toyObj.getMinAge());
			index++;
		}
		if(toyObj.getMaxAge() != 0) {
			stmt.setInt(index, toyObj.getMaxAge());
			index++;
		}
		if(toyObj.getQuantity() != 0) {
			stmt.setInt(index, toyObj.getQuantity());
			index++;
		}
		if(toyObj.getRentalAmount() != 0) {
			stmt.setFloat(index, toyObj.getRentalAmount());
			index++;
		}
		
		
		stmt.setLong(index, toyObj.getToyId());
		
		boolean bln = stmt.execute();
		System.out.println("Return by excute: "+bln);
		return bln;

	}

}
