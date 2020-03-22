package practiceDay8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;
    private  String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
   private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");



@Test(description = " verify message when user input invalid username ")
    public void invalidUsername(){
driver.findElement(By.cssSelector("#prependedInput")).sendKeys("helloo");
    BrowserUtils.wait(3);

    driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);

   // WebElement warning = driver.findElement(By.cssSelector("[class='alert alert-error'] > div"));
    WebElement warning1 = driver.findElement(By.xpath("//div[@class='alert alert-error']/div"));

    String expected = "Invalid user name or password.";
  //  String actual= warning.getText();
   // System.out.println(actual);


    // CSS
   // Assert.assertTrue(warning.isDisplayed());//assert true da web elememnt varible qoyub is displayed mestodunu istifade edirie
  //  Assert.assertEquals(actual,expected);

    String actual1= warning1.getText();

// XPATH
    Assert.assertTrue(warning1.isDisplayed());//assert true da web elememnt varible qoyub is displayed mestodunu istifade edirie
    Assert.assertEquals(actual1,expected);


    }
    @Test(description = "login as a store manager with valid credentials")
    public void loginStoreManager(){

    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password+Keys.ENTER);

    BrowserUtils.wait(7);
    String expected = "Dashboard";

    String actual = driver.getTitle();

        Assert.assertEquals(actual,expected);

    }






    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
