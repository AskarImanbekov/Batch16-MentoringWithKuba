package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");//url
        //Thread.sleep(2000)
        //song.sendKeys(keys.ARROW_DOWN)--> put this inside of loop

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();

        Thread.sleep(2000);

        List<WebElement> namesOfSongs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement songName : namesOfSongs){
            Thread.sleep(2000);
            songName.sendKeys(Keys.ARROW_DOWN);
            if (songName.getAttribute("aria-label").contains("Justin Bieber - Ghost")){
                songName.click();
                break;
            }


        }


    }
}
