package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);

        driver.manage().window().maximize();
        // once top frame getdik. frame ID ile tapiram

        driver.switchTo().frame("frame-top");
        // ordan da top frame de olan middle frame gedirk

        driver.switchTo().frame("frame-middle");
        // sonra frame middle olan text print elemet ucun hemin elementi tapib. get text elemeliyik

        WebElement content = driver.findElement(By.id("content"));
        System.out.println(content.getText());
        BrowserUtils.wait(2);


        // indi eger middle dan cixib right frame e getmek istesek once left, middle, right framin oldugu TOP frame
        // qayidiriq. sonra ordan tezeden gedirik right frame. sub frameden bir basa diger subframe gede bilmerik.
        // sub fraemin oldugu parent fraem gedib ordan istediyimiz sub (child) frame e gedirik

        driver.switchTo().parentFrame();// burda middle sub frameden cixiram ve
        // Top adlanan parent frame qayidiram ki diger sub frame olan Right sub frame e gedim.

        driver.switchTo().frame("frame-right");

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        //  left frame getmek ucun yeniden qayidiram parent frame olan Top frame.
        driver.switchTo().parentFrame();// qayitdim parent frame e


        driver.switchTo().frame("frame-left"); // indi gedirem o biri child frame

        WebElement leftFrame = driver.findElement(By.tagName("body"));
        System.out.println(leftFrame.getText());// niye her defe body yaza bilirik tag name kimi?
        //eslinde body tag name uniqe deyil htlm de. ama her frame icinde uniqudi.
        // biz child frame icinde unique tag name tapiriq, frame icinde body uniquedi

        // ve eger men diger parent frame olan buttom frame getmek istesem

        driver.switchTo().defaultContent().switchTo().frame("frame-bottom");
        // qayidiram ana HTML e, defaultContent() metodu ile. ordan da buttom frame ->KswitchTo().frame


        WebElement frameButtom = driver.findElement(By.tagName("body"));
        System.out.println(frameButtom.getText());





















        driver.quit();



    }
}
