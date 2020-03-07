package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_FindElements {
    public static void main(String[] args) throws InterruptedException {

        ebayTest();
        amazonTest();
        wikiTest();

    }


    public static void ebayTest() throws InterruptedException {
//        Go to ebay
//        enter search term
//        click on search button
//        print number of results

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://ebay.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

       WebElement search =  driver.findElement(By.id("gh-ac"));
       search.sendKeys("Java books", Keys.ENTER);
       WebElement result = driver.findElement(By.tagName("h1"));
        Thread.sleep(2000);

        String text[] = result.getText().split(" ");


        System.out.println(text[0]);

        driver.quit();
    }



    public static void amazonTest() throws InterruptedException {

        //go to amazon
        //enter search term
        //click on search button
        //verify title contains search term

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
Thread.sleep(2000);
        driver.get("http://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Java Books",Keys.ENTER);
        Thread.sleep(2000);


        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);

        if(title.contains("Java Books")){
            System.out.println("Test passed");
        }else {
            System.out.println("failed");
        }


driver.quit();
    }


    public  static void wikiTest() throws InterruptedException {

        //Go to wikipedia.org
        //enter search term `selenium webdriver`
        //click on search button
        //click on search result `Selenium_(software)`
        //verify url ends with `Selenium_(software)`


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://wikipedia.org");
        driver.manage().window().maximize();
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("(software)")).click();

       String url = driver.getCurrentUrl();

       if(url.endsWith("Selenium_(software)")){
           System.out.println("Test passed");
       }else {
           System.out.println("failed");
       }


driver.quit();

    }


}
