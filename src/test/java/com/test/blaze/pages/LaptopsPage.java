package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LaptopsPage {

    public LaptopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card-title")
    List<WebElement> laptopNames;

    @FindBy(tagName = "h2")
    WebElement nameOfLaptop;

    @FindBy(tagName = "h3")
    WebElement priceOfLaptop;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement moreInfo;

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;


    public void laptopChoice(WebDriver driver, String laptopName) throws InterruptedException {

        for (WebElement laptop: laptopNames){

            Thread.sleep(1000);

            if (BrowserUtils.getText(laptop).equals(laptopName)){

                BrowserUtils.scrollWithJS(driver, laptop);
                Thread.sleep(2000);
               laptop.click();

                break;
            }
        }
    }
    public void checkInfo(String expectedName , String expectedPrice ,String expectedInformation) throws InterruptedException {

        Assert.assertEquals(BrowserUtils.getText(nameOfLaptop),expectedName);
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(priceOfLaptop) , expectedPrice);
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(moreInfo) , expectedInformation);
        Thread.sleep(500);
    }
    public void addToCart(WebDriver driver , String expectedMessage) throws InterruptedException {
        addToCartButton.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),expectedMessage );
        Thread.sleep(1000);
        alert.accept();
    }



}
