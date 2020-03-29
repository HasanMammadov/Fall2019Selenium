package day13;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class DriverTest {
    @Test
    public void googleTest(){
        Driver.getDriver().get("http://google.com");
//        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
//        Driver.closeDriver();
       Driver.getDriver().findElement(By.name("q")).sendKeys("toys", Keys.ENTER);
        Driver.getDriver().quit();
    }
}
