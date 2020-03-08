package day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //create a webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide weblement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);

        selectSimpleDropdown.selectByVisibleText("Option 1");


        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectMonth.selectByVisibleText("November");
        selectYear.selectByVisibleText("1985");
        selectDay.selectByVisibleText("15");

        BrowserUtils.wait(2);


        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month:months) {
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtils.wait(1);

        }

        Select selectState = new Select(driver.findElement(By.id("state")));

        selectState.selectByVisibleText("New York");
        BrowserUtils.wait(2);
        //option that is currently selected
        //getFirstSelectedOption() -- returns a webelement, that's why we need to call getText() method
        // getText() retrieves visible text from the webelement
        String selected = selectState.getFirstSelectedOption().getText();

        if(selected.equals("New York")){
            System.out.println("Test passed");
        }else {
            System.out.println("Fail");
        }

        System.out.println();

        List<WebElement> allStates = selectState.getOptions();
        for (WebElement state:allStates) {
            System.out.println(state.getText());
        }












        BrowserUtils.wait(3);

driver.quit();
    }
}
