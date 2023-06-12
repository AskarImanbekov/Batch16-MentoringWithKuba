package com.test.restaurant.test;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RestaurantTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
