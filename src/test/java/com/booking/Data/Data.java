package com.booking.Data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "createData")
    public static Object[][] getData() {
        int getRandomNumber = (int) Math.floor(Math.random() * 9750);
        Object[][] data = new Object[1][4];
        data[0][0] = "Espn";
        data[0][1] = "Create";
        data[0][2] = "EspnCreate" + getRandomNumber + "@globant.com";
        data[0][3] = "GLo_ESPN_1*#";
        return data;
    }

}