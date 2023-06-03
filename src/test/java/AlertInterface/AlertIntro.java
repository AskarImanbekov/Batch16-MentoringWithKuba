package AlertInterface;

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

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();

        Alert alert =driver.switchTo().alert();
        String actualText = alert.getText().trim();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();// it will click OK button , otherwise you will get UNHANDLED ALERT EXCEPTION
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void alertDismiss() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();

        Alert alert  =driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        WebElement message = driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);


    }
    @Test
    public void alertSendKeys() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

       WebElement jsSendMessage = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
       jsSendMessage.click();
       Alert alert = driver.switchTo().alert();
       alert.sendKeys("Homework is Important");
       Thread.sleep(3000);
       alert.accept();

       WebElement resultMessage = driver.findElement(By.cssSelector("#result"));
       String actualMessage = BrowserUtils.getText(resultMessage);
       String expectedMessage = "You entered: Homework is Important";
       Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void practiceJsAlert(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBoxOK = driver.findElement(By.cssSelector("#alertBox"));
        alertBoxOK.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText().trim();
        String expectedMessage = "I am an alert box!";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();

        WebElement alertBoxCancel = driver.findElement(By.cssSelector("#confirmBox"));
        alertBoxCancel.click();
        String actualMessage1 = alert.getText().trim();
        String expectedMessage1  ="Press a button!";
        Assert.assertEquals(actualMessage1,expectedMessage1);
        alert.dismiss();
        WebElement sendKeysBox = driver.findElement(By.cssSelector("#promptBox"));
        BrowserUtils.scrollWithJS(driver,sendKeysBox);
        sendKeysBox.click();
        alert.sendKeys("My name is Askar");
        alert.accept();

        WebElement MessageAfterSendingKey = driver.findElement(By.xpath("//div[.='You entered text My name is Askar in propmt popup']"));
        String actualMessage3 = BrowserUtils.getText(MessageAfterSendingKey);
        String expectedMessage3 = "You entered text My name is Askar in prompt popup";
        Assert.assertEquals(actualMessage3,expectedMessage3);



    }
}
