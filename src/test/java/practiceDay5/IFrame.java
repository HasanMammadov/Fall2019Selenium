package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        // STEP 1
// once frame icine giririk. elementi tapmadan once.
        driver.switchTo().frame("mce_0_ifr"); //frame adini string kimi yaz  switchTo.frame(bura yaz)

        // STEP 2
        WebElement text = driver.findElement(By.id("tinymce"));
        // id unique olsada NoSuchElementException verdi.
        // cunki iFrame deki texti oxumaq ucun once gerek iFrame icine giresen
        System.out.println(text.getText());

        // texti deyismek ucun once silirik.
        text.clear();
        BrowserUtils.wait(2);
        //sonra  custom text elave edirik
        text.sendKeys("Hello world demekden yoruldum ");
        BrowserUtils.wait(2);
// biz hele de frame in icindeyik. burdan cixsaq ne texti sile bilerik, nede custom tex yaza bilerik


// framedec cixmaq ucun
        driver.switchTo().defaultContent(); // ana HTML e qayidir

// eger switchTo().defaultContent() elemesem, frameden cixa bilmirem, ve ana HTML deki elementi tapa bilmirem
        WebElement textOutOfFrame = driver.findElement(By.tagName("h3"));//line 37 olmasa bunu tapa bilmir
        System.out.println(textOutOfFrame.getText());


        driver.quit();
    }
}
