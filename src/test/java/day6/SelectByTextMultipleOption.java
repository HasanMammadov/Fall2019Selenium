package day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOption {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));

        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");
        System.out.println("======================================================");
        List<WebElement> ListSelectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage : ListSelectedLanguages) {
            System.out.println(selectedLanguage.getText());

        }
            languagesSelect.deselectByVisibleText("Java");
            BrowserUtils.wait(3);
            languagesSelect.deselectAll();


            BrowserUtils.wait(3);

            driver.quit();

    }
}
