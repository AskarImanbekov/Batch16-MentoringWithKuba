import Utils.BrowserUtils;
import com.beust.ah.A;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MentoringWithKuba {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

       driver.findElement(By.xpath("//a[.='Table Pagination']")).click();

        List<WebElement> names = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[3]"));

        for (int i = 0 ; i< names.size();i++){}




    }
    @Test
    public void Task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        driver.findElement(By.xpath("//li//a[.='Javascript Alerts']")).click();

        WebElement jsButton = driver.findElement(By.xpath("//p[contains(.,'JS Alert')]//following-sibling::button"));
        jsButton.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        WebElement confirmBox = driver.findElement(By.xpath("//p[@class='text-gray-900 text-size-16 mt-10 text-black font-bold']//button[@class='btn btn-dark mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
        confirmBox.click();
        Thread.sleep(2000);
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#confirm-demo"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage ="You pressed Cancel!";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement sendKeyButton = driver.findElement(By.xpath("//p[@class='text-gray-900 ml-10 text-size-16 mt-10 text-black font-bold']//button[@class='btn btn-dark mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
        sendKeyButton.click();
        alert.sendKeys("Askar");
        Thread.sleep(2000);
        alert.accept();

        WebElement promptMessage = driver.findElement(By.cssSelector("#prompt-demo"));
        String actualMessagePrompt = BrowserUtils.getText(promptMessage);
        String expectedMessagePrompt = "You have entered 'Askar' !";
        Assert.assertEquals(actualMessagePrompt,expectedMessagePrompt);

    }
}
