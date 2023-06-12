package com.test.restaurant.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class RestaurantMainPage {

    public RestaurantMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;

    @FindBy(xpath = "//li[@class='global-nav__list-item js-global-nav-item'][3]//li")
    List<WebElement> allOptions;

    public void selectOption(WebDriver driver, String typeOfFood) throws InterruptedException {


        Actions actions = new Actions(driver);

        Thread.sleep(1000);

        actions.moveToElement(ingredients).perform();

        for (int i = 0; i<allOptions.size();i++) {
            Thread.sleep(1000);

           if (BrowserUtils.getText(allOptions.get(i)).equals(typeOfFood.toUpperCase())){

               Thread.sleep(500);
               actions.click(allOptions.get(i)).perform();
           }
        }


    }


}

