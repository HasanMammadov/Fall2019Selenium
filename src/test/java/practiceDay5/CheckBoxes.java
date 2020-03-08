package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //check box da unique atribut olmadigina gore tag name gore tapib listde save edirik. sonra indexe gore
        // click edecyik ve ya qus qoyacayiq))

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        //checkBoxes.get(0).click();

     //   checkBoxes.get(1).click();
        BrowserUtils.wait(2);

        for (int i = 0; i <checkBoxes.size() ; i++) {
            if(checkBoxes.get(i).isEnabled()&&checkBoxes.get(i).isDisplayed()&& ! checkBoxes.get(i).isSelected()){// eger secilmiyibse
                BrowserUtils.wait(2);

                checkBoxes.get(i).click(); // check ele.
                System.out.println(i+1+" checkbox is clicked");

                BrowserUtils.wait(2);
            }else {
                System.out.println(i+1+" checkbox wasn't clicked");
            }

        }








driver.quit();

    }
}
