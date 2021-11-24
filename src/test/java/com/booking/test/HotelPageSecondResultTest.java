package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelPageSecondResult;
import com.booking.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelPageSecondResultTest extends BaseTest{

    /**
     *@Test3 Steps 6 to 7 Booking final Exercise
     *
     *
     *@autor Alejandro Madrid
     */

    @Test
    public void checkHotelSelection(){

        BookingHomePage bookingHome = getBookingHomePage();
        bookingHome.clickStays();
        bookingHome.fillSearchCity("Bogota, Colombia");
        bookingHome.clickCheckInData();
        bookingHome.visibilityOfCalendar();
        bookingHome.setCheckInDate("30","diciembre","2021");
        bookingHome.setCheckOutDate("14", "enero","2022");
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

        String secondHotelTitlehotels = hotelsPage.printSecondHotelTitleSecondWord();
        String secondHotelPrice = hotelsPage.printSecondHotelPrice();

        getWindowManager().switchToTab(secondHotelTitlehotels);

        HotelPageSecondResult hotelPageSecondResult = new HotelPageSecondResult(myDriver.getDriver());
        String AdultsAndChilds = hotelPageSecondResult.getNumberOfAdultsAndChilds();
        hotelPageSecondResult.getTotalPrice();

        log.info("verify total price for reservation dates (check-in and check-out) is displayed");
        Assert.assertFalse(hotelPageSecondResult.getTotalPrice().isEmpty());

        log.info("Verify total price is the same as the previous page");
        Assert.assertEquals(hotelPageSecondResult.getTotalPrice(), secondHotelPrice);

        log.info("Verify number of adults and childs is the same as the previous page");
        Assert.assertTrue(AdultsAndChilds.contains("Recomendado para 3 adultos, 1 niño"));

        log.info("Verify booking hotel’s name is the same as the previous page");
        Assert.assertEquals(hotelPageSecondResult.getTitleSecondResult(), secondHotelTitlehotels);

        hotelPageSecondResult.clickBooking();
        hotelPageSecondResult.clickConfirmBooking();
        hotelPageSecondResult.selectFromDropDown("1");
        hotelPageSecondResult.getSelectedOptions();
        hotelPageSecondResult.clickConfirmBooking();

    }
}
