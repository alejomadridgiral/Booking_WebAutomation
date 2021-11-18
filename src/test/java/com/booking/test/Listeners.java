package com.booking.test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult arg0){
        System.out.println("Test successful :) !!!");
    }

    @Override
    public void onTestFailure(ITestResult arg0){
        System.out.println("Test failed :( check the data entered");
    }

}
