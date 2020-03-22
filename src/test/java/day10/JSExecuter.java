package day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter {

    private RemoteWebDriver driver;

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
//        you need to cast if reference type is a WebDriver
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
//        x, y offset
        for (int i=0; i < 10; i++){
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(3);
    }
    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }



    @BeforeMethod
    public void setup(){
        driver = (RemoteWebDriver) DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
