package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainBlazePage {

    public  MainBlazePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='list-group']//a")
    List<WebElement> category;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void categoryOption(String  categoryChoice) throws InterruptedException {

        for (WebElement techs : category){


            if (BrowserUtils.getText(techs).equals(categoryChoice)){
                techs.click();
                break;
            }
        }
        Thread.sleep(2000);



    }
    public void clickCartButton(){
        cartButton.click();
    }
}
