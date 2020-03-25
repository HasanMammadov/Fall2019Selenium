package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait2 {
    private WebDriver driver;

    @Test(description = "Explicit wait practice")
    public void test(){
        driver.get("http://practice.cybertekschool.com/");
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement userName = driver.findElement(By.cssSelector("[type='username']"));
        WebElement password = driver.findElement(By.cssSelector("#pwd"));
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));

        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submit)).click();

        WebElement actual = driver.findElement(By.cssSelector("[id='flash']"));
        String actualResult  = actual.getText();
        actualResult=actualResult.substring(0,actualResult.indexOf("\n"));


        String expected = " You logged into a secure area!".trim();

        Assert.assertEquals(actualResult,expected);

        WebElement subheader = driver.findElement(By.tagName("h4"));
        String actualSub = subheader.getText();
        String expectedSub = "Welcome to the Secure Area. When you are done click logout below.";


        Assert.assertEquals(actualSub,expectedSub);

    }
    @Test
    public void elementClickAble(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));

        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));// bu element itine kimi gozle
        // bu mane olur. bu element invisible olandan sonra click ede bilirk

        submit.click();

        // bu elementin yerine basqa element clcik edir. asagida Exceptionu oxu.
       // org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <button type="submit"
        // class="btn btn-primary">...</button> is not clickable at point (218, 481).
        // Other element would receive the click: <div class="loadingoverlay" style="box-sizing:---->> buna diqqet.
        // bu element  bize mane olur. gerek gozleyek, bu invisble olun ki, submite click ede bilek
        // border-box; position: fixed; display: flex; flex-flow: column nowrap; align-items: center;
        // justify-content: space-around; background: rgba(255, 255, 255, 0.8); top: 0px; left:
        // 0px; width: 100%; height: 100%; z-index: 2147483647; opacity: 1;">...</div>


                WebElement subheader = driver.findElement(By.tagName("h4"));
        String actualSub = subheader.getText();
        String expectedSub = "Welcome to the Secure Area. When you are done click logout below.";


        Assert.assertEquals(actualSub,expectedSub);

    }






    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }
