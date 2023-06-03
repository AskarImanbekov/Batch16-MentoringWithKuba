package SeleniumHomework;

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
import java.util.List;
import java.util.Set;

public class HomeworkAutomation {

    @Test
    public void task1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle  = driver.getTitle();
        String expectedTitle  ="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        String afterLoginTitle = driver.getTitle();
        String expectedAfterLoginTitle ="Web Orders";
        Assert.assertEquals(afterLoginTitle,expectedAfterLoginTitle);

        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
    @Test
    public void task2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        Thread.sleep(2000);
        viewAllProducts.click();

        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader,expectedHeader);

        String currentURL =driver.getCurrentUrl();
        if (currentURL.contains("Products")){
            System.out.println("It contains Products keyword");
        }


    }
    @Test
    public void task3(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        System.out.println(viewAllProducts.getText());



    }
    @Test

    public void task4(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

        WebElement orderType = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(orderType,"ScreenSaver","value");

        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement address = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        address.sendKeys("2200 Devon Ave");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys("60018");
        WebElement cardType = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
       cardType.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement date = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        date.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();
        WebElement orderMessage = driver.findElement(By.xpath("//strong"));
        String actualMessage = orderMessage.getText().trim();
        String expectedMessage = "New order has been successfully added.";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrders.click();

                ////tr[2]//td






    }

}
