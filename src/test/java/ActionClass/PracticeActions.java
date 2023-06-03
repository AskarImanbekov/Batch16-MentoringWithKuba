package ActionClass;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.BreakIterator;
import java.time.Duration;

public class PracticeActions {
    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement actualMessage = driver.findElement(By.xpath("//p[.='Drop here']"));
        String expectedMessage = "Drop here";
        Assert.assertEquals(BrowserUtils.getText(actualMessage),expectedMessage);

        WebElement draggableBox = driver.findElement(By.cssSelector("#draggable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableBox,actualMessage).perform();

        WebElement actualMessageAfter = driver.findElement(By.xpath("//p[.='Dropped!']"));
        String expectedMessageAfter = "Dropped!";
        Assert.assertEquals(BrowserUtils.getText(actualMessageAfter),expectedMessageAfter);

        actualMessage = driver.findElement(By.xpath("//p[.='Drop here']"));
        String actualColor = actualMessage.getCssValue("background-color");
        String expectedColor = "rgba(0, 0, 0, 0)";
        Assert.assertEquals(actualColor,expectedColor);


    }
    @Test
    public void clickAndHold(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.xpath("//a[.='Accept']"));
        acceptButton.click();

        WebElement bucket = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div[@id='droppable']"));

        WebElement NotAcceptableMessage = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String expectedMessage = "Not Acceptable";
        Assert.assertEquals(BrowserUtils.getText(NotAcceptableMessage),expectedMessage);

        Actions actions = new Actions(driver);
        actions.clickAndHold(NotAcceptableMessage).moveToElement(bucket).release().perform();

        WebElement actualMessageAfter = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//p[.='Drop here']"));
        String expectedMessageAfter = "Drop here";
        Assert.assertEquals(BrowserUtils.getText(actualMessageAfter),expectedMessageAfter);




    }
}
