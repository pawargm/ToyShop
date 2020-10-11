package com.toyshops.com.model;

public class MuscialToy extends Toy {

	private int noOfSpeakers;
	
	public MuscialToy(long toyId, float price, String toyName, String toyType, int minAge, int maxAge, int quantity,
			float rentalAmount, int noOfSpeakers) throws Exception {
		super(toyId, price, toyName, toyType, minAge, maxAge, quantity, rentalAmount);
		// TODO Auto-generated constructor stub
		this.noOfSpeakers = noOfSpeakers;
	}

	public int getNoOfSpeakers() {
		return noOfSpeakers;
	}

	public void setNoOfSpeakers(int noOfSpeakers) {
		this.noOfSpeakers = noOfSpeakers;
	}
	

}
