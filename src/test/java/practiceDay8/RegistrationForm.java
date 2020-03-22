package practiceDay8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private WebDriver driver;

    private  String url = "http://practice.cybertekschool.com/registration_form";

    private By firstNameBy = By.xpath("//input[@name='firstname']");
    private By lastNameBy = By.xpath("//input[@name='lastname']");
    private By userNameBy = By.name("username");
    private By emailBy = By.xpath("//input[@name='email']");
    private By passwordBy = By.cssSelector("input[name='password']");
    private By phoneBy = By.cssSelector("input[name='phone']");
    private By maleBy = By.cssSelector("input[value='male']");
    private By feMaleBy = By.cssSelector("input[value='Female']");
    private By dateBirthBy = By.cssSelector("input[name='birthday']");
    private By selectBy = By.cssSelector("select[name='department']");




   private By ckbJavaBy = By.xpath("//input[@value='java']");
   private By ckbJscrptBy = By.cssSelector("#inlineCheckbox3");
   private By submitBy = By.cssSelector("#wooden_spoon");




//Well done!
//You've successfully completed registration!


    @Test
    public void registrationForm(){

        driver.findElement(firstNameBy).sendKeys("Hasan");
        driver.findElement(lastNameBy).sendKeys("Mammadov");
        driver.findElement(userNameBy).sendKeys("hasaniko");
        driver.findElement(emailBy).sendKeys("hasan@gmail.com");
        driver.findElement(passwordBy).sendKeys("9876554ggdggsdgsdsds");
        driver.findElement(phoneBy).sendKeys("347-830-0367");
        driver.findElement(maleBy).click();

        driver.findElement(dateBirthBy).sendKeys("11/15/1985");

        Select department = new Select(driver.findElement(By.cssSelector("select[name='department']")));
        department.selectByValue("DA");

        Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        driver.findElement(ckbJavaBy).click();
        driver.findElement(ckbJscrptBy).click();
        driver.findElement(submitBy).click();
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();


        Assert.assertEquals(actual,expected);



    }
@Test
    public void firstNameWarning(){

        driver.findElement(firstNameBy).sendKeys("a");
BrowserUtils.wait(2);
        String expected = "first name must be more than 2 and less than 64 characters long";
WebElement message = driver.findElement(By.cssSelector("[data-bv-result='INVALID'] "));
      String actual=  driver.findElement(By.cssSelector("[data-bv-result='INVALID'] ")).getText();
      Assert.assertTrue(message.isDisplayed());
      Assert.assertEquals(actual,expected);

    }

@Test
    public void firstNameOnlyLetters(){

        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement numbermessage= driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(numbermessage.isDisplayed());


        String actual = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']")).getText();

        String expected = "first name can only consist of alphabetical letters";

        Assert.assertEquals(actual,expected);
    }








    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        BrowserUtils.wait(4);



    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
