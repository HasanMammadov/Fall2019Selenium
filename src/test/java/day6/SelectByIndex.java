package day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        Select selectState = new Select(driver.findElement(By.id("state")));

        selectState.selectByIndex(33);


        BrowserUtils.wait(3);
        List<WebElement> stateLst = selectState.getOptions();
        int count = 0;
        for (WebElement eachState: stateLst) {
            count++;
            System.out.println( count + " = " +eachState.getText());
        }















        driver.quit();
    }
}
