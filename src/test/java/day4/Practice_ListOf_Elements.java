package day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice_ListOf_Elements {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link:links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));

        }
//  her link acib baglamagi for each loopla ede bilmirem.cunki home page den baslayir.
//  for each de 0 ci index i skipp ede bilmirik. ona gore for loopda 1 ci indexi verek deye for loop edirik
        for (int i = 1; i <links.size() ; i++) {// home page qayitma. 1 ci linkden basqa
            links.get(i).click();//click edir
            driver.navigate().back();// gri qayidir o biri linke click edir
            links = driver.findElements(By.tagName("a"));//burda yeniden assign edirik. refresh edir
            // eger bu olmasa ->throws a stale element exception
            //

//driver.findElements(By.tagName("a").get(i).click(); bu yuxaridaki ile eyni isi gorur.
// mesele budur ki, her defe sehifeye geri qayidanda web elementin
// reference itir ve onu elementi yeniden tapmaliyiq

   // If WebDriver throws a stale element exception in this case, even though the element still exists, the reference
   //is lost. You should discard the current reference you hold and replace it, possibly by locating the element again
   //once it is attached to the DOM.



        }




driver.quit();
    }
}
