package practiceDay5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);

        //verify that 1st box is not selected, 2nd box is selected

        //1 find checkboxes and store in list

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));


        System.out.println("1st checkBox is selected: " + checkBoxes.get(0).isSelected());
        System.out.println("2nd checkBox is selected: " + checkBoxes.get(1).isSelected());

        if(!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test failed");

        }
// click on fisr box
        checkBoxes.get(0).click();

        if(checkBoxes.get(0).isSelected()){
            System.out.println("1st checkBox is  checked");
            System.out.println("Test Passed");

        }else {
            System.out.println("1st checkBox is NOT  checked");
            System.out.println("FAIL");
        }


driver.quit();
    }
}
