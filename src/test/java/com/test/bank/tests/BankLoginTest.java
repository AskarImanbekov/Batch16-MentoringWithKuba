package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends BankTestBase {

    @Test
    public void validateLoginPageComponents(){

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.loginPageComponentValidation("XYZ Bank");


    }
}
