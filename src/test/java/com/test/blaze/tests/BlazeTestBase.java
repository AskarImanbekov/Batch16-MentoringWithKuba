package com.test.blaze.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BlazeTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = DriverHelper.getDriver();
        driver.navigate().to("https://www.demoblaze.com/#");

    }
    @AfterMethod
    public void teardown(ITestResult iTestResult){

        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blazePictures");
        }
        driver.quit();
    }
}
