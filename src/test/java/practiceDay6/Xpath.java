package practiceDay6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement button3 = driver.findElement(By.xpath("//button[@onclick='button3()']"));// by attribute
        button3.click();
        System.out.println("you clicked: "+button3.getText());

        BrowserUtils.wait(2);


        WebElement button4 = driver.findElement(By.xpath("//button[text()='Button 4']"));// Xpath by text
        button4.click();
        System.out.println("you clicked: "+button4.getText());
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//button[text()='Button 2']")).click();
        BrowserUtils.wait(2);





////button[text()='Button 2']



        driver.quit();

    }
}
