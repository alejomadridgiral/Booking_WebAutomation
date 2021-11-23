package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelPageSecondResult;
import com.booking.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelPageSecondResultTest extends BaseTest{

    @Test
    public void checkHotelSelection(){

        BookingHomePage bookingHome = getBookingHomePage();
        bookingHome.clickStays();
        bookingHome.fillSearchCity("Bogota, Colombia");
        bookingHome.clickCheckInData();
        bookingHome.visibilityOfCalendar();
        bookingHome.getCheckInMonthAndYear();
        System.out.println(bookingHome.getCheckInMonthAndYear());
        bookingHome.getCheckInMonth();
        System.out.println(bookingHome.getCheckInMonth());
        bookingHome.getCheckInYear();
        System.out.println(bookingHome.getCheckInYear());
        while(!(bookingHome.getCheckInMonth().equals("diciembre") && bookingHome.getCheckInYear().equals("2021"))){
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
        bookingHome.selectFromDropDown("9 años");
        bookingHome.getSelectedOptions();

        HotelsPage hotelsPage = bookingHome.clickSearch();
        hotelsPage.clickFiveStars();
        hotelsPage.runHotelsTitle();
        hotelsPage.runHotelsScore();
        hotelsPage.runHotelsPrice();
        hotelsPage.clickSecondHotel();

        getWindowManager().switchToTab(hotelsPage.printSecondHotelTitle());

        HotelPageSecondResult hotelPageSecondResult = new HotelPageSecondResult(myDriver.getDriver());
        hotelPageSecondResult.getTitleSecondResult();
        hotelPageSecondResult.getNumberOfAdultsAndChilds();
        hotelPageSecondResult.getTotalPrice();
//        Assert.assertEquals(hotelPageSecondResult.getTitleSecondResult(),hotelsPage.printSecondHotelTitle());
        hotelPageSecondResult.clickBooking();
        hotelPageSecondResult.clickConfirmBooking();
        hotelPageSecondResult.selectFromDropDown("1");
        hotelPageSecondResult.getSelectedOptions();
        hotelPageSecondResult.clickConfirmBooking();
    }
}
