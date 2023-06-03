package Frame_And_Iframe;

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
import java.util.List;
import java.util.Set;

public class FramePractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.xpath("//h3"));
        String headerInString  = BrowserUtils.getText(header);
        System.out.println(headerInString);
        driver.switchTo().frame("mce_0_ifr");
        WebElement message = driver.findElement(By.cssSelector("#tinymce"));
        message.clear();
        message.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionButton.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Home");
        WebElement seleniumButton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumButton).perform();
        WebElement seleniumPython = driver.findElement(By.xpath("//span[contains(text(),'Selenium-Python')]"));
        seleniumPython.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);

        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));

        for (WebElement id : allLinks){
            System.out.println(BrowserUtils.getText(id));
        }
        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Frame1");


        WebElement categoryLink = driver.findElement(By.xpath("//a[.='Category1']"));
        categoryLink.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting");
        WebElement header1 = driver.findElement(By.xpath("//div//h1"));
        String actualHeader1 = BrowserUtils.getText(header1);
        String expectedHeader1 = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader1,expectedHeader1);
        List<WebElement> allHeaders = driver.findElements(By.xpath("//h3//a"));
        for (WebElement headerAlone : allHeaders){

            System.out.println(BrowserUtils.getText(headerAlone));

        }

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Framename1");

        WebElement textInsideFrame = driver.findElement(By.xpath("//p[.='I am inside Frame']"));
        String actualMessage = BrowserUtils.getText(textInsideFrame);
        String expectedMessage  = "I am inside Frame";
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("Frame2");

        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting");

        WebElement mainHeader = driver.findElement(By.xpath("//div//h1"));
        System.out.println(BrowserUtils.getText(mainHeader));






    }

}
