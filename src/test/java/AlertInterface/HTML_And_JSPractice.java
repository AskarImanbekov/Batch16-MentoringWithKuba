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

public class HTML_And_JSPractice {

    @Test
    public void practiceBoth(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement jsButton = driver.findElement(By.xpath("//div[@class='page-container']//button[contains(@onclick,'alert')]"));
        jsButton.click();
        Alert alert = driver.switchTo().alert();
         String actualMessage = alert.getText().trim();
         String expectedMessage = "Oops, something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessage);
        alert.accept();

        WebElement htmlButton = driver.findElement(By.xpath("//div[@class='page-container']//button[contains(@onclick,'swal')]"));
        htmlButton.click();
        WebElement allMessage = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        System.out.println(BrowserUtils.getText(allMessage));// It will give everything with OK.
        WebElement okHtml = driver.findElement(By.xpath("//button[.='OK']"));
        okHtml.click();

    }
}
