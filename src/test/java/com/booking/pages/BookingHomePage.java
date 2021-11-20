package com.booking.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//div[normalize-space()='noviembre 2021']")
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

    @FindBy(css = "span[aria-label='25 noviembre 2021'] span[aria-hidden='true']")
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

    @FindBy (css = "span[aria-label='10 diciembre 2021'] span[aria-hidden='true']")
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

    @FindBy(className = "sb-group-field-has-error")
    private WebElement ageKid;

    public void clickAgeKid(){
        getWait().until(ExpectedConditions.elementToBeClickable(ageKid));
        ageKid.click();
    }

    @FindBy (xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/select/option[11]")
    private WebElement age9;




}
