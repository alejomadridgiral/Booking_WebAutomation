package com.booking.test;

import com.booking.Data.Data;
import com.booking.pages.BookingHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookingHomeTest extends BaseTest{

    /**
     *@Test1 Steps 1 to 4 Booking final Exercise
     *
     *
     *@autor Alejandro Madrid
     */


    @Test
    public void datesSelection(){
        BookingHomePage bookingHome = getBookingHomePage();
        bookingHome.clickStays();
        bookingHome.fillSearchCity("Bogota, Colombia");
        bookingHome.clickCheckInData();
        bookingHome.visibilityOfCalendar();
        String dayIn = bookingHome.automaticDayCheckIn();
        String monthIn = bookingHome.automaticMonthCheckIn();
        String yearIn = bookingHome.automaticYearInCheckIn();
        bookingHome.setCheckInDate(dayIn,monthIn,yearIn);
        String dayOut = bookingHome.automaticDayCheckOut();
        String monthOut = bookingHome.automaticMonthCheckOut();
        String yearOut = bookingHome.automaticYearInCheckOut();
        bookingHome.setCheckOutDate(dayOut, monthOut,yearOut);
        bookingHome.clickGuests();
        bookingHome.clickAddAdults();
        bookingHome.clickAddKids();
        String option = "9 años";
        bookingHome.selectFromDropDown(option);
        bookingHome.getSelectedOptions();

        log.info("Verification that the dropdown selection is working correctly done");
        Assert.assertEquals(bookingHome.getSelectedOptions().size(), 1, "Incorrect number of selections");
        Assert.assertTrue(bookingHome.getSelectedOptions().contains(option), "Option not Selected");

        bookingHome.clickSearch();

    }
}
