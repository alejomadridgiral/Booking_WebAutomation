package com.booking.test;

import com.booking.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteReservationDataTest extends BaseTest{

    @Test
    public void checkConfirmReservationData(){
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

        String secondHotelTitlehotels = hotelsPage.printSecondHotelTitle();

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
        reservationData.fillLastname("Madrid");
        reservationData.fillEmail("amadrid@yahoo.com");
        reservationData.fillEmail_confirm("amadrid@yahoo.com");
        reservationData.clickLastDataButton();

        CompleteReservationData completeReservationData = new CompleteReservationData(myDriver.getDriver());
        completeReservationData.fillPhone("318 345 36 35");
        completeReservationData.selectFromDropDown("MasterCard");
        completeReservationData.getSelectedOptions();
        completeReservationData.fillCcNumber("5169 8895 8552 0008");
        completeReservationData.fillCcCvc("145");
        String savedName = completeReservationData.getAutomaticName();
        Assert.assertTrue(savedName.contains("Alejo Madrid"));
        String savedEmail = completeReservationData.getAutomaticEmail();
        Assert.assertTrue(savedEmail.contains("amadrid@yahoo.com"));
        Assert.assertEquals(completeReservationData.getFinalHotelTitle(), secondHotelTitlehotels);

    }

}
