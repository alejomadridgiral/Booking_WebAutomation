package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelsTest extends BaseTest{

    /**
     *@Test1 Steps 1 to 5 Booking final Exercise
     *
     *
     *@autor Alejandro Madrid
     */

    @Test
    public void hotelSelection(){
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
        String option = "9 años";
        bookingHome.selectFromDropDown(option);
        bookingHome.getSelectedOptions();
        HotelsPage hotelsPage = bookingHome.clickSearch();
        hotelsPage.clickFiveStars();
        hotelsPage.runHotelsTitle();
        hotelsPage.runHotelsScore();
        hotelsPage.runHotelsPrice();

        log.info("Validations for Step 5, were for each of the elements to verify(title, score and price) the size is" +
                "checked in order to verify that all the elements are on the runned list");
        Assert.assertEquals(hotelsPage.runHotelsTitle().size(),hotelsPage.runHotelsScore().size());
        Assert.assertEquals(hotelsPage.runHotelsScore().size(),hotelsPage.runHotelsTitle().size());
        Assert.assertEquals(hotelsPage.runHotelsPrice().size(),hotelsPage.runHotelsTitle().size());

        hotelsPage.clickSecondHotel();
        getWindowManager().switchToTab(hotelsPage.printSecondHotelTitle());
    }

}
