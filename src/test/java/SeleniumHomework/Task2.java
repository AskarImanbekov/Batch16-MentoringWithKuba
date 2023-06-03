package SeleniumHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement logInButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        if (logInButton.isDisplayed() && !logInButton.isSelected()){
            logInButton.click();
        }
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String errorText = error.getText();

        System.out.println(errorText);

        Thread.sleep(3000);
        driver.quit();



    }
}
