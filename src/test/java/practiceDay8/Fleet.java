package practiceDay8;

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

public class Fleet {

    private WebDriver driver;
    private String url = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private  By pageNumber = By.xpath("//input[@value='1']");

    @Test
    public void getSubTitle(){
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(4);


        Actions actions = new Actions(driver);// bezi elementler mouse ustune qoyanda visible olur
        // actions class mehc o isi gorur
        // once mouse neyin ustune qoymaq isteyirikse o elementi tapiriq
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]"));
//sonra  moveToElementde onu pramaetr kimi yaziriq//
        actions.moveToElement(fleet).perform();
        driver.findElement(By.linkText("Vehicles")).click();// ve istediyimize click edirik
        BrowserUtils.wait(4);

        String expected= "All Cars";
        String actual =driver.findElement(By.className("oro-subtitle")).getText();
        System.out.println(actual);

        Assert.assertEquals(actual,expected);



//        Actions actions1 = new Actions(driver);
//        actions1.moveToElement(driver.findElement(By.linkText("Vehicle"))).perform();
    }
    @Test
    public void verifyPageNumber(){

       String expected = "1";
       String actual = driver.findElement(pageNumber).getAttribute("value");


       Assert.assertEquals(actual,expected);
    }




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(4);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
