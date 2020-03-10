package practiceDay6;

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
        BrowserUtils.wait(2);


        Select state =  new Select(driver.findElement(By.id("state")));
        state.selectByValue("NY");


        String actual = state.getFirstSelectedOption().getText();
        String expected = "New York";
        System.out.println("selected = " + actual);

        if(actual.equals(expected)){
            System.out.println("test passed");
        }else {
            System.out.println("test fail");
        }





        driver.quit();


    }
}
