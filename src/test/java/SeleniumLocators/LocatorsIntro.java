package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //LOCATORS -- is  way to locate(find) elements and manipulate on it
    public static void main(String[] args) {

        // ID LOCATOR :

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/askarimanbekov/Desktop/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();// it gets the text from element
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "Wrong");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        // NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Askar");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Imanbekov");
        WebElement phoneNumber = driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("9176803376");

        //CLASS LOCATOR
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));

        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }

        System.out.println(javaBox.isSelected() ? "selected" : "not selected" );

        WebElement testNG = driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed() && !testNG.isSelected()){
            testNG.click();
        }
        System.out.println(testNG.isSelected() ? "checked" : "not checked");

        //TAG NAME ELEMENT

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());


    }
}
