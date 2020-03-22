package practiceDay10;

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

public class HoverActionClass {

    private WebDriver driver;
    private String url = "http://practice.cybertekschool.com/hovers";

    private Actions actions;
    public By image1By = By.xpath("(//img)[1]");// tag name moterize alib array kimi index yazaraq
    // istediyimiz elementi  tapa bilerik
    public By image2By = By.xpath("(//img)[2]");
    public By image3By = By.xpath("(//img)[3]");



    @Test
public void hover(){


        WebElement img1 = driver.findElement(image1By);
        WebElement img2 = driver.findElement(image2By);
        WebElement img3 = driver.findElement(image3By);


        actions.moveToElement(img1).pause(1000).
                    moveToElement(img2).pause(1000).
                    moveToElement(img3).
                    build().perform();

        actions.moveToElement(img1).perform();
        WebElement text1 =driver.findElement(By.xpath("(//h5)[1]"));

        Assert.assertTrue(text1.isDisplayed());

        actions.moveToElement(img2).perform();
        WebElement text2= driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(text2.isDisplayed());
    }

    @BeforeMethod
    public void setDriver() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        BrowserUtils.wait(2);
        actions = new Actions(driver);
        BrowserUtils.wait(2);


        driver.manage().window().maximize();


    }
    @AfterMethod
    public void tearDownn(){
    BrowserUtils.wait(2);
        driver.quit();
    }

}