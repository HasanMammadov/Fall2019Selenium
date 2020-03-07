package day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Find_Elements {
    public static void main(String[] args) throws InterruptedException {

//
//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");// metodla creat edirik
        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.name("full_name"));// gedirk input boxa
        Thread.sleep(2000);
        fullName.sendKeys("Hasan Mammadov");//bu adi ora yaziriq
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("hasan@gmail.com");

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";//bu text cixmalidi

        WebElement message = driver.findElement(By.className("subheader"));// once meesage web elemet yardiriq class atributa gore

        String actual = message.getText();
        // sonra bu metodla elemetin visible texti  return  edirik. qara reng de olan user gorduyu textdir
        System.out.println(actual);


        if(actual.equals(expected)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }














        driver.quit();












    }

}
