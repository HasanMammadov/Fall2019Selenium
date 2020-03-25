package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {


    private WebDriver driver;


    @Test
    public void waitTest(){

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.xpath("//a[@href='/dynamic_loading/2']")).click();
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        String expected = "Hello World!";

        Assert.assertEquals(expected,hello.getText());

    }


    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
