package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void HeadersOfTheCars(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        /*

         */

        WebElement stockType = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(stockType,"new","value");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"lexus","value");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement distanceSearch = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distanceSearch,"40","value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement textInFront = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualText = BrowserUtils.getText(textInFront);
        String expectedText = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualText,expectedText);

        WebElement sortOptions = driver.findElement(By.xpath("//select[@name='sort']"));
        BrowserUtils.selectBy(sortOptions,"list_price","value");

        List<WebElement> lexusRX350 = driver.findElements(By.xpath("//h2[@class='title']"));

        int count = 0;
        for (int i =0 ; i<lexusRX350.size();i++){

            Assert.assertTrue(BrowserUtils.getText(lexusRX350.get(i)).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(lexusRX350.get(i)));

        }

    }
    @Test
    public void priceDescendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        /*

         */

        WebElement stockType = driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(stockType, "new", "value");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "lexus", "value");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");

        WebElement distanceSearch = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distanceSearch, "40", "value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement textInFront = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualText = BrowserUtils.getText(textInFront);
        String expectedText = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(2000);

        WebElement sortOptions = driver.findElement(By.xpath("//select[@name='sort']"));
        BrowserUtils.selectBy(sortOptions, "list_price", "value");
        Thread.sleep(2000);
        List<WebElement> lexusRX350 = driver.findElements(By.xpath("//h2[@class='title']"));

        for (int i = 0; i < lexusRX350.size(); i++) {

            Assert.assertTrue(BrowserUtils.getText(lexusRX350.get(i)).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(lexusRX350.get(i)));
        }

        /*
        List<WebElement> allProducts = driver.findElements(By.xpath("//td[@class='text-start']"));// 11 elements
       List<String> actualProductOrder = new ArrayList<>();
       List<String> expectedProductOrder = new ArrayList<>();
       for (int i = 1 ; i<allProducts.size();i++){
           actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim()); // same order , same item
           expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());// same order , same item

       }
        Collections.sort(expectedProductOrder);
        Collections.reverse(expectedProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder);

        To make the other way around. Collections.reverse(); after sort.

         */
        Thread.sleep(2000);
       List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='primary-price']"));

       List<Integer> actualPrice = new ArrayList<>();
       List<Integer> expectedPrice = new ArrayList<>();

       for (int i = 0; i< allPrices.size();i++){

           actualPrice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
           expectedPrice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
       }
        Collections.sort(actualPrice);
       Assert.assertEquals(actualPrice,expectedPrice);
        System.out.println(actualPrice);
        System.out.println(expectedPrice);


    }
}
