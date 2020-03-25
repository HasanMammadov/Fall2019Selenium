package day12;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WarmUp {

    private WebDriver driver;
/**
 * Go to http://practice.cybertekschool.com/tables
 * Click on "Last name" column name
 * Verify that table is sorted by last name in alphabetic order.
 *
 * The Java String compareTo() method is used for comparing two strings lexicographically.
 * Each character of both the strings is converted into a Unicode value for comparison.
 * If both the strings are equal then this method returns 0 else it returns positive or negative value.
 * The result is positive if the first string is lexicographically greater than
 * the second string else the result would be negative.
 *
 *  This method is coming from Comparable interface.
 *  If you want ot be able to sort collection of some class
 *  you need to implement this interface
 *  and override compareTo method
 *
 "a".compareTo("b") = -1
 61 - 62 = -1
 a is before b
 "a".compareTo("a")
 61 - 61 = 0
 0 means 2 strings are equals

*/
    @Test
    public void sortedTable(){

        driver.findElement(By.xpath("//table[1]//th[1]")).click();
        List<WebElement> columns = driver.findElements(By.xpath("//table[1]//tr//td[1]"));


        for (int i = 0; i <columns.size()-1 ; i++) {
            String value = columns.get(i).getText();// columdaki birinci ad
            String nextValue =columns.get(i+1).getText();//columdaki novbeti ad
            //Ascii table gore muqayise edeceyik. sert budur ki -1 olsa demeli sort olub
            // Adlarin bas herfini goturur. Deyek Ki Batch and Convar.
            // B -65 di. C 66. ABCDE -ederlerde artir. 65,66,67. eger faktikinin  ozunden soraki ile cixma emeliayti -1 birdise
            // demeli sort olub. B 65. C 66.  65-65 =-1

            // Bunun ucun CompareTo metodunudan istifade edirik. Iki stringi yoxlamaq ucun


            Assert.assertTrue(value.compareTo(nextValue)<=0);// ikisinin muqayisenden alinan netice -1 dirse sort olub

        }



// for (int i = 0; i < column.size() - 1; i++) {
//            //take a string
//            String value = column.get(i).getText();
//            //take a following string
//            String nextValue = column.get(i + 1).getText();
//
//            System.out.println(value.compareTo(nextValue));
//
//            //if difference is negative - order value is before nextValue in alphabetic order
//            //if difference is positive - order value is after nextValue in alphabetic order
//            //if difference is 0 - value and nextValue are equals
//            Assert.assertTrue(value.compareTo(nextValue) <= 0);








//        List<String> expected = new ArrayList<>();
//        expected.add("Bach");
//        expected.add("Conway");
//        expected.add("Doe");
//        expected.add("Smith");
//
//       List<String> sorted = new ArrayList<>();
//        for (int i = 0; i <names.size() ; i++) {
//            sorted.add(names.get(i).getText());
//        }
//        System.out.println(sorted);
//Assert.assertEquals(expected,sorted);


    }




    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
