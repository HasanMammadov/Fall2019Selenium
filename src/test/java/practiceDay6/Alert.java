package practiceDay6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alert {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        System.out.println("=====================TEST CLICK OK ===============================");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();// elementi tapdin, click eledin.
        System.out.println("OK alert text: " +driver.switchTo().alert().getText());// alert handle elemeden once get text ele,
        // sonra text itir. handle edenden sonra alerle birge text de gedir

        driver.switchTo().alert().accept();//sonra mutleq alert handel elemelisen OK basir

        WebElement result = driver.findElement(By.id("result"));
        String actual = result.getText();

        String expected = "You successfully clicked an alert";
        if(actual.equals(expected)){
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            System.out.println("actual = " + actual);
            System.out.println("expected = " + expected);//bug found. typo on word successfully
        }


//
//        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
//        jsAlert.click();
  //      BrowserUtils.wait(2);
        System.out.println("=====================TEST CANCEL ===============================");

        buttons.get(1).click();
        System.out.println("cancel alert text: "+driver.switchTo().alert().getText());// handle elemeden once alert textin print edirem
        driver.switchTo().alert().dismiss();
       BrowserUtils.wait(1);
      WebElement cancel = driver.findElement(By.id("result"));
      String cancelActual = cancel.getText();
      String cancelExpected = "You clicked: Cancel";

      if(cancelActual.equals(cancelExpected)){
          System.out.println("Test Passed");
          System.out.println("cancelActual = " + cancelActual);
          System.out.println("cancelExpected = " + cancelExpected);
      }else {
          System.out.println("cancelActual = " + cancelActual);
          System.out.println("cancelExpected = " + cancelExpected);
          System.out.println("Test Failed");
      }

        System.out.println("=====================TEST ENTER TEXT ===============================");

        WebElement enterTextAlert = driver.findElement(By.id("result"));

        buttons.get(2).click();
       driver.switchTo().alert().sendKeys("Hello");// text daxil eledim
       BrowserUtils.wait(2);
        driver.switchTo().alert().accept();// ok click eledim

       String expectedText = "You entered: Hello";
       String actualText = enterTextAlert.getText();

       if(expectedText.equals(actualText)){
           System.out.println("Test pass");
           System.out.println("actualText = " + actualText);
          System.out.println("expectedText = " + expectedText);
       }else {
           System.out.println("Test Failed");
           System.out.println("actualText = " + actualText);
           System.out.println("expectedText = " + expectedText);


       }






        //       driver.switchTo().alert().accept();



        BrowserUtils.wait(1);


driver.quit();
    }
}
