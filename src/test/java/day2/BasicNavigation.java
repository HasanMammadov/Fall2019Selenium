package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        // wee need set up web driver and creat web driver object

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
Thread.sleep(3000);

        String title = driver.getTitle();
        String expexted = "Google";
        System.out.println("title = " + title);

        if(expexted.equals(title)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }





        driver.close();



    }
}
