package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartPage {

    public OpenChartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='input-username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(css = ".position-fixed")
    WebElement alert;

    @FindBy(xpath ="//button[@class='btn-close']")
    WebElement closeButton;


    public void loginPageFunction(WebDriver driver , String username , String password) throws InterruptedException {

       this.username.sendKeys(username);
       this.password.sendKeys(password);
       Thread.sleep(500);
       loginButton.click();
       Thread.sleep(500);

        if ( !username.equals("demo") || !password.equals("demo")){

            Thread.sleep(500);

            String actualErrorMessage = BrowserUtils.getText(alert);
            String expectedErrorMessage = "No match for Username and/or Password.";
            Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        }else {
            String actualTitle = driver.getTitle();
            String expectedTitle = "Dashboard";
            Assert.assertEquals(actualTitle,expectedTitle);
        }

    }


}
