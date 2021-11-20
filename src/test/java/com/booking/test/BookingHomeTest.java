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
//        System.out.println(MonthAndYear);
//        String month = bookingHome.getCheckInMonth();
//        System.out.println(month);
//        String year = bookingHome.getCheckInYear();
//        System.out.println(year);
//        while(!(month.equals("June") && year.equals("2022"))){
//            MonthAndYear = bookingHome.getCheckInMonthAndYear();
//            bookingHome.clickNextMonth();
//            month = bookingHome.getCheckInMonth();
//            year = bookingHome.getCheckInYear();
//        }
////        bookingHome.lookForFuture();
        bookingHome.clickCalendarDay();
    }

}
