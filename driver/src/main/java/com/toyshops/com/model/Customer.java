package com.toyshops.com.model;
import com.toyshops.com.exceptions.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/***
 * 
 * 
 * @author Gopal.Pawar
 * 
 * Create table Customer (

	customerId int NOT NULL,
	firstName varchar (255) NOT NULL,
	lastName varchar(255) ,
	emailid varchar(255),
	Password varchar(255),
	cityName varchar(255),
	stateName varchar(255),
	Zip int,
	countryName varchar(255),
	PRIMARY KEY(customerId)
);

 *
 */



public class Customer {

	private String firstName;
	private String lastName;
	private String emailId;
	private long customerId;
	private String password;
	private String cityName;
	private String stateName;
	private int zip;
	private String countryName;
	
	static Pattern inputStrFormat = Pattern.compile("[^a-zA-Z]");
	
	
	public Customer() {
		this.firstName = "";	
		this.lastName = "";
		this.emailId = "";
		this.customerId = 0;
		this.password = "";
		this.cityName = "";
		this.stateName = "";
		this.zip = 0;
		this.countryName = "";
		
	}
	
	public Customer(String firstName, String lastName, String emailId, long customerId, String password,
			String cityName, String stateName, int zip, String countryName) throws Exception {
		super();
		
		
		Matcher matcher = inputStrFormat.matcher(firstName);
		
		if(matcher.find() || firstName.length() < 6) {
			throw new InvalidName("Invalid Name");
		}
		
		matcher = inputStrFormat.matcher(lastName);
		if(matcher.find() || firstName.length() < 6) {
			throw new InvalidName("Invalid Name");
		}
		
		this.firstName = firstName;	
		this.lastName = lastName;
		this.emailId = emailId;
		this.customerId = customerId;
		this.password = password;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zip = zip;
		this.countryName = countryName;
	}


	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		
		Matcher matcher = inputStrFormat.matcher(firstName);
		
		try {
			if(matcher.find() || firstName.length() > 6) {
				throw new InvalidName("Invalid firstName");
			}
		
			this.firstName = firstName;
		}
		catch (InvalidName excep) {
			System.out.println(excep.getMessage());
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		
		Matcher matcher = inputStrFormat.matcher(lastName);
		try {
			if(matcher.find() || firstName.length() > 6) {
				throw new InvalidName("Invalid lastName");
			}
			this.lastName = lastName;
		} catch (InvalidName excep) {
			System.out.println(excep.getMessage());
		}
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", customerId="
				+ customerId + ", countryName=" + countryName + "]";
	}
	
	
	
}
