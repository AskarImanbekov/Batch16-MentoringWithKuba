package SeleniumHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName  = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("John Kennedy");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("john@email.com");

        WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("5700 N Campbell Ave");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("2870 E 12 st");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
       if (button.isDisplayed() && !button.isSelected()){
           button.click();
       }

       WebElement Name1 = driver.findElement(By.xpath("//p[@id='name']"));
       String actualName = Name1.getText();
       String expectedName = "Name:John Kennedy";
       System.out.println(actualName.equals(expectedName) ? "correct":"incorrect");

        WebElement Email1 = driver.findElement(By.xpath("//p[@id='email']"));
        String actualEmail = Email1.getText();
        String expectedEmail = "Email:john@email.com";
        System.out.println(actualEmail.equals(expectedEmail) ? "correct" : "incorrect");

        WebElement Address1 = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualAddress = Address1.getText();
        String expectedAddress = "Current Address :5700 N Campbell Ave";
        System.out.println(actualAddress.equals(expectedAddress) ? "correct" : "incorrect");

        WebElement PerAddress1 = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualPerAddress = PerAddress1.getText();
        String expectedPerAddress = "Permananet Address :2870 E 12 st";
        System.out.println(actualPerAddress.equals(expectedPerAddress) ? "correct" : "incorrect");








    }
}
