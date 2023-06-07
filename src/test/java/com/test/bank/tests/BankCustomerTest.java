package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest {

    @Test
    public void customerPageTest() throws InterruptedException {

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

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankLoginPage.clickHomeButton();
        Thread.sleep(500);
        bankLoginPage.clickCustomerLoginButton();
        Thread.sleep(500);

        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();

        bankCustomerPage.selectYourNameAndValidate("Askar Imanbekov");

        bankCustomerPage.depositMoneyAndValidate("500", "Deposit Successful");

        Thread.sleep(3000);

        bankCustomerPage.withdrawAmountAndMessage("300","Transaction successful");

        bankCustomerPage.checkBalance();

        bankCustomerPage.depositAndWithDrawMath();

        driver.quit();

    }

}
