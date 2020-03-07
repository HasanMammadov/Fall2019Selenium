package day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice_Login {
    public static void main(String[] args) throws InterruptedException {

       WebDriver driver =  DriverFactory.createDriver("Chrome");
       driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(2000);

        driver.manage().window().maximize();
       Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));

        username.sendKeys("tomsmith");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.id("wooden_spoon"));
        Thread.sleep(2000);
        login.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.className("subheader"));
        String expected= "Welcome to the Secure Area. When you are done click logout below.";
        String actual = message.getText();
        System.out.println(actual);

        if(actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Fail");
        }

        Thread.sleep(2000);

        WebElement logout = driver.findElement(By.linkText("Logout"));
        System.out.println(logout.getAttribute("href"));//http://practice.cybertekschool.com/logout
        System.out.println(logout.getAttribute("class"));//button secondary radius

        logout.click();

        Thread.sleep(2000);

        WebElement negUserName = driver.findElement(By.name("username"));
        negUserName.sendKeys("asdashdhasd");
        Thread.sleep(2000);
        WebElement negEmail = driver.findElement(By.name("password"));
        negEmail.sendKeys("asdas@rambler.ru");
        Thread.sleep(2000);
        WebElement negSignUp = driver.findElement(By.id("wooden_spoon"));
        negSignUp.click();
        Thread.sleep(2000);

        WebElement erormessage = driver.findElement(By.id("flash-messages"));
        System.out.println(erormessage.getText());




        driver.quit();
    }
}
