package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@data-bs-dismiss='modal']")
    WebElement closeButton;

    @FindBy(css = "#menu-customer")
    WebElement customersOption;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement customersButton;



    public void customersPage() throws InterruptedException {

        closeButton.click();
        Thread.sleep(500);
        customersOption.click();
        Thread.sleep(500);
        customersButton.click();
        Thread.sleep(500);


    }
}
