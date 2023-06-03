import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.time.Duration;

public class TumblrTask {
    @Test
    public void interviewQuestion(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        driver.findElement(By.xpath("//a[.='Log in']")).click();
        driver.findElement(By.xpath("//button[.='Continue with email']")).click();
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("askar200416@gmailcom");
        WebElement nextButton = driver.findElement(By.xpath("//span[.='Next']"));
        nextButton.click();

        WebElement failedNotice = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));

       if (failedNotice.isDisplayed()){
           System.out.println(BrowserUtils.getText(failedNotice));
           String actualMessage = BrowserUtils.getText(failedNotice);
           String expectedMessage = "That's not a valid email address. Please try again.";
           Assert.assertEquals(actualMessage,expectedMessage);
       }




        /*
Navigate to webapp
click login button
click continue with email button
provide email, and password (wrong credentials)
and validate the error message
driver quit
         */

    }

}
