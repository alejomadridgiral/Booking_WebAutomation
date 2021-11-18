package com.booking.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingHomePage extends BasePage {

    public BookingHomePage(WebDriver driver){
        super(driver);
        driver.get("https://www.booking.com/index.es.html");
    }


    @FindBy(css="li a[class='bui-tab__link bui-tab__link--selected']")
    private WebElement stays;

    public void clickStays(){
        getWait().until(ExpectedConditions.elementToBeClickable(stays));
        stays.click();
    }

    @FindBy(id="ss")
    private WebElement searchCity;

    public void fillSearchCity(String city){
        getWait().until(ExpectedConditions.elementToBeClickable(searchCity));
        searchCity.click();
        searchCity.sendKeys(city);
    }

}
