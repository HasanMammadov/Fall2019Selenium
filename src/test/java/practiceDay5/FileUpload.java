package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/upload");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //choose file duymesini , elementini tapdiq
        BrowserUtils.wait(2);

        String filePath ="/Users/hasanmammadov/Desktop/day to day activity.docx";//bu bizim upload etmek istediyimiz fail in adresidi
        chooseFile.sendKeys(filePath);// send keys ile hemin file arg kimi yaziriq
        BrowserUtils.wait(2);


        WebElement upload = driver.findElement(By.id("file-submit"));
        // sonra upload duymesine click edirik
        BrowserUtils.wait(2);
        upload.click();
        BrowserUtils.wait(2);

        // her hansi senedin path name - adresini copy etmek isteyirsense Macda,
        // option duymesini bas saxla, orda copy pathNAme cixacaq
        ///Users/hasanmammadov/IdeaProjects/Fall2019Selenium/pom.xml











        driver.quit();
    }
}
