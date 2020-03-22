package day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest {


    private WebDriver driver;//

@Test
    public void login(){
    driver.findElement(By.linkText("Form Authentication")).click();
    BrowserUtils.wait(3);

    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");
    driver.findElement(By.id("wooden_spoon")).click();
    BrowserUtils.wait(3);

   WebElement subheader= driver.findElement(By.tagName("h4"));
   String actual = subheader.getText();
   String expected = "Welcome to the Secure Area. When you are done click logout below.";

    System.out.println("expected = " + expected);
    System.out.println("actual = " + actual);
            Assert.assertEquals(actual,expected,"Sub-header message is not matching");


    }

    @Test
    public void forgetPassword(){
    driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("email")).sendKeys("hasan@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@id='form_submit']")).click();
        String expected = "Your e-mail's been sent!";
        String actual =driver.findElement(By.tagName("h4")).getText();
        System.out.println(actual);
         Assert.assertEquals(expected,actual);



    }
@Test
    public void checkBox(){
    driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());//


    }







    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();

         driver= new ChromeDriver();

         driver.get("http://practice.cybertekschool.com/");
         driver.manage().window().maximize();
        BrowserUtils.wait(3);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
