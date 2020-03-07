package officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("search_query_top"));

        search.sendKeys("tshort", Keys.ENTER);
        Thread.sleep(2000);

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        search = driver.findElement(By.id("search_query_top"));
        search.clear();



        String errorText = error.getText();
        System.out.println(errorText);



        search.sendKeys("t-short",Keys.ENTER);
        Thread.sleep(2000);

        WebElement count = driver.findElement(By.className("product-count"));





        driver.quit();
    }
}
