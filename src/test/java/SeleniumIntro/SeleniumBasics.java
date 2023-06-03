package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;
//First step is setting up your automation

public class SeleniumBasics {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //then create your driver to start your automation
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        String expectedTitle = "Amazon.com. Spend less. Smile more.";

        String actualTitle  = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        String actualUrl = driver.getCurrentUrl();



            }
    }
