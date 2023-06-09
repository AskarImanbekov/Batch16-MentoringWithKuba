package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement searchBar;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//span[.='Askar Imanbekov']")
    WebElement displayedName;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(tagName = "input")
    WebElement amountMoney;

    @FindBy(xpath = "//button[.='Deposit']")
    WebElement submitDeposit;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement successfulDepositMessage;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement firstWithdrawButton;

    @FindBy(tagName = "input")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawButton;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//button[contains(text(),'Trans')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding']")
    List<WebElement> depositFullAmount;

    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding']")
    List<WebElement> withdrawFullAmount;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement withdrawSuccessfulMessage;


    public void selectYourNameAndValidate(String fullName) {
        BrowserUtils.selectBy(searchBar,fullName,"text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(displayedName),fullName);
    }

    public void depositMoneyAndValidate(String amount,String expectedMessage){

        depositButton.click();
        amountMoney.sendKeys(amount);
        submitDeposit.click();
        Assert.assertEquals(BrowserUtils.getText(successfulDepositMessage),expectedMessage);

    }

    public void withdrawAmountAndMessage(String amount, String expectedMessage) throws InterruptedException {

        firstWithdrawButton.click();
        Thread.sleep(3000);
        withdrawAmount.sendKeys(amount);
        Thread.sleep(3000);
        withdrawButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(withdrawSuccessfulMessage),expectedMessage);
    }

    public void transactionFunctionality() throws InterruptedException {

        transactionButton.click();

        Thread.sleep(2000);

        Integer depositAmount = 0;

        for (int i = 1 ; i < depositFullAmount.size()-1;i++){

            Integer deposit = Integer.parseInt(BrowserUtils.getText(depositFullAmount.get(i)));

            depositAmount+=deposit;

        }
        Integer withdrawAmount = 0;

        Thread.sleep(2000);

        for (int j = 1 ; j<withdrawFullAmount.size()-1;j++){

            Integer withdraw = Integer.parseInt(BrowserUtils.getText(withdrawFullAmount.get(j)));

            withdrawAmount+=withdraw;

        }
        int result = depositAmount - withdrawAmount;



        Assert.assertEquals(result,balance);


    }
}
