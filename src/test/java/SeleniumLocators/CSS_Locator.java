package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSS_Locator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.etsy.com/");
        /*
        search for WATCH

         */

        WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBar.sendKeys("Watch");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        Thread.sleep(2000);

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.etsy.com/search?q=watch%20&ref=search_bar";

        System.out.println(currentURL.equals(expectedURL) ? "correct URL" : "incorrect URL");

        driver.quit();

    }
}
