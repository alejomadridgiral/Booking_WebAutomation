package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationData extends BasePage {

    public ReservationData(WebDriver driver){
        super(driver);
    }

    @FindBy (id="firstname")
    private WebElement firstname;

    public void fillFirstname(String fillfirstname) {
//        getWait().until(ExpectedConditions.elementToBeClickable(firstname));
        firstname.click();
        firstname.sendKeys(fillfirstname);
    }

}
