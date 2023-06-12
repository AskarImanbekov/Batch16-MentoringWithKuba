package com.test.restaurant.page;

import Utils.BrowserUtils;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishAndSeafoodPage {

    public FishAndSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='Find a Recipe...']")
    WebElement searchBar;

    @FindBy(css = "#button_1-0")
    WebElement searchButton;



    public void searchBar(WebDriver driver,String text) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver,searchBar);
        Thread.sleep(1000);
        searchBar.sendKeys(text);
        Thread.sleep(1000);
        searchButton.click();


    }


}
