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

public class LogCallButton {
    private WebDriver driver;
    private  String url = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By userNameBoxBy = By.cssSelector("#prependedInput");
    private By passwordBoxBy = By.cssSelector("#prependedInput2");
    private By submitBy= By.cssSelector("#_submit");
    private By actionsBy= By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By callBy=  By.xpath("//span[@class='title title-level-2' and contains(text(),'Calls')]");



@Test
    public void LogCallButton(){
    Actions actions = new Actions(driver);
    BrowserUtils.wait(4);
    actions.moveToElement(driver.findElement(actionsBy)).perform();
    BrowserUtils.wait(2);

    driver.findElement(callBy).click();
    BrowserUtils.wait(2);

    WebElement logCall = driver.findElement(By.cssSelector("[title='Log call']"));
    BrowserUtils.wait(2);
    Assert.assertTrue(logCall.isDisplayed());
    }






    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
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
