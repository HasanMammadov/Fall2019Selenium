package practiceDay6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement dropdownLink = driver.findElement(By.id("dropdownMenuLink"));
        BrowserUtils.wait(2);

        dropdownLink.click();
        //butun linkleri gormek ucun once onlarin oldugu elemeti tapib ona click etmek lazimdir ki o visible olsun

        BrowserUtils.wait(2);



        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        // classda butun linkler oldugu ucun leist de save edirik

        for (WebElement eachLink:allLinks) {
            BrowserUtils.wait(1);
            System.out.println(eachLink.getText()+" : "+eachLink.getAttribute("href"));

        }



        driver.findElement(By.linkText("Etsy")).click();


        BrowserUtils.wait(2);

//In case of any other drop-down, just click on,wait until options becomes visible and click on that option.
// You need a locator for dropdown and option.







driver.quit();
    }
}
