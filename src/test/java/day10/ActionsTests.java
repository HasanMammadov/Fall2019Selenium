package day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {


    private WebDriver driver;
    private Actions actions;




@Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
    BrowserUtils.wait(3);
    driver.manage().window().maximize();

    WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
    WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
    WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


    actions.moveToElement(img1).
            pause(1000).
            moveToElement(img2).
            pause(1000).
            moveToElement(img3).
            build().perform();

    actions.moveToElement(img1).perform();
    WebElement img1text= driver.findElement(By.xpath("//h5[text()='name: user1']"));
    Assert.assertTrue(img1text.isDisplayed());


    actions.moveToElement(img2).perform();
    WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));

    Assert.assertTrue(imgText2.isDisplayed());
}


@Test
public void jqueryMenuTest(){
    driver.get("http://practice.cybertekschool.com/jqueryui/menu");
    Actions actions = new Actions(driver);
    WebElement enabled = driver.findElement(By.cssSelector("#ui-id-3"));
BrowserUtils.wait(3);
    actions.moveToElement(enabled).perform();
    BrowserUtils.wait(3);

    WebElement downloads = driver.findElement(By.cssSelector("#ui-id-4"));
    BrowserUtils.wait(3);

    actions.moveToElement(downloads).perform();
    BrowserUtils.wait(3);

    driver.findElement(By.linkText("PDF")).click();
    BrowserUtils.wait(3);

}
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies
        driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();

        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        Assert.assertEquals(actual, expected);

    }






    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
