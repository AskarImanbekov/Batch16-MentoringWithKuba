package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNG_Practice {

    @Test
    public void successfulLogin(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");

        WebElement loginButton  = driver.findElement(By.xpath("//button[@type='submit']"));
       loginButton.click();

       WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
       if (xButton.isDisplayed() && !xButton.isSelected()) {
           xButton.click();
       }


       String actual = driver.getTitle();
       String expected = "Dashboard";
       Assert.assertEquals(actual, expected);


    }
    @Test
    public void negativeTest(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("dem");

        WebElement loginButton  = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement negativeMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String ActualMessage  = negativeMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";

        Assert.assertEquals(ActualMessage,expectedMessage);



    }
    @Test
    public void catalogDisplay() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");

        WebElement loginButton  = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        if (xButton.isDisplayed() && !xButton.isSelected()) {
            xButton.click();
        }

        WebElement catalogButton = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());

    }
    //AssertFalse(!isSelected)
    //regular loop +1
    //Arrow_Down
    //

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");

        WebElement loginButton  = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        if (xButton.isDisplayed() && !xButton.isSelected()) {
            xButton.click();
        }

        WebElement catalogButton = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i<boxes.size();i++){
            Thread.sleep(1000);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected());
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
    }
    //validate functionality of ProductName which gives the product desending order
    //
    @Test
    public void validationOfProductNameFunctionalityDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("demo");
        Thread.sleep(2000);

        WebElement loginButton  = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        if (xButton.isDisplayed() && !xButton.isSelected()) {
            xButton.click();
        }

        WebElement catalogButton = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalogButton.click();
        Thread.sleep(2000);

        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        /*
        1 - you will click the product name button
        2 - you should create 2 arrayList
        * One will be actualData
        * Another will be expectedData
        3 - For(int = 1)
        store all the name for both of the list
        4 - For expected list --> you will use Collection.sort(expectedList)
        Collections.reverse(expected)
        Assert.equals(actualList,expectedList)
                */
        WebElement productNameLink = driver.findElement(By.xpath("//a[.='Product Name']"));
        productNameLink.click();

        Thread.sleep(2000);

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




    }

}
