package com.test.restaurant.page;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishForDinnerPage {

    public  FishForDinnerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#starRating_score_4Star")
    WebElement fourStars;

    @FindBy(css = "#pop_search_editor")
    WebElement editorChoice;

    @FindBy(css = ".card__title")
    WebElement titleOfFood;



    public void bestChoiceValidateTitle(WebDriver driver,String expectedTitle) throws InterruptedException {


            Thread.sleep(1000);
            BrowserUtils.clickWithJS(driver,fourStars);

            Thread.sleep(1000);
            BrowserUtils.clickWithJS(driver,editorChoice);

        Thread.sleep(1000);

        Assert.assertEquals(BrowserUtils.getText(titleOfFood),expectedTitle);

    }


}
