package com.test.bank.pages;

import Utils.BrowserUtils;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add ')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Acc')]")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "ng-binding")
    List<WebElement>  allInformation;

    public void addCustomerFunctionality(WebDriver driver,String firstName , String lastName , String zipCode,String expectedMessage) throws InterruptedException {

        addCustomerButton.click();



        this.firstName.sendKeys(firstName);
        Thread.sleep(500);
        this.lastName.sendKeys(lastName);
        Thread.sleep(500);
        this.zipCode.sendKeys(zipCode);
        Thread.sleep(500);

        submitAddCustomerButton.submit();

        Thread.sleep(500);
        Alert alert =driver.switchTo().alert();
        Thread.sleep(500);
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        Thread.sleep(500);
        alert.accept();



    }

    public void openAccountFunctionality(WebDriver driver, String name, String currency,String expectedMessage ){

        openAccountButton.click();

        BrowserUtils.selectBy(customerName,name,"text");

        BrowserUtils.selectBy(this.currency, currency ,"value");

        processButton.click();

        Alert alert =driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();

    }

    public void customersFunctionality(String firstName,String lastName , String postCode){
        customersButton.click();
        searchBar.sendKeys(firstName);
        List<String> expectedNames = Arrays.asList(firstName, lastName, postCode);

        for (int i = 0; i < allInformation.size();i++){

            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));

        }
    }

}
