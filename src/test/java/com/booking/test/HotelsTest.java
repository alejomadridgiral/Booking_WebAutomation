package com.booking.test;

import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelsTest extends BaseTest{

    /**
     *@Test2 Step5 Booking final Exercise
     *
     * Filter search results by 5 starts. Select the second result after filtering. Verify for
     * every booking option this elements before moving to next page:
     * a. Booking hotel’s title.
     * b. Booking review score.
     * c. Booking reservation price.
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
        HotelsPage hotelsPage = bookingHome.clickSearch();
        hotelsPage.clickFiveStars();
        hotelsPage.runHotelsTitle();
        hotelsPage.runHotelsScore();
        hotelsPage.runHotelsPrice();

        log.info("Validation titles <list> size vs score <list> size");
        Assert.assertEquals(hotelsPage.runHotelsTitle().size(),hotelsPage.runHotelsScore().size());

        log.info("Validation score <list> size vs titles <list> size");
        Assert.assertEquals(hotelsPage.runHotelsScore().size(),hotelsPage.runHotelsTitle().size());

        log.info("Validation price <list> size vs titles <list> size");
        Assert.assertEquals(hotelsPage.runHotelsPrice().size(),hotelsPage.runHotelsTitle().size());

        hotelsPage.clickSecondHotel();
        getWindowManager().switchToTab(hotelsPage.printSecondHotelTitle());
    }

}
