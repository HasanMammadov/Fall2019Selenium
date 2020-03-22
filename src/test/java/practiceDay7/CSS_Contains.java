package practiceDay7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_Contains {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.rediff.com/");
        driver.manage().window().maximize();

        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[title*='Sign in']")).click();//CSS contains istifade eledim
        // star contain demekdi, Attributun hamisini yazmadim/ Sign In hissesini goturdum

        driver.findElement(By.cssSelector("#login1")).sendKeys("xuykinnnn");
        BrowserUtils.wait(2);
      //  driver.findElement(By.cssSelector("#password")).sendKeys("xuykinnnn");//CSS le tapdim password elementi
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("tullan");//Xpathla password elementi
        BrowserUtils.wait(2);
      //  driver.findElement(By.cssSelector("[class='signinbtn']")).click();//Submit CSS le
        driver.findElement(By.xpath("//input[contains(@name,'pro')]")).click();//Xpath

        BrowserUtils.wait(1);




driver.quit();
    }
}
