package practiceDay11;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> columNames = driver.findElements(By.xpath("//table[@id='table1']//th"));
List<String>names = new ArrayList<>();
        for (WebElement each:columNames) {
            names.add(each.getText());
        }
        System.out.println(names);
    }
    @Test
    public void verifyRowCount(){
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println(rows.size());

        int expected = 4;

        Assert.assertTrue(rows.size()==expected);

      //  Assert.assertEquals(rows.size(),4);

    }

    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
