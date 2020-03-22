package practiceDay6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Rahul {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        driver.findElement(By.cssSelector("[id='username']")).sendKeys("sfdsdfds");//[id='password']
        BrowserUtils.wait(2);

        driver.findElement(By.cssSelector("[id='password']")).sendKeys("sfdsdfds");//[id='password']
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        BrowserUtils.wait(2);






        driver.findElement(By.cssSelector("#error"));
      WebElement error =  driver.findElement(By.cssSelector("#error"));
        System.out.println("error.getText() = " + error.getText());
//
//        System.out.println(driver.getCurrentUrl());
//       // System.out.println(driver.getPageSource());
//        driver.get("http://yahoo.com");
//       // driver.navigate().back();
//        BrowserUtils.wait(4);

//

















        driver.quit();

    }
}
