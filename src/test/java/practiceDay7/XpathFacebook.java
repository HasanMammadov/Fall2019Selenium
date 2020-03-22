package practiceDay7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class XpathFacebook {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://facebook.com");

                            // X path practice
//        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
//        email.sendKeys("ahahahadahd");
//        BrowserUtils.wait(3);
//        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));////input[@id='pass']
//
//        password.sendKeys("asfasfaasf");
//        BrowserUtils.wait(3);
//         driver.findElement(By.xpath("//input[@value='Log In']")).click();
//        BrowserUtils.wait(2);

                //CSS practice

        driver.findElement(By.cssSelector("[name='email']")).sendKeys("asfafasfasf");
               BrowserUtils.wait(2);

        driver.findElement(By.cssSelector("[name='pass']")).sendKeys("5788ddas");
               BrowserUtils.wait(2);

        driver.findElement(By.cssSelector("[id='loginbutton']")).click();
                BrowserUtils.wait(2);




















        driver.quit();

    }
}
