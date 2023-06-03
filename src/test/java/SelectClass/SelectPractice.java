package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.ChannelOutboundInvoker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/askarimanbekov/Desktop/Techtorial.html");

        WebElement optionBox = driver.findElement(By.xpath("//select[@name='country']"));

        Select choice = new Select(optionBox);

       String actualDefaultChoice = choice.getFirstSelectedOption().getText().trim();
       String expectedDefaultChoice = "UNITED STATES";

        Assert.assertEquals(actualDefaultChoice,expectedDefaultChoice);

        int counter = 0;
        List<WebElement> listOfCountries = choice.getOptions();
        for (WebElement country : listOfCountries){
            System.out.println(country.getText().trim());
            counter++;



        }
        System.out.println(counter);

        /*
        TASK:
         */

        choice.selectByVisibleText("KYRGYZSTAN ");
        Thread.sleep(2000);
        choice.selectByValue("132");
        Thread.sleep(2000);
        choice.selectByIndex(9);





    }
}
