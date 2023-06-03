package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);

        String actualColor = orangeBox.getCssValue("background-color");
        String expectedColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColor,expectedColor);

        WebElement ball = driver.findElement(By.cssSelector("#draggable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ball,orangeBox).perform();

        Thread.sleep(2000);

        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageAfter = BrowserUtils.getText(orangeBox);
        String expectedMessageAfter = "You did great!";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);

    }
    @Test
    public void DragAndDropPractice2 () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);

        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);

        WebElement ball = driver.findElement(By.cssSelector("#draggable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(ball).moveToElement(blueBox).release().perform();

        Thread.sleep(2000);

        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfter = BrowserUtils.getText(blueBox);
        String expectedMessageAfter = "You did great!";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);


    }
}
