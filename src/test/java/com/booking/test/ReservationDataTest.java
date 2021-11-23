package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelPageSecondResult;
import com.booking.pages.HotelsPage;
import com.booking.pages.ReservationData;
import org.testng.annotations.Test;

public class ReservationDataTest extends BaseTest{

    @Test
    public void checkReservationData(){
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
        hotelPageSecondResult.clickBooking();
        hotelPageSecondResult.clickConfirmBooking();
        hotelPageSecondResult.selectFromDropDown("1");
        hotelPageSecondResult.getSelectedOptions();
        hotelPageSecondResult.clickConfirmBooking();

        ReservationData reservationData = new ReservationData(myDriver.getDriver());
        reservationData.fillFirstname("Alejo");

    }
}
