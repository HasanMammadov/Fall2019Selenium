package day8;

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

import java.util.List;

public class SearchTests {

    private WebDriver driver;


    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");

        driver.findElement(By.cssSelector("[name='q']")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);


       List<WebElement> java =  driver.findElements(By.tagName("h3"));

        for (int i = 0; i <java.size() ; i++) {

          String var = java.get(i).getText();

            if(!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }

        }


    }
    @Test(description = "Search for Java Book on Amazon")
    public void amazonTest(){
      driver.get("http://amazon.com");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("java",Keys.ENTER);
BrowserUtils.wait(3);
      List<WebElement> books = driver.findElements(By.tagName("h2"));
      books.get(0).click();

      WebElement book = driver.findElement(By.xpath("//span[@class='a-size-extra-large']"));
      String title = book.getText();



      Assert.assertTrue(title.toLowerCase().contains("java"));
        System.out.println(title);

        BrowserUtils.wait(2);





    }



    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
