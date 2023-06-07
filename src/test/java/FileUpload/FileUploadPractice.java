package FileUpload;

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

public class FileUploadPractice {

    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/askarimanbekov/Downloads/usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector(".button"));
        uploadButton.click();
        WebElement containsMessage = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertTrue(BrowserUtils.getText(containsMessage).equals("usa.png"));


    }
    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement sendFile = driver.findElement(By.cssSelector("#uploadfile_0"));
        sendFile.sendKeys("/Users/askarimanbekov/Downloads/usa.png");
        WebElement selectFileMessage = driver.findElement(By.xpath("//b[contains(text(),'Select file to send')]"));
        String actualMessage = BrowserUtils.getText(selectFileMessage);
        String expectedMessage = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement termsButton = driver.findElement(By.cssSelector(".field_check"));
       if (termsButton.isDisplayed() && !termsButton.isSelected() && termsButton.isEnabled()){
           termsButton.click();
       }

        WebElement submitFileButton = driver.findElement(By.xpath("//button[@name='send']"));
        submitFileButton.click();

        Thread.sleep(2000);

        WebElement lastMessage = driver.findElement(By.xpath("//div//h3"));
        String actualMessageLast = BrowserUtils.getText(lastMessage);
        String expectedMessageLast ="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessageLast,expectedMessageLast);



    }
}
