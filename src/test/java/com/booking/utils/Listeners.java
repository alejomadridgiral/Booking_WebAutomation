package com.booking.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult arg0){
        System.out.println("Test case successful :) !!!");
    }

    @Override
    public void onTestFailure(ITestResult arg0){
        System.out.println("Test case failed :( re-run the test");
    }

}
