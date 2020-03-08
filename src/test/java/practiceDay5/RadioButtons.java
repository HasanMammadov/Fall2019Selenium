package practiceDay5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement button:radioButtons) {
            // button clickable oldugu bilmek ucun, yeni avtivdi,
            // basmaq olar. IsEnabled metodundan istifade edirk/ TO CHECK if BUTTON CAN BE CLICKED
            boolean isSelected = button.isSelected();
            System.out.println(button.getAttribute("id" )+" is selected? "+ isSelected);

            if(button.isEnabled()) {
                button.click();// bir bir buttonlara click edirik
                System.out.println(button.getAttribute("id")+" is clicked");
                //BrowserUtils.wait(1);
            }else {
                System.out.println(button.getAttribute("id")+ " can NOT be clicked. Button is disabled");
            }
// bu bize String return edir. Onu String id = button.getAttribute("id") yazib ele de istifade ede bilrik
            System.out.println();

        }
        System.out.println("______________");

        for (WebElement button:radioButtons) {
            if(button.isEnabled()){// eger sikest deyilse))
                System.out.println("button is  clickable: "+button.getAttribute("id"));
            }else {
                System.out.println("button can NOT be clicked: "+button.getAttribute("id"));
            }

        }


//Exception in thread "main" org.openqa.selenium.NoSuchSessionException:
// Session ID is null. Using WebDriver after calling quit()?

        // eger bunu gorsen, bil ki, quit() metodunu hardasa ortalarda cagirmisan. hemise o method axirda olmalidir
        System.out.println();

        System.out.println("IsSeleceted practide");










driver.quit();





    }

}
