package com.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HotelsPage extends BasePage {

    public HotelsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-filters-item='class:class=5']")
    private WebElement fiveStars;

    public void clickFiveStars() {
        getWait().until(ExpectedConditions.elementToBeClickable(fiveStars));
        fiveStars.click();
    }

    @FindBy(css = "div[class='fde444d7ef _c445487e2']")
    private List<WebElement> hotelTitle;

    public List<String> runHotelsTitle() {
        List<String> hotelTitles = new ArrayList<>();
        for (int i = 0; i < hotelTitle.size(); i++) {
            hotelTitles.add(hotelTitle.get(i).getText());

        }
        return hotelTitles;
    }

    @FindBy(css = "div[class='_9c5f726ff bd528f9ea6']")
    private List<WebElement> hotelScore;

    public List<String> runHotelsScore() {
        List<String> hotelScores = new ArrayList<>();
        for (int i = 0; i < hotelScore.size(); i++) {
            hotelScores.add(hotelScore.get(i).getText());

        }
        return hotelScores;
    }

    @FindBy(css = "div span[class='fde444d7ef _e885fdc12']")
    private List<WebElement> hotelPrice;

    public List<String> runHotelsPrice() {
        List<String> hotelPrices = new ArrayList<>();
        for (int i = 0; i < hotelPrice.size(); i++) {
            hotelPrices.add(hotelPrice.get(i).getText());

        }
        return hotelPrices;
    }

    public void clickSecondHotel() {
        for (int i = 0; i < 1; i++) {
            getWait().until(ExpectedConditions.visibilityOfAllElements(hotelTitle));
            hotelTitle.get(1).click();
        }
    }

    public String printSecondHotelTitle() {
        String secondHotelTitle = hotelTitle.get(1).getText();
        return secondHotelTitle;
    }

    public String printSecondHotelScore() {
        String secondHotelScore = hotelScore.get(1).getText();
        return secondHotelScore;
    }

    public String printSecondHotelPrice() {
        String secondHotelPrice = hotelPrice.get(1).getText();
        return secondHotelPrice;
    }

    public String printSecondHotelTitleSecondWord() {
        return printSecondHotelTitle().split(" ")[1].trim();
    }


}