package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest {

    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Askar","Imabekov","12345",
                "Customer added successfully with customer id");

    }
    @Test
    public void validatingOpenAccountFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        bankManagerPage.addCustomerFunctionality(driver,"Askar","Imanbekov","12345",
                "Customer added successfully with customer id");

        bankManagerPage.openAccountFunctionality(driver,"Askar Imanbekov","Dollar",
                "Account created successfully with account Number");


    }

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        bankManagerPage.addCustomerFunctionality(driver,"Askar","Imanbekov","12345",
                "Customer added successfully with customer id");

        bankManagerPage.openAccountFunctionality(driver,"Askar Imanbekov","Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Askar","Imanbekov","12345");




    }
}
