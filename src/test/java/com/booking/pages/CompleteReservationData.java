package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class CompleteReservationData extends BasePage{

    public CompleteReservationData(WebDriver driver){
        super(driver);
    }

    @FindBy(id="phone")
    private WebElement phone;

    public void fillPhone(String fillPhone) {
        phone.click();
        phone.sendKeys(fillPhone);
    }

    @FindBy(id = "cc_type")
    private WebElement cardType;

    public void selectFromDropDown(String option){
        findDropDownElement().selectByValue(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(cardType);
    }

    @FindBy(id="cc_number")
    private WebElement ccNumber;

    public void fillCcNumber(String fillCcNumber) {
        ccNumber.click();
        ccNumber.sendKeys(fillCcNumber);
    }

    @FindBy(id="cc_cvc")
    private WebElement ccCvc;

    public void fillCcCvc(String fillCcCvc) {
        ccCvc.click();
        ccCvc.sendKeys(fillCcCvc);
    }

    @FindBy(xpath = "//main[@id='content']//li[1]//div[2]")
    private WebElement automaticName;

    public String getAutomaticName(){
        getWait().until(ExpectedConditions.visibilityOf(automaticName));
        System.out.println(automaticName.getText());
        return automaticName.getText();
    }

    @FindBy(xpath = "//main[@id='content']//li[2]//div[2]")
    private WebElement automaticEmail;

    public String getAutomaticEmail(){
        getWait().until(ExpectedConditions.visibilityOf(automaticEmail));
        System.out.println(automaticEmail.getText());
        return automaticEmail.getText();
    }

    @FindBy(id = "bp-property-details__title")
    private WebElement finalHotelTitle;

    public String getFinalHotelTitle(){
        System.out.println(finalHotelTitle.getText() + " getFinalHotelTitle :)");
        return finalHotelTitle.getText();
    }

    @FindBy(xpath = "//li[contains(text(),'3 adultos,')]")
    private WebElement numberOfAdultsAndChildsFinal;

    public String getNumberOfAdultsAndChildsFinal(){
        System.out.println(numberOfAdultsAndChildsFinal.getText() + " getNumberOfAdultsAndChildsFinal");
        return numberOfAdultsAndChildsFinal.getText();
    }

    @FindBy(xpath = "//*[@id=\"bodyconstraint-inner\"]/div[3]/div[2]/aside/div/div[1]/div/section/div/div[2]/div/div/div/div/div/div[2]/span")
    private WebElement totalPriceFinal;

    public String getTotalPriceFinal(){
        System.out.println(totalPriceFinal.getText() + " getTotalPriceFinal");
        return totalPriceFinal.getText();
    }

    @FindBy(className = "bui-review-score__badge")
    private WebElement scoreFinal;

    public String getScoreFinal(){
        System.out.println(scoreFinal.getText() + " getScoreFinal");
        return scoreFinal.getText();
    }

}
