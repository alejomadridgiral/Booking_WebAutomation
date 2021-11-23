package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


}
