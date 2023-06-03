package JavaScriptExecuterClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.util.ElementScanner6;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
        WebElement actualMessage = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(BrowserUtils.getText(actualMessage), expectedMessage);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
        WebElement actualMessage1 = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expectedMessage1 = "You have selected Impressive";
        Assert.assertEquals(BrowserUtils.getText(actualMessage1), expectedMessage1);

        Thread.sleep(2000);

        WebElement noButton = driver.findElement(By.xpath("//label[@for='noRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (noButton.isDisplayed() && noButton.isEnabled()){

            System.out.println("NO BUTTON IS ENABLED ");

        }else {

            js.executeScript("arguments[0].click()",noButton);

        }

    }
    @Test
    public void scrollIntoView() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true)",findCourse);



    }
    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement actualMessageInTheBottom = driver.findElement(By.cssSelector("#el_1666192783854_462"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView",actualMessageInTheBottom);
        String expectedMessage = "Copyright © 2023";
        Assert.assertEquals(BrowserUtils.getText(actualMessageInTheBottom),expectedMessage.trim());

        WebElement applyNow = driver.findElement(By.cssSelector("#menuItem_1594985863854_2"));
        js.executeScript("arguments[0].click()",applyNow);

        List<WebElement> allInfo = driver.findElements(By.xpath("//div//h3[@data-element-id='heading3Normal']"));

        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i = 0 ; i< allInfo.size();i++){
            Thread.sleep(1000);
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expectedInfo.get(i));

        }









    }

}
