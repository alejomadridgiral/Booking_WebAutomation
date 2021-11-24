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
//        bookingHome.getCheckInMonthAndYear();
//        bookingHome.getCheckInMonth();
//        bookingHome.getCheckInYear();
        bookingHome.lookForFutureMonth("30","diciembre","2021");
//        bookingHome.clickCalendarInDay();
        bookingHome.clickCalendarOutDay();
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
