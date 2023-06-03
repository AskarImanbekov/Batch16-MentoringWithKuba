package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));

        int count = 0;
        for (WebElement link : allLinks){
            count++;
            System.out.println(link.getText());
        }
        System.out.println("Number of Links : "+count);

        //TASK2
        //Print if the length is equal and more than 12 and count how many

        int count1 = 0;
        for (WebElement link : allLinks){
            if(link.getText().length() >= 12){
                System.out.println(link.getText());
                count1++;
            }
        }
        System.out.println(count1);


    }
}
