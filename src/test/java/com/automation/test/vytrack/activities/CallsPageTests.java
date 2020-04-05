package com.automation.test.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {
    private WebDriver driver;
    private Actions actions;

    private  String url = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String username = "storemanager85";
    private String password = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private  By logCallBy = By.cssSelector("[title='Log call']");








    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(4);


    }
    @Test
    public void verifyLogButton(){
      // driver.findElement(logCallBy).click();
        WebElement logCall = driver.findElement(logCallBy);

        Assert.assertTrue(logCall.isDisplayed());
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
