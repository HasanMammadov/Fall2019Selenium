package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;

    private WebDriverWait wait;


    @Test
    public void test(){
driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));

        for (int i = 0; i <checkBoxes.size() ; i++) {
            Assert.assertTrue(checkBoxes.get(i).isSelected());

        }
    }
@Test
    public void updateZipCode(){
        WebElement zipCode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        ////td[text()='Steve Johns']//following-sibling::td[7]--> bu daha yaxsi ve deqiq usuldu
        String expected = "21233";
        String actual = zipCode.getText();

        Assert.assertEquals(expected,actual);
//td[text()='Steve Johns']//following-sibling::td/input   bu daha yaxsi yoldu. deqiqdi
        driver.findElement(By.xpath("//tr[4]//td[13]")).click();


        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipInput.clear();
        zipInput.sendKeys("20002");
        driver.findElement(By.cssSelector("[class='btn_light']")).click();

    WebElement zipCodeNew = driver.findElement(By.xpath("//tr[4]//td[9]"));
    String expectedNew = "20002";
    wait.until(ExpectedConditions.visibilityOf(zipCodeNew));
    String actualNew = zipCodeNew.getText();

    Assert.assertEquals(expectedNew,actualNew);





    }




    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver =new ChromeDriver();
        wait=new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
