package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelPageSecondResult;
import com.booking.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelPageSecondResultTest extends BaseTest{

    /**
     *@Test2 Steps 6 to 7 Booking final Exercise
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

        String secondHotelTitlehotels = hotelsPage.printSecondHotelTitle();
        String secondHotelScore = hotelsPage.printSecondHotelScore();
        String secondHotelPrice = hotelsPage.printSecondHotelPrice();

        getWindowManager().switchToTab(secondHotelTitlehotels);

        HotelPageSecondResult hotelPageSecondResult = new HotelPageSecondResult(myDriver.getDriver());
        hotelPageSecondResult.getTitleSecondResult2();
        String AdultsAndChilds = hotelPageSecondResult.getNumberOfAdultsAndChilds();
        hotelPageSecondResult.getTotalPrice();

        log.info("Verifications to check information from previous page done");
        Assert.assertEquals(hotelPageSecondResult.getTitleSecondResult(), secondHotelTitlehotels.split(" ")[0]);
        Assert.assertEquals(hotelPageSecondResult.getTotalPrice(), secondHotelPrice);
        Assert.assertTrue(AdultsAndChilds.contains("Recomendado para 3 adultos, 1 niño"));

        log.info("Verification that price is displayed");
        Assert.assertFalse(hotelPageSecondResult.getTotalPrice().isEmpty());

        hotelPageSecondResult.clickBooking();
        hotelPageSecondResult.clickConfirmBooking();
        hotelPageSecondResult.selectFromDropDown("1");
        hotelPageSecondResult.getSelectedOptions();
        hotelPageSecondResult.clickConfirmBooking();
    }
}
