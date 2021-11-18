package com.booking.test;

import com.booking.driver.Driver;
import com.booking.pages.BookingHomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class BaseTest {

    Driver myDriver;

    private BookingHomePage espnHome;

    public BaseTest() {
    }

    @BeforeSuite(alwaysRun=true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) {
        myDriver = new Driver(browser);
        myDriver.getDriver().manage().window().maximize();
        espnHome = new BookingHomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun=true)
    public void afterSuite() {
        espnHome.dispose();
    }

    public BookingHomePage getEspnHomePage() {
        return espnHome;
    }
}
