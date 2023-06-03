package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOverPractice {

    @Test
    public void practiceMoveToElement() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        List<WebElement> foodPictures = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='product k-listview-item']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product k-listview-item']//p"));

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300);

        Map<String , String > results = new HashMap<>();

        for(int i = 0; i < foodPictures.size();i++){

            Thread.sleep(200);

            actions.moveToElement(foodPictures.get(i)).perform();
            results.put(BrowserUtils.getText(names.get(i)), BrowserUtils.getText(prices.get(i)));

        }
        for (Map.Entry<String , String > pair: results.entrySet()){
            System.out.println(pair);
        }

    }
}
