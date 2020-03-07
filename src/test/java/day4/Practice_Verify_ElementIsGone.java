package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice_Verify_ElementIsGone {
    public static void main(String[] args) throws  Exception {

        // how to check element doesnt exist any more in collection
 // * how to check if element doesn't exists any more in th DOM (Document Object Model (that HTML code in the bowser))
// tamamile yox olmaqdan soz gedir. hide yox, deleted


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.id("disappearing_button"));
        if(list.size()==0)// bele de yaza bilerik


        if(driver.findElements(By.id("disappearing_button")).size()==0){//bura diqqet/ elemetsssss. S
            // list return edir. ve biz list size yoxlaya bilirik
            System.out.println("Test passed. Element doesn't exist any more");
        }else {
            System.out.println("Test Failed");
        }
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        // eyni tad name i List de sotore edirik

        for (WebElement button: buttons) {// bir bir buttonlari cagirib click edirik

            button.click();
            Thread.sleep(2000);

        }







driver.quit();

    }
}
