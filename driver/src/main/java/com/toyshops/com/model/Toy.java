package com.toyshops.com.model;
import com.toyshops.com.exceptions.*;

/***
 * 
 * @author Gopal.Pawar
 * 
Create table Toy (

	toyId int NOT NULL,
	toyName varchar (255) NOT NULL,
	toyType varchar(255) ,
	Price float,
	minAge int,
	maxAge int,
	quantity int,
	rentalAmount float,
	PRIMARY KEY(toyId)
);
 *
 */


public class Toy {

	private long toyId;
	private float price;
	private String toyName;
	private String toyType;
	private int minAge;
	private int maxAge;
	private int quantity;
	private float rentalAmount;
	
	public Toy(long toyId, float price, String toyName, String toyType, int minAge, int maxAge, int quantity,
			float rentalAmount) throws Exception {
		super();
		
		if(minAge < 0 || minAge > 12) {
			throw new InvalidAge("Invalid minAge");
		}
		if(maxAge > 12 || maxAge < 0 ) {
			throw new InvalidAge("Invalid maxAge");
		}
		
		this.toyId = toyId;
		this.price = price;
		this.toyName = toyName;
		this.toyType = toyType;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.quantity = quantity;
		this.rentalAmount = rentalAmount;
	}
	
	public Toy() {
		// TODO Auto-generated constructor stub
		this.toyId = 0;
		this.price = 0;
		this.toyName = "";
		this.toyType = "";
		this.minAge = 0;
		this.maxAge = 0;
		this.quantity = 0;
		this.rentalAmount = 0;		
		
	}

	public long getToyId() {
		return toyId;
	}
	public void setToyId(long toyId) {
		this.toyId = toyId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getToyType() {
		return toyType;
	}
	public void setToyType(String toyType) {
		this.toyType = toyType;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		
		try {
			if(minAge < 0 || minAge > 12) {
				throw new InvalidAge("Invalid minAge");
			}
			this.minAge = minAge;
		} catch(InvalidAge excep) {
			System.out.println(excep.getMessage());
		}
		
		
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		
		try {
			if(maxAge < 0 || maxAge > 12) {
				throw new InvalidAge("Invalid maxAge");
			}
			this.maxAge = maxAge;
		} catch (InvalidAge excep) {
			System.out.println(excep.getMessage());
		}
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getRentalAmount() {
		return rentalAmount;
	}
	public void setRentalAmount(float rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", price=" + price + ", toyName=" + toyName + ", toyType=" + toyType
				+ ", minAge=" + minAge + ", maxAge=" + maxAge + ", quantity=" + quantity + ", rentalAmount="
				+ rentalAmount + "]";
	}

	
	
	
}
