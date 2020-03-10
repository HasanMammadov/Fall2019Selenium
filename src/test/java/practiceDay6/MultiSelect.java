package practiceDay6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelect {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        Select languages = new Select(driver.findElement(By.name("Languages")));
        System.out.println(languages.isMultiple());//eyni vaxtda bir nece option sece bilerem? if true yes. if false no


        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");
        BrowserUtils.wait(2);


//  DIQQET. bu listde hamisini save etmek ucun gerek hamisi vsisble olsun. oda nece visible olur?
      //  select etmekle. once gerek hamisi select olsun
        // get all selected, adindan gorunduyu kimi, ancaq select etdiyin optionlari return edir
        List<WebElement> allLanguages = languages.getAllSelectedOptions();
        for (WebElement eachlanguage: allLanguages) {
            System.out.println(eachlanguage.getText());

        }

        languages.deselectByVisibleText("Java");

        BrowserUtils.wait(2);
        languages.deselectAll();// unselect all
        BrowserUtils.wait(2);








        driver.quit();


    }
}
