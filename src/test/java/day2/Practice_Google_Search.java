package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Google_Search {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();



        driver.get("http://google.com");
        Thread.sleep(3000);
      //  WebElement search =driver.findElement(By.name("q"));
        // hemise Webelement yaratmalisan

        WebElement search = driver.findElement(By.name("q"));
        //burda deyirik ki search bolmesine get
        // ve Keys.ENTER  click edir automatic

        search.sendKeys("Baku", Keys.ENTER);
        // ve ora Java sozunu  yaz deyirsen  ve enter bas deyirse

        Thread.sleep(3000);

        WebElement news = driver.findElement(By.linkText("News"));
        news.click();// News button click edir
        Thread.sleep(3000);


//        WebElement - every object on the page can be represented by webelement. To find any element you need a locator. There are 8 locators, we just used 1: name.
//        Syntax to find element:
//        WebElement element = driver.findElement(By.name("value"));
//        to enter text:
//        element.sendKeys()
//        To click:
//        element.click()
//        to press enter button
//        element.sendKeys(Keys.ENTER)







        driver.quit();

    }
}
