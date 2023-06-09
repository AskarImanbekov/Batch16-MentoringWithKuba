package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomersPage {

    public CustomersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addButton;

    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newSetterSlider;

    @FindBy(css = "#input-safe")
    WebElement safeSlider;

    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;

    @FindBy(css = ".alert")
    WebElement alertMessage;


    public void clickAddCustomer() {
        addButton.click();

    }

    public void provideInformation(WebDriver driver, String firstName, String lastName, String email, String password,
                                   String confirmPassword) throws InterruptedException {

        this.firstName.sendKeys(firstName);
        Thread.sleep(500);
        this.lastName.sendKeys(lastName);
        Thread.sleep(500);
        this.email.sendKeys(email);
        Thread.sleep(500);
        this.password.sendKeys(password);
        Thread.sleep(500);
        this.confirmPassword.sendKeys(confirmPassword);
        Thread.sleep(3000);

        BrowserUtils.scrollWithJS(driver, newSetterSlider);
        BrowserUtils.clickWithJS(driver, newSetterSlider);
        BrowserUtils.clickWithJS(driver, safeSlider);
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,saveButton);
        BrowserUtils.clickWithJS(driver,saveButton);

        Assert.assertEquals(BrowserUtils.getText(alertMessage), "Warning: You do not have permission to modify customers!");

    }

}
