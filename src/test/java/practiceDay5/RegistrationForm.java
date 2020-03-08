package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        driver.findElement(By.name("firstname")).sendKeys("Hasan");
        driver.findElement(By.name("lastname")).sendKeys("Mammadov");
        driver.findElement(By.name("username")).sendKeys("HuseynAbulfaz");
        driver.findElement(By.name("email")).sendKeys("hasan@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.name("phone")).sendKeys("900-000-0367");

        List<WebElement> gender = driver.findElements(By.name("gender"));
        gender.get(0).click();

        driver.findElement(By.name("birthday")).sendKeys("11/15/1985");




        driver.findElement(By.id("inlineCheckbox1")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(2);

        //validate part

        String expextedHeader = "Well done!";
        String expextedText = "You've successfully completed registration!";

        WebElement header = driver.findElement(By.tagName("h4"));
        String actual = header.getText();
        System.out.println(actual);

        WebElement text = driver.findElement(By.tagName("p"));
        String actualText = text.getText();
        System.out.println(actualText);

        if(header.getText().equals(expextedHeader)&&text.getText().equals(expextedText)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test fail");
        }





driver.quit();
    }
}
