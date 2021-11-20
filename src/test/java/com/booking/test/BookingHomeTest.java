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
        bookingHome.clickCheckInData();
        bookingHome.visibilityOfCalendar();
        bookingHome.getCheckInMonthAndYear(); //String MonthAndYear = bookingHome.getCheckInMonthAndYear();
        System.out.println(bookingHome.getCheckInMonthAndYear());
        bookingHome.getCheckInMonth();
        System.out.println(bookingHome.getCheckInMonth());
        bookingHome.getCheckInYear();
        System.out.println(bookingHome.getCheckInYear());
        while(!(bookingHome.getCheckInMonth().equals("junio") && bookingHome.getCheckInYear().equals("2022"))){
            bookingHome.clickNextMonth();
            bookingHome.getCheckInMonthAndYear();

            System.out.println(bookingHome.getCheckInMonthAndYear());
            bookingHome.getCheckInMonth();
            System.out.println(bookingHome.getCheckInMonth());
            bookingHome.getCheckInYear();
            System.out.println(bookingHome.getCheckInYear());

        }
//        bookingHome.lookForFuture();

        bookingHome.clickCalendarInDay();
        bookingHome.clickCalendarOutDay();
        bookingHome.clickGuests();
        bookingHome.clickAddAdults();
        bookingHome.clickAddKids();
        bookingHome.clickAgeKid();

    }

}
