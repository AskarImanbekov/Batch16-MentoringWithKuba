package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATH_Locator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        //RELATIVE XPATH
        WebElement abTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTesting.click();

        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        link.click();

        //ABSOLUTE XPATH
        WebElement header = driver.findElement(By.xpath("html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        WebElement paragraph  = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

    }
}
