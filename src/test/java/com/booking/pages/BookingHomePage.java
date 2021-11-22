package com.booking.pages;


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

    @FindBy(xpath = "//span[text()='22']")
    private WebElement calendarInDay;



    //td[@class='bui-calendar__date bui-calendar__date--selected']



    public void clickCalendarInDay(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(calendar));
        calendarInDay.click();
    }

    public void lookForFuture(){
        while(!(getCheckInMonth().equals("June") && getCheckInYear().equals("2022"))){
            nextMonth.click();
        }
    }

    @FindBy (xpath = "//div[normalize-space()='diciembre 2021']")
    private WebElement checkOutMonth;

    @FindBy (xpath = "//span[text()='6']")
    private WebElement calendarOutDay;

    public void clickCalendarOutDay(){
        calendarOutDay.click();
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

//    public void clickAgeKid(){
//        getWait().until(ExpectedConditions.elementToBeClickable(ageKid));
//        ageKid.click();
//    }

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

//    public HotelsPage goToHotelsPage(){
//        return new HotelsPage(getDriver());
//    }

}
