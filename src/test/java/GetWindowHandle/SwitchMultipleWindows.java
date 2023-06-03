package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test

    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String id: allPages){
            if(!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Kickstart");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");
    }
    @Test
    public void realTask() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement link = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,link);
        link.click();

        BrowserUtils.switchByTitle(driver,"Basic");

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Askar");
        Thread.sleep(200);
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Imanbekov");
        Thread.sleep(200);
        WebElement gender = driver.findElement(By.cssSelector("#malerb"));
        BrowserUtils.scrollWithJS(driver,gender);
        gender.click();
        Thread.sleep(200);
        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        Thread.sleep(200);
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("askar2004@gmail.com");
        Thread.sleep(200);
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Askar2004");
        Thread.sleep(200);
        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();
        WebElement actualMessage = driver.findElement(By.xpath("//label[.='Registration is Successful']"));
        String expectedMessage = "Registration is Successful";
        Thread.sleep(200);
        Assert.assertEquals(BrowserUtils.getText(actualMessage),expectedMessage);

        Thread.sleep(200);
        BrowserUtils.switchByTitle(driver,"Window");
        WebElement actualMessage1 = driver.findElement(By.xpath("//h1[contains(text(),'Window')]"));
        String expectedMessage1 = "Window Handles Practice";
        Assert.assertEquals(BrowserUtils.getText(actualMessage1),expectedMessage1);

        Thread.sleep(200);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMeButton   = driver.findElement(By.cssSelector("#promptBox"));
        clickMeButton.click();
        driver.quit();



    }

}
