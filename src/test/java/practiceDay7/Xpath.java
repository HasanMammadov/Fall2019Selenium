package practiceDay7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    public static String userName = "//label[text()='Username']//following-sibling::input";
    // sayta gedib baxsan gorsersen ki input ancaq bur atrbute var name, assume oda yoxdu. ama label da butun melumatlar var
    // o halda bir label locator tapiriq, ve ordan jump edirik input sibling e. laale ustde. input altda
    // ona gore following yaziriq. yeni label i follow eden sibling e  jump ele
    public static String password = "//label[text()='Password']/following-sibling::input";
    // burda da eyni mentiqdi




    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath(userName)).sendKeys("tomsmith");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath(password)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();
        BrowserUtils.wait(2);



driver.quit();
    }
}
