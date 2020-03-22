package practiceDay10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
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

public class dragAndDrop {

    private WebDriver driver;
    private String url = "http://practice.cybertekschool.com/jqueryui/menu";
    private Actions actions;
    private By enabledBy = By.id("ui-id-3");
    private By downloadBy = By.id("ui-id-4");
    private By pdfBy =By.id("ui-id-5");


    @Test
    public void Jquery(){

        driver.get(url);

        actions = new Actions(driver);
        WebElement enabled = driver.findElement(enabledBy);
        WebElement dowload = driver.findElement(downloadBy);
        WebElement pdf = driver.findElement(pdfBy);
        actions.moveToElement(enabled).
                pause(2000).
                moveToElement(dowload).
                pause(2000).
                moveToElement(pdf).pause(2000).click().
                build().perform();
        BrowserUtils.wait(2);
    }

    @Test
    public void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.cssSelector("[title='Accept Cookies']")).click();
Actions actions1 = new Actions(driver);
        BrowserUtils.wait(3);

        WebElement big = driver.findElement(By.id("droptarget"));
        WebElement small = driver.findElement(By.id("draggable"));

        actions1.dragAndDrop(small,big).perform();

        String expected = "You did great!";
        String actual = big.getText();

        Assert.assertEquals(expected,actual);


    }



    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
