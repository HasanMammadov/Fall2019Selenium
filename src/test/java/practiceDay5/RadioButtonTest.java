package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
       // blackButton.click();

        if(blackButton.isEnabled()&&! blackButton.isSelected()){
            blackButton.click();
            BrowserUtils.wait(2);

            System.out.println(blackButton.getAttribute("id")+ " button is clicked");
        }else {
            System.out.println(blackButton.getAttribute("id")+" button is not clickable");
        }

if(blackButton.isSelected()){
    System.out.println("button is clicked");
}else {
    System.out.println("button not clicked");
}









        driver.quit();
    }
}
