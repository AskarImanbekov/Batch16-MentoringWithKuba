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

public class BankCustomerTest extends BankTestBase {

    @Test
    public void customerPageTest() throws InterruptedException {


        BankLoginPage bankLoginPage = new BankLoginPage(driver);

        Thread.sleep(2000);

        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        bankManagerPage.addCustomerFunctionality(driver,"Askar","Imanbekov","12345",
                "Customer added successfully with customer id");

        bankManagerPage.openAccountFunctionality(driver,"Askar Imanbekov","Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersFunctionality("Askar","Imanbekov","12345");

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankLoginPage.clickHomeButton();
        Thread.sleep(3000);
        bankLoginPage.clickCustomerLoginButton();
        Thread.sleep(3000);

        bankLoginPage.clickHomeButton();

        bankLoginPage.clickCustomerLoginButton();

        bankCustomerPage.selectYourNameAndValidate("Askar Imanbekov");

        bankCustomerPage.depositMoneyAndValidate("500", "Deposit Successful");

        Thread.sleep(3000);

        bankCustomerPage.withdrawAmountAndMessage("300","Transaction successful");

        bankCustomerPage.transactionFunctionality();


    }

}
