package practiceDay7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSSselector {
    public static void main(String[] args) {


        WebDriver driver =  DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

     WebElement heading = driver.findElement(By.cssSelector(".h3"));// CSS de dot yeni noqte class in adini gosterir/----<h3 class="h3"
        //<h3 class="h3">Multiple buttons</h3>
        System.out.println(heading.getText());

        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        System.out.println("home = " + home.getText());
        System.out.println(home.getAttribute("href"));// link hemise href atributda olur. yag a olanda

        WebElement button1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        BrowserUtils.wait(2);
        button1.click();
        BrowserUtils.wait(2);//[name='button2']
        WebElement button2 = driver.findElement(By.cssSelector("[name='button2']"));
        button2.click();
        BrowserUtils.wait(2);//[id="button_three"]
        WebElement button3 = driver.findElement(By.cssSelector("[id^='button_']"));// carot sign start with
        // herden elementin evveli sabit qalir sonu deyisir, dynamic Id de meselen
        button3.click();
        BrowserUtils.wait(2);
        WebElement button4 = driver.findElement(By.cssSelector("[onclick='button4()']"));
        button4.click();
        BrowserUtils.wait(2);
        WebElement button5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        button5.click();
        BrowserUtils.wait(2);
        WebElement button6 = driver.findElement(By.cssSelector("#disappearing_button"));
        button6.click();
        BrowserUtils.wait(2);









        driver.quit();
    }
}
