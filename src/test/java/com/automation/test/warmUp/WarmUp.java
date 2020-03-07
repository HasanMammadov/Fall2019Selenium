package com.automation.test.warmUp;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {
    public static void main(String[] args) throws InterruptedException {


//ebayTest();
//amazonTest();
wikiTest();



    }

    public static void ebayTest () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new  ChromeDriver();

        driver.get("http://ebay.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement input = driver.findElement(By.id("gh-ac"));
        Thread.sleep(2000);

        input.sendKeys("I phone x", Keys.ENTER);
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.tagName("h1"));
        String text = result.getText();
        System.out.println(text);










        driver.quit();

    }

public static void amazonTest() throws InterruptedException {
    WebDriver driver = DriverFactory.createDriver("chrome");
//go to amazon
//enter search term
//click on search button
//verify title contains search term
    driver.get("http://amazon.com");

    WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
    Thread.sleep(2000);
    search.sendKeys("Java book",Keys.ENTER);
    Thread.sleep(2000);
    String title = driver.getTitle();
    System.out.println(title);

    if(title.contains("Java book")){
        System.out.println("Pass");
    }else {
        System.out.println("fail");
    }
    driver.quit();

}
public static void wikiTest() throws InterruptedException {
        //Go to wikipedia.org
    //enter search term `selenium webdriver`
    //click on search button
    //click on search result `Selenium (software)`
    //verify url ends with `Selenium_(software)`
    WebDriver driver = DriverFactory.createDriver("chrome");
    driver.get("http://wikipedia.com");
    driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
    driver.findElement(By.partialLinkText("(software)")).click();
    Thread.sleep(3000);
    String url = driver.getCurrentUrl();
    System.out.println(url);
    if(url.endsWith("Selenium_(software)")){
        System.out.println("Test Passed");
    }else {
        System.out.println("Test Failed");
    }
    driver.quit();


}
}
