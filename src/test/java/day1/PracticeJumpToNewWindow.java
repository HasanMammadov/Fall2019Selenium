package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class PracticeJumpToNewWindow {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has ID. it calls vindow handle
        // base on handle we can switch

        String oldWindowHandle = driver.getWindowHandle();
        System.out.println("oldWindowHandle = " + oldWindowHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        // metodlara diqqet ele ele. 1ci - .getWindowHandle();
        //2ci - .getWindowHandles();  ikinci cemdedir. S var.
        // ona gore setde save edirik ki, duplicate olmasin. Set interface-NO DUPLICATE
        System.out.println("windowHandles = " + windowHandles);
        System.out.println("before switch "+driver.getCurrentUrl());

        for (String windowID:windowHandles) {// Setin icindeki Windowlar
            if(!windowID.equals(oldWindowHandle)){
                driver.switchTo().window(windowID);
            }
        }
        System.out.println("after switch "+driver.getCurrentUrl());


        driver.close();



    }
}
