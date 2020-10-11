package com.toyshops.com.model;
import java.util.*;
import java.sql.Date;

/***
 * 
 * @author Gopal.Pawar
 * 
 * Create table RentalToy (

	rentalId int PRIMARY KEY,
	customerId int NOT NULL,
	toyId int NOT NULL,
	startDate date ,
	endDate date,
	rentalAmtPerDay int,
	totalAmount int,
	fineRupees int,
	status varchar(10),
	
	CONSTRAINT customer_id_fk
    FOREIGN KEY (customerId)
    REFERENCES customer (customerId)
    ON DELETE CASCADE,
	
	CONSTRAINT toy_id_fk
    FOREIGN KEY (toyId)
    REFERENCES toy (toyId)
    ON DELETE CASCADE
);

*
*/


public class RentalToy 
{
	//rentalID is primary key
	private long rentalId;
	//customerID is foreign key
	private long customerId;
	//toyID is foreign key 
	private long toyId;
	private Date startDate;
	private Date endDate;
	private float rentalAmtPerDay;
	private float totalAmount;
	private float fineRupees;
	//status should have value like AVL or BOOKED
	private String status;
	
	public RentalToy(long rentalId, long customerId, long toyId, Date startDate, Date endDate,
			float rentalAmtPerDay, float totalAmount, float fineRupees, String status) {
		super();
		this.rentalId = rentalId;
		this.customerId = customerId;
		this.toyId = toyId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentalAmtPerDay = rentalAmtPerDay;
		this.totalAmount = totalAmount;
		this.fineRupees = fineRupees;
		this.status = status;
	}
	public RentalToy() {
		// TODO Auto-generated constructor stub
		this.rentalId = 0;
		this.customerId = 0;
		this.toyId = 0;
		this.startDate = null;
		this.endDate = null;
		this.rentalAmtPerDay = 0;
		this.totalAmount = 0;
		this.fineRupees = 0;
		this.status = "";
	}
	public long getRentalId() {
		return rentalId;
	}
	public void setRentalId(long rentalId) {
		this.rentalId = rentalId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public float getRentalAmtPerDay() {
		return rentalAmtPerDay;
	}
	public void setRentalAmtPerDay(float rentalAmtPerDay) {
		this.rentalAmtPerDay = rentalAmtPerDay;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public float getFineRupees() {
		return fineRupees;
	}
	public void setFineRupees(float fineRupees) {
		this.fineRupees = fineRupees;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getToyId() {
		return toyId;
	}
	public void setToyId(long toyId) {
		this.toyId = toyId;
	}
	@Override
	public String toString() {
		return "RentalToy [rentalId=" + rentalId + ", customerId=" + customerId + ", toyId=" + toyId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", rentalAmtPerDay=" + rentalAmtPerDay + ", totalAmount="
				+ totalAmount + ", fineRupees=" + fineRupees + ", status=" + status + "]";
	}
	
	
}
