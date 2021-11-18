package com.booking.test;

import com.booking.Data.Data;
import com.booking.pages.BookingHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookingHomeTest extends BaseTest{

    @Test
    public void datesSelection(){
        BookingHomePage bookingHome = getBookingHomePage();
        bookingHome.clickStays();
        bookingHome.fillSearchCity("Bogota, Colombia");

    }


}
