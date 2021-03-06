package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HotelPageSecondResult extends BasePage {

    public HotelPageSecondResult(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#hp_hotel_name")
    private WebElement titleSecondResult;

    public String getTitleSecondResult(){
        return titleSecondResult.getText().split(" ")[1].trim();
    }

    @FindBy(xpath = "//*[@id=\"group_recommendation\"]/h3")
    private WebElement numberOfAdultsAndChilds;

    public String getNumberOfAdultsAndChilds(){
        return numberOfAdultsAndChilds.getText();
    }

    @FindBy(xpath = "//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/div/div/div[1]/div/span")
    private WebElement totalPrice;

    public String getTotalPrice(){
        return totalPrice.getText();
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

    @FindBy(xpath = "//select[@class='hprt-nos-select js-hprt-nos-select' and @data-component='hotel/new-rooms-table/select-rooms']")
    private WebElement confirmRooms;

    public void selectFromDropDown(String option){
        findDropDownElement().selectByValue(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(confirmRooms);
    }

}
