package com.toyshops.com.model;

public class ElectronicToy extends Toy {

	private int numberOfBatteries;
	private String operatingMode;
	
	public ElectronicToy(long toyId, float price, String toyName, String toyType, int minAge, int maxAge, int quantity,
			float rentalAmount, int numberOfBatteries, String operatingMode) throws Exception {
		super(toyId, price, toyName, toyType, minAge, maxAge, quantity, rentalAmount);
		// TODO Auto-generated constructor stub
		this.numberOfBatteries = numberOfBatteries;
		this.operatingMode = operatingMode;
	}

	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}

	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}

	public String getOperatingMode() {
		return operatingMode;
	}

	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}
	
	
	
	
}
