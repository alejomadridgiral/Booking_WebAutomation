package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelPageSecondResult extends BasePage {

    public HotelPageSecondResult(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#hp_hotel_name")
    private WebElement titleSecondResult;

    public String getTitleSecondResult(){
        System.out.println(titleSecondResult.getText());
        return titleSecondResult.getText();
    }

    @FindBy(xpath = "//*[@id=\"group_recommendation\"]/h3")
    private WebElement numberOfAdultsAndChilds;

    public void getNumberOfAdultsAndChilds(){
        numberOfAdultsAndChilds.getText();
        System.out.println(numberOfAdultsAndChilds.getText());
    }

    @FindBy(xpath = "//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/div/div/div[1]/div/span")
    private WebElement totalPrice;

    public void getTotalPrice(){
        totalPrice.getText();
        System.out.println(totalPrice.getText());
    }

    @FindBy(css="td[class='submitButton'] a")
    private WebElement booking;

    public void clickBooking(){
        booking.click();
    }

    @FindBy(xpath="//button[contains(@class,'hp_rt_input js-reservation-button')]")
    private WebElement confirmBooking;

    public void clickConfirmBooking(){
        getWait().until(ExpectedConditions.elementToBeClickable(confirmBooking));
        confirmBooking.click();
    }




}
