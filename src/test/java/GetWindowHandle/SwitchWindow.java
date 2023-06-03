package GetWindowHandle;

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

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");

        WebElement link = driver.findElement(By.xpath("//a[.='Multiple Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView",link);
        link.click();
        WebElement anotherLink = driver.findElement(By.xpath( "//a[.='Click Here']"));
        anotherLink.click();
        WebElement message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));
        System.out.println(driver.getWindowHandle());// main page ID --> The internet
        String mainPage = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id : allPagesID){
            if (!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        message = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));



    }
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement newTab = driver.findElement(By.cssSelector("#newTabBtn"));
        newTab.click();
        String mainPage = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String newWindow : allWindows){
            if (!newWindow.equals(mainPage)){
                driver.switchTo().window(newWindow);
                break;
            }

        }
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle.trim());
        Thread.sleep(2000);
        WebElement clickButton = driver.findElement(By.cssSelector("#alertBox"));
        clickButton.click();





    }
}
