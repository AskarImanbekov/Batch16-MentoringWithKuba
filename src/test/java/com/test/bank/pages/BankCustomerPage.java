package com.test.bank.pages;

import Utils.BrowserUtils;
import com.test.bank.tests.BankTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BankCustomerPage extends BankTestBase {

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

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawDebit;

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

        int actualBalance = Integer.parseInt(BrowserUtils.getText(balance));
        transactionButton.click();

        Thread.sleep(2000);

        int expectedBalance = (Integer.parseInt(BrowserUtils.getText(depositCredit))-
                (Integer.parseInt(BrowserUtils.getText(withdrawDebit))));

        Assert.assertEquals(actualBalance,expectedBalance);






    }
}
