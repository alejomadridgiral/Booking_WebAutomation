package com.booking.utils;


import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
    }

    public void switchToTab(String tabTitle){
        driver.getWindowHandles();

        int windows = driver.getWindowHandles().size();

        System.out.println("Number of tabs: " + windows);
        System.out.println("Window handles:");
        driver.getWindowHandles().forEach(System.out::println);

        for (String window : driver.getWindowHandles()){
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window tittle: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }


    }


}
