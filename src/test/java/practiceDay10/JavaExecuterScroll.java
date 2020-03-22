package practiceDay10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaExecuterScroll {
    private RemoteWebDriver driver;


@Test
public void Scroll(){
    driver.get("http://practice.cybertekschool.com/infinite_scroll");
    driver.manage().window().maximize();

    for (int i = 1; i <11 ; i++) {
        driver.executeScript("window.scrollBy(0, 250)");
        BrowserUtils.wait(1);
    }

}
@Test
public void scroolTillSpesificElement(){
    driver.get("http://practice.cybertekschool.com");
    driver.manage().window().maximize();
    WebElement link = driver.findElement(By.linkText("Cybertek School"));
    BrowserUtils.wait(2);

    driver.executeScript("arguments[0].scrollIntoView(true)", link);
    BrowserUtils.wait(2);



}

    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
