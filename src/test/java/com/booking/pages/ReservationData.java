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
        firstname.click();
        firstname.sendKeys(fillfirstname);
    }

    @FindBy (id="lastname")
    private WebElement lastname;

    public void fillLastname(String fillLastname) {
        lastname.click();
        lastname.sendKeys(fillLastname);
    }

    @FindBy (id="email")
    private WebElement email;

    public void fillEmail(String fillEmail) {
//        getWait().until(ExpectedConditions.visibilityOfAllElements(email));
        email.click();
        email.sendKeys(fillEmail);
    }

    @FindBy (id="email_confirm")
    private WebElement email_confirm;

    public void fillEmail_confirm(String fillEmail_confirm) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(email_confirm));
        email_confirm.click();
        email_confirm.sendKeys(fillEmail_confirm);
    }

    @FindBy (css="button[name='book'] span[class='bui-button__text js-button__text']")
    private WebElement lastDataButton;

    public void clickLastDataButton() {
        lastDataButton.click();
    }
}
