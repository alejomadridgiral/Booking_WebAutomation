package com.booking.test;

import com.booking.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteReservationDataTest extends BaseTest{

    /**
     *@Test4 Steps 8 to 9. Complete the last data information form and choose 5 page validations to
     * perform.
     *
     *
     *@autor Alejandro Madrid
     */


    @Test
    public void checkConfirmReservationData(){
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
        bookingHome.selectFromDropDown("9 años");
        bookingHome.getSelectedOptions();

        HotelsPage hotelsPage = bookingHome.clickSearch();
        hotelsPage.clickFiveStars();
        hotelsPage.runHotelsTitle();
        hotelsPage.runHotelsScore();
        hotelsPage.runHotelsPrice();
        hotelsPage.clickSecondHotel();

        String secondHotelTitlehotels = hotelsPage.printSecondHotelTitle();
        String secondHotelPrice = hotelsPage.printSecondHotelPrice();
        String secondHotelScore = hotelsPage.printSecondHotelScore();

        getWindowManager().switchToTab(hotelsPage.printSecondHotelTitle());

        HotelPageSecondResult hotelPageSecondResult = new HotelPageSecondResult(myDriver.getDriver());
        hotelPageSecondResult.getTitleSecondResult();
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

        log.info("Validation for hotel title is the same from second page to booking page");
        Assert.assertEquals(completeReservationData.getFinalHotelTitle(), secondHotelTitlehotels);

        log.info("Validation for Adults, childs an age is according to selection");
        String AdultsAndChildsFinal = completeReservationData.getNumberOfAdultsAndChildsFinal();
        Assert.assertTrue(AdultsAndChildsFinal.contains("3 adultos, 1 niño (9 años)"));

        log.info("Validation for hotel score is the same from second page to booking page");
        Assert.assertEquals(completeReservationData.getScoreFinal(), secondHotelScore);

        log.info("Validation that the name entered was recorder correctly");
        String savedName = completeReservationData.getAutomaticName();
        Assert.assertTrue(savedName.contains("Alejo Madrid"));

        log.info("Validation that the email entered was recorder correctly");
        String savedEmail = completeReservationData.getAutomaticEmail();
        Assert.assertTrue(savedEmail.contains("amadrid@yahoo.com"));

        log.info("Validation for hotel price is the same from second page to booking page");
        Assert.assertEquals(completeReservationData.getTotalPriceFinal(), secondHotelPrice);

    }

}
