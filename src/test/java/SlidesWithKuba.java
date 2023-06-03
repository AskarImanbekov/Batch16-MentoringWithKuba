import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SlidesWithKuba {
    @Test
    public void slideButton(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        driver.findElement(By.xpath("//a[.='Drag & Drop Sliders']")).click();

        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@class='sp__range']"));
        List<WebElement> allValues = driver.findElements(By.cssSelector("output"));
        Actions actions = new Actions(driver);
        for (int i = 0; i<allSliders.size();i++){
            while (!allValues.get(i).getText().trim().equals("99")){
                if (allValues.get(i).getText().equals("99")){
                    break;
                }else {
                    allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }


    }
}
