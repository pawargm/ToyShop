package com.toyshops.com.driver;
import java.sql.Date;
import java.sql.SQLException;

import com.toyshops.com.service.*;
import com.toyshops.com.model.*;


public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        
        
        //customerId, firstName , lastName; emailId; password; cityName; stateName
        //toyId, toyName, toyType, price, minAge, maxAge, quantity, rentalAmount
        
       // ToyServiceImpl toyservice = new ToyServiceImpl();
        //Toy toyobj = new Toy();
        
        //toyobj.setToyId(3);
        //toyobj.setToyName("Car");
        //toyobj.setToyType("Mini-Vichle");
        //toyobj.setPrice(254.98f);
        //toyobj.setMinAge(6);
        //toyobj.setMaxAge(12);
        //toyobj.setQuantity(250);
        //toyobj.setRentalAmount(24.0f);
        
        //toyservice.insert(toyobj);
        //toyservice.updateRecord(toyobj);
        ToyRentalService toyrental = new ToyRentalService();
        RentalToy rentalObj = new RentalToy();
        //rentalId, customerId, toyId, startDate, endDate, rentalAmtPerDay, totalAmount, fineRupees, status
       // rentalObj.setRentalId(2);
        //rentalObj.setCustomerId(2);
        //rentalObj.setToyId(3);
        
        //Date date = Date.valueOf("2020-10-11");
        
        //rentalObj.setStartDate(date);
        //rentalObj.setEndDate(Date.valueOf("2020-10-23"));
        
        //rentalObj.setRentalAmtPerDay(4.5f);
        //rentalObj.setTotalAmount(145f);
        //rentalObj.setFineRupees(2f);
        //rentalObj.setStatus("AVL");
        
        //toyrental.insert(rentalObj);
        //toyrental.updateRecord(rentalObj);
        
        toyrental.bookToy(3, "BOOKED");
        
        
        
    }
}
