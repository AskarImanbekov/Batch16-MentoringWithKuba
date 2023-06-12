package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver ){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    @FindBy(xpath = "//tr//td")
    List<WebElement> macInfo;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement creditCard;

    @FindBy(css = "#month")
    WebElement exMonth;

    @FindBy(css = "#year")
    WebElement exYear;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement finalMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void validateTitleAdnPrice(WebDriver driver,String title , String price) throws InterruptedException {

        List<String > expectedMessage = Arrays.asList("",title,price,"");

        for (int i = 1 ; i < macInfo.size()-1; i++){

            Assert.assertEquals(BrowserUtils.getText(macInfo.get(i)),expectedMessage.get(i));

        }


    }

  public void placeOrder(WebDriver driver , String name , String country , String city ,String creditCard ,String exMonth , String exYear,
                         String expectedFinalMessage) throws InterruptedException {

        placeOrderButton.click();
       Thread.sleep(1000);

        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(creditCard);
        this.exMonth.sendKeys(exMonth);
        this.exYear.sendKeys(exYear);
        BrowserUtils.scrollWithJS(driver, purchaseButton);

        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(500);

        Assert.assertEquals(BrowserUtils.getText(finalMessage),expectedFinalMessage);
        Thread.sleep(500);
        okButton.click();

        String actualURL = driver.getCurrentUrl();



  }


}
