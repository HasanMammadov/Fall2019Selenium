package practiceDay9;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarEvent {

    private WebDriver driver;
    private  String url = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By userNameBoxBy = By.cssSelector("#prependedInput");
    private By passwordBoxBy = By.cssSelector("#prependedInput2");
    private By submitBy= By.cssSelector("#_submit");
    private By activities = By.xpath("//span[@class='title title-level-1' and contains(text(),' Activities')]");
    private By calendarBy = By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]");
    @Test
    public void calendarEvent(){
        Actions actions = new Actions(driver);
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(activities)).perform();
        BrowserUtils.wait(3);
        driver.findElement(calendarBy).click();
        BrowserUtils.wait(3);

        WebElement calendarEvent = driver.findElement(By.cssSelector("[title='Create Calendar event']"));

        Assert.assertTrue(calendarEvent.isDisplayed());

    }



   @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(userNameBoxBy).sendKeys(username);
        driver.findElement(passwordBoxBy).sendKeys(password);
        driver.findElement(submitBy).click();
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }
}
