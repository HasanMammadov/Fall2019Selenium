package day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);


        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByValue("NY");

        String expexted = "New York";
        String actual = state.getFirstSelectedOption().getText();

        if(expexted.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAIL");
        }









        BrowserUtils.wait(3);


        driver.quit();
    }
}
