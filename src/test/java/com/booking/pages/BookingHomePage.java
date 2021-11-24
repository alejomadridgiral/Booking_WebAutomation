package com.booking.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class BookingHomePage extends BasePage {

    public BookingHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.booking.com/index.es.html");
    }


    @FindBy(css = "li a[class='bui-tab__link bui-tab__link--selected']")
    private WebElement stays;

    public void clickStays() {
        getWait().until(ExpectedConditions.elementToBeClickable(stays));
        stays.click();
    }

    @FindBy(id = "ss")
    private WebElement searchCity;

    public void fillSearchCity(String city) {
        getWait().until(ExpectedConditions.elementToBeClickable(searchCity));
        searchCity.click();
        searchCity.sendKeys(city);
    }

    @FindBy(className = "sb-date-field__field")
    private WebElement checkInDate;

    public void clickCheckInData() {
        checkInDate.click();
    }

    @FindBy(className = "bui-calendar__dates")
    private WebElement calendar;

    public void visibilityOfCalendar() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(calendar));
    }

    @FindBy(className = "bui-calendar__month")
    private WebElement checkInMonthAndYear;

    public String getCheckInMonthAndYear() {
        return checkInMonthAndYear.getText();
    }

    public String getCheckInMonth() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(calendar));
        return getCheckInMonthAndYear().split(" ")[0].trim();
    }

    public String getCheckInYear() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(calendar));
        return getCheckInMonthAndYear().split(" ")[1].trim();
    }

    @FindBy (xpath = "//div[@class='bui-calendar__control bui-calendar__control--next']//*[name()='svg']")
    private WebElement nextMonth;

    public void clickNextMonth(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(calendar));
        nextMonth.click();
    }

    public String[] getMonthYear(String monthAndYear){
        return monthAndYear.split(" ");
    }

    public void setCheckInDate(String day, String month, String year){
        String monthAndYearText = checkInMonthAndYear.getText();

        while(!(getMonthYear(monthAndYearText)[0].equals(month) && getMonthYear(monthAndYearText)[1].equals(year))){
            nextMonth.click();
            monthAndYearText = checkInMonthAndYear.getText();
        }

        getDriver().findElement(By.xpath("//span[contains(@aria-label,'"+day+" "+month+" "+year+"')]//span[contains(@aria-hidden,'true')][normalize-space()='"+day+"']")).click();

    }

    @FindBy (xpath = "//div[normalize-space()='diciembre 2021']")
    private WebElement checkOutMonth;

    @FindBy (xpath = "//span[contains(@aria-label,'14 enero 2022')]//span[contains(@aria-hidden,'true')][normalize-space()='14']")
    private WebElement calendarOutDay;

    public void setCheckOutDate(String dayOut, String monthOut, String yearOut){
        getDriver().findElement(By.xpath("//span[contains(@aria-label,'"+dayOut+" "+monthOut+" "+yearOut+"')]//span[contains(@aria-hidden,'true')][normalize-space()='"+dayOut+"']")).click();
    }

    @FindBy (id="xp__guests__toggle")
    private WebElement guests;

    public void clickGuests(){
        guests.click();
    }

    @FindBy(css = "button[aria-label='Aumenta el número de Adultos'] span[class='bui-button__text']")
    private WebElement addAdults;

    public void clickAddAdults(){
        addAdults.click();
    }


    @FindBy(css = "button[aria-label='Aumenta el número de Niños'] span[class='bui-button__text']")
    private WebElement addKids;

    public void clickAddKids(){
        addKids.click();
    }

    @FindBy(name = "age")
    private WebElement ageKid;

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(ageKid);
    }

    @FindBy (className = "sb-searchbox__button")
    private WebElement search;

    public HotelsPage clickSearch(){
        getWait().until(ExpectedConditions.elementToBeClickable(search));
        search.click();
        return new HotelsPage(getDriver());
    }
}
