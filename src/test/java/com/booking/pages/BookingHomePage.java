package com.booking.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingHomePage extends BasePage {

    public BookingHomePage(WebDriver driver){
        super(driver);
        driver.get("https://www.booking.com/index.es.html");
    }

}
