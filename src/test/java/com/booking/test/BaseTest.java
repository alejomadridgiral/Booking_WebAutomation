package com.booking.test;

import com.booking.driver.Driver;
import com.booking.pages.BookingHomePage;
import com.booking.pages.HotelsPage;
import com.booking.utils.WindowManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class BaseTest {

    Driver myDriver;

    private BookingHomePage bookingHome;


    public BaseTest() {
    }

    @BeforeSuite(alwaysRun=true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new Driver(browser);
        myDriver.getDriver().manage().window().maximize();
        bookingHome = new BookingHomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun=true)
    public void afterSuite() {
        bookingHome.dispose();
    }

    public BookingHomePage getBookingHomePage() {
        return bookingHome;
    }

    public WindowManager getWindowManager(){
        return new WindowManager(myDriver.getDriver());
    }

}
