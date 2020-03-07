package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Day2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        // we setting up our browser
        // then we need creat web driver object
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");// opens web site

        driver.manage().window().maximize();

        Thread.sleep(3000);
        String title = driver.getTitle();// get title web site in title return edir
        System.out.println("Title is " + title);


        String expectedTitle ="Google";

        if(driver.getTitle().equalsIgnoreCase(title)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);


        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Failed");
        }
        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(driver.getTitle(),"Google");

        driver.navigate().forward();
        driver.navigate().refresh();
        System.out.println("current url "+driver.getCurrentUrl());
        Thread.sleep(3000);
        System.out.println("Title is  " + driver.getTitle());





        driver.close();
     //   driver.quit();// umumi browserden cixir





    }


    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }
}
