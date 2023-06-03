package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATH_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Askar");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Imanbekov");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("anbekov@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("917-283 8938");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Askar2004");

        WebElement confirm= driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirm.sendKeys("Askar2004");

        WebElement box= driver.findElement(By.xpath("//input[@type='checkbox']"));
        box.click();

        WebElement continueBox= driver.findElement(By.xpath(" //input[@type='submit']"));
        continueBox.click();

        WebElement oneMoreBox = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        oneMoreBox.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl) ? "Correct URL" : "Incorrect URL");
        driver.quit();








    }
}
