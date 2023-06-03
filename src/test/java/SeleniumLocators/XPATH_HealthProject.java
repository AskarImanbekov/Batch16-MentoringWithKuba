package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATH_HealthProject {
    public static void main(String[] args) throws InterruptedException {
         /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

       // WebElement appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //   CSS LOCATOR:
        WebElement makeAppointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppointment.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();


        WebElement hongKong = driver.findElement(By.xpath("//select[@name='facility']"));
        hongKong.sendKeys("Hongkong CURA Healthcare Center");

        WebElement admissionBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        admissionBox.click();

        WebElement medicalBox = driver.findElement(By.xpath("//input[@type='radio']"));
        medicalBox.click();

        WebElement date = driver.findElement(By.xpath("//input[@type='text']"));
        date.sendKeys("05/17/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        comment.sendKeys("Hello i need HELP . My head is hurting from Selenium");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();
        Thread.sleep(2000);

        WebElement textAppointment = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualHeader = textAppointment.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "Incorrect");

        WebElement homePageButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        homePageButton.click();

       String url = driver.getCurrentUrl();
       String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(url.equals(expectedURL) ? "Correct URL" : "Incorrect URL");

        driver.quit();










    }
}
