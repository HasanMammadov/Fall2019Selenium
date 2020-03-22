package day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {

    public static String userNameLocator= "//label[text()='Username']/following-sibling::input";
   public static String passWordLocator = "//label[text()='Password']/following-sibling::input";

   public static String loginButton="//button[text()='Login']";




    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath(userNameLocator));
        BrowserUtils.wait(3);

        username.sendKeys("tomsmith");
        BrowserUtils.wait(3);

        WebElement password = driver.findElement(By.xpath(passWordLocator));

        password.sendKeys("SuperSecretPassword");
        BrowserUtils.wait(3);

       driver.findElement(By.xpath(loginButton)).click();







        BrowserUtils.wait(3);

        driver.quit();


    }
}
