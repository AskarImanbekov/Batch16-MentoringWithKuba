package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Thread.sleep(1000);

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerSelect = new Select(passengers);
        passengerSelect.selectByValue("4");
        Thread.sleep(1000);

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingFrom1 = new Select(departingFrom);
        departingFrom1.selectByVisibleText("Paris");
        Thread.sleep(1000);

        WebElement dateMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select dateFrom1 = new Select(dateMonth);
        dateFrom1.selectByValue("8");
        Thread.sleep(1000);

        WebElement dateDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dateDay1 = new Select(dateDay);
        dateDay1.selectByValue("15");
        Thread.sleep(1000);

        WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingTo1 = new Select(arrivingTo);
        arrivingTo1.selectByValue("San Francisco");
        Thread.sleep(1000);

        WebElement arrivingMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arrivingMonth1 = new Select(arrivingMonth);
        arrivingMonth1.selectByValue("12");
        Thread.sleep(1000);

        WebElement arrivingDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivingDay1 = new Select(arrivingDay);
        arrivingDay1.selectByValue("15");
        Thread.sleep(1000);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
       Select optionsAirlines =new Select(airlines);
       List<WebElement> actualChoices = optionsAirlines.getOptions();
        List<String> expectedChoices  = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i = 0; i<actualChoices.size();i++ ){
            Assert.assertEquals(actualChoices.get(i).getText().trim(),expectedChoices.get(i));
        }
        Thread.sleep(1000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement actualMessage = driver.findElement(By.xpath("//font[@size='4']"));

        String expectedMessage = "After flight finder - No Seats Available";

        Assert.assertEquals(actualMessage.getText().trim(),expectedMessage.trim());






    }
    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers,"4","value");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(departingFrom,"Paris","value");

        WebElement dateMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(dateMonth,"8","value");

        WebElement dateDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dateDay,"15","value");

        WebElement arrivingTo = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivingTo,"San Francisco","value");

        WebElement arrivingMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
       BrowserUtils.selectBy(arrivingMonth,"12","value");

        WebElement arrivingDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(arrivingDay,"15","value");

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select optionsAirlines =new Select(airlines);
        List<WebElement> actualChoices = optionsAirlines.getOptions();
        List<String> expectedChoices  = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i = 0; i<actualChoices.size();i++ ){
            Assert.assertEquals(BrowserUtils.getText(actualChoices.get(i)),expectedChoices.get(i));
        }
        Thread.sleep(1000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement actualMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String expectedMessage = "After flight finder - No Seats Available";

        Assert.assertEquals(BrowserUtils.getText(actualMessage),expectedMessage.trim());






    }
}
