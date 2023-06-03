package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Askar");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Imanbekov");

        Thread.sleep(3000);

        WebElement gender = driver.findElement(By.id("sex-0"));
           gender.click();

        WebElement experience = driver.findElement(By.id("exp-4"));
           experience.click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("12/12/2023");

        WebElement type = driver.findElement(By.id("profession-0"));
        type.click();

        WebElement type1 = driver.findElement(By.id("profession-1"));
        type1.click();

        WebElement type2 = driver.findElement(By.id("tool-2"));
        type2.click();

        WebElement continent = driver.findElement(By.name("continents"));
        continent.sendKeys("North America");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        String url = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";

        System.out.println(url.equals(expectedUrl) ? "passed" : "failed");



















    }
}
