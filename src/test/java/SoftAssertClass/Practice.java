package SoftAssertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {
    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBoxOK = driver.findElement(By.cssSelector("#alertBox"));
        alertBoxOK.click();

        Alert alert = driver.switchTo().alert();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(alert.getText().trim(),"I am an alert box!");
        alert.accept();

        WebElement alertBoxCancel = driver.findElement(By.cssSelector("#confirmBox"));
        alertBoxCancel.click();
        softAssert.assertEquals(alert.getText().trim(),"Press a button!");
        alert.dismiss();
        WebElement sendKeysBox = driver.findElement(By.cssSelector("#promptBox"));
        BrowserUtils.scrollWithJS(driver,sendKeysBox);
        sendKeysBox.click();
        alert.sendKeys("My name is Askar");
        alert.accept();

        WebElement MessageAfterSendingKey = driver.findElement(By.xpath("//div[.='You entered text My name is Askar in propmt popup']"));
       softAssert.assertEquals(MessageAfterSendingKey.getText().trim(),"You entered text My name is Askar in propmt popup");
       softAssert.assertAll();
    }
}
