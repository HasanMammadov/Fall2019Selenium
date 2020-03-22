package practiceDay9;

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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DefaultOptions {
    private WebDriver driver;
    private  String url = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By userNameBoxBy = By.cssSelector("#prependedInput");
    private By passwordBoxBy = By.cssSelector("#prependedInput2");
    private By submitBy= By.cssSelector("#_submit");
    private By actvities = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendar = By.linkText("Calendar Events");
    private By creatCalendarEvetBy = By.cssSelector("[title='Create Calendar event']");
    private By currectUserBy = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Pearl Wuckert')]");
    private By ownerBy = By.cssSelector("#oro_calendar_event_form_calendar-el");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]'");
    private By startDate = By.cssSelector("[id*=date_selector_oro_calendar_event_form_start]");
    private By startTime = By.cssSelector("[id*=time_selector_oro_calendar_event_form_star]");






    @Test
    public void defaultOptions(){
        Actions actions= new Actions(driver);
        BrowserUtils.wait(4);
        actions.moveToElement(driver.findElement(actvities)).perform();
        BrowserUtils.wait(3);
        driver.findElement(calendar).click();
        BrowserUtils.wait(3);
        driver.findElement(creatCalendarEvetBy).click();
        BrowserUtils.wait(3);

        String curretUser= driver.findElement(currectUserBy).getText().trim();
        String ownerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(curretUser,ownerName);
        WebElement title = driver.findElement(titleBy);

        Assert.assertTrue(title.getAttribute("value").isEmpty());// bu yerine diqqet ele, Title bos olmalidi defaukt olaraq
        // ona gore get attribute edirik, value ile. sonra isEmpty

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));//bu sistemden gelir
        String actualDate = driver.findElement(startDate).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));// bu saat sistemden gelir. bunu vermelidir,
        // hazirki esas vaxt budur. h - saat- mm. deqiqeler a AM PM ucun
        String actualTime = driver.findElement(startTime).getAttribute("value");// bu ise app dan olan vaxti verir

        Assert.assertEquals(expectedTime,actualTime);// time zona gore deyismelidir. bug

    }


   @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(userNameBoxBy).sendKeys(username);
        driver.findElement(passwordBoxBy).sendKeys(password+ Keys.ENTER);

    }
    @AfterMethod
    public void quit(){
       driver.quit();
    }
}
