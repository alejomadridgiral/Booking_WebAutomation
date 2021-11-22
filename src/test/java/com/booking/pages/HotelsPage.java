package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsPage extends BasePage {

    public HotelsPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath="//*[@id=\"searchboxInc\"]/div[1]/div/div/div[1]/div[5]/div[5]" )
    private WebElement fiveStars;

    public void clickFiveStars(){
        getWait().until(ExpectedConditions.elementToBeClickable(fiveStars));
        fiveStars.click();
    }

}
