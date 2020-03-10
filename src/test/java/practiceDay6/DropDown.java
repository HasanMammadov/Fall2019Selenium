package practiceDay6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        Select option = new Select(driver.findElement(By.id("dropdown")));
        BrowserUtils.wait(2);

        option.selectByVisibleText("Option 1");

        List<WebElement> options = option.getOptions();


        BrowserUtils.wait(2);


//        driver.get("http://amazon.com");
//        driver.manage().window().maximize();
//
//        Select amazon = new Select(driver.findElement(By.id("searchDropdownBox")));
//        BrowserUtils.wait(2);
//
//        amazon.selectByVisibleText("Audible Books & Originals");
//        BrowserUtils.wait(2);
//        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//        search.sendKeys("james taylor", Keys.ENTER);
//        BrowserUtils.wait(2);


        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1985");
        BrowserUtils.wait(2);
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("November");
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByVisibleText("15");
        BrowserUtils.wait(2);


        List<WebElement> months = month.getOptions();// dropDownda olan butun optionlari burda store edirik

        for (WebElement eachMonth:months) {   //january,february,March
           month.selectByVisibleText(    eachMonth.getText()   );
            //BrowserUtils.wait(1);
            System.out.println(eachMonth.getText());

        }





        Select state = new Select(driver.findElement(By.id("state")));// select elementi tapiriq

        state.selectByVisibleText("New York");
       // System.out.println(state.getFirstSelectedOption().getText()); bir basa yazmaq

        String selectedState = state.getFirstSelectedOption().getText();
        System.out.println("selectedState = " + selectedState);

        if (selectedState.equals("New York")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test Fail");
        }

        BrowserUtils.wait(2);




        List<WebElement> states = state.getOptions();

        for (WebElement eachState:states) {

            System.out.println(eachState.getText());

        }















        driver.quit();
    }
}
