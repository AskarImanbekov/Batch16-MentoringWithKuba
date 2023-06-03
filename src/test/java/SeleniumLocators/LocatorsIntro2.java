package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/askarimanbekov/Desktop/Techtorial.html");

        //LINKED TEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "correct" : "false");

        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h4"));
        String actualHeader1 = seleniumHeader.getText().trim();
        String expectedHeader1 = "Selenium WebDriver";
        System.out.println(actualHeader1.equals(expectedHeader1) ? "Correct" : "Incorrect");

        driver.navigate().back();

        WebElement cucumberLink =  driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualHeader2 = cucumberHeader.getText().trim();
        String expectedHeader2 = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualHeader2.equals(expectedHeader2) ? "correct" : "incorrect");

        driver.navigate().back();

        WebElement textNGLink = driver.findElement(By.linkText("TestNG"));
        textNGLink.click();
        WebElement testNgHeader = driver.findElement(By.tagName("h2"));
        String actualHeader3 = testNgHeader.getText().trim();
        String expectedHeader3 = "TestNG";
        System.out.println(actualHeader3.equals(expectedHeader3) ? "Correct" : "Incorrect");

        driver.navigate().back();

        // LOCATOR PARTIAL LINK TEXT :

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());






    }
}
