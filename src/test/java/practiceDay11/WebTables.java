package practiceDay11;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;


    @Test
    public void test1(){
       // driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> columNames = driver.findElements(By.xpath("//table[@id='table1']//th"));
List<String>names = new ArrayList<>();
        for (WebElement each:columNames) {
            names.add(each.getText());
        }
        System.out.println(names);
    }
    @Test
    public void verifyRowCount(){
      //  driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println(rows.size());

        int expected = 4;

        Assert.assertTrue(rows.size()==expected);

      //  Assert.assertEquals(rows.size(),4);
    }
@Test
    public void WebSiteColumn(){
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tr//td[5]"));

//    for (WebElement eachLink:links) {
//        System.out.println(eachLink.getText());
//
//    }
    System.out.println(BrowserUtils.getTextFromWebElements(links));


}

    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);// bu false olsa adi hemiseki kimi isleyecek
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        // headless daha suretlidir. browser acmir.  her sey elemek olur, sadece file upload dan basqa

        driver.manage().window().maximize();
        BrowserUtils.wait(3);

    }

    @Test
    public void deleteEmail(){
        WebElement delete = driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']//following-sibling::td//a[text()='delete']"));
      delete.click();
        BrowserUtils.wait(3);

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

      Assert.assertEquals(rows.size(),3);
       List<WebElement> jonhSmith = driver.findElements(By.xpath("//table[1]//tbody//td[text()='jsmith@gmail.com']"));
      // Assert.assertTrue(jonhSmith.isEmpty());

       // her hansi elementin exist olub olmadigini bilmek ucun,
        // en yaxsi yol onu List de save ele. ve Is empty metodu istifade ele
        // yada Size==0

        Assert.assertEquals(jonhSmith.size(),0);
        Assert.assertTrue(jonhSmith.size()==0);
        // butun bunlar eyni isi gorur. eger list size  sifirdisa demeli
    }


    @Test
    public void getColumnIndexByName(){
       String columnName = "Email";// test edirem ki email column 3cudur.


       List<WebElement> listColumn = driver.findElements(By.xpath("//table[1]//th"));

       int columnNumber = 0;
       int expected = 3;

        for (int i = 0; i <listColumn.size() ; i++) {
            String actualColumnName = listColumn.get(i).getText();
            if(actualColumnName.equals(columnName)){//bir bir adlari yoxlayiram
                columnNumber=i+1;// o vaxta qeder ki Email tapacaq, loop iterate edecek, her iterationda count artacaq
                // 1 ustune gelirik ki HTML de 1 den basliyir index
                break;
            }
        }
        Assert.assertEquals(columnNumber,expected);

    }
    @Test
    public void getSpesificCell(){
        String expected = "http://www.jdoe.com ";

        int row=3;
        int column=5;

        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" +column+"]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(),expected);
    }
























//    @Test
//    public void getColumnNameByIndex(){
//        String columnName= "Email";
//
//        List<WebElement> columns = driver.findElements(By.xpath("//table[1]//th"));
//        int index=0;
//
//        for (int i = 0; i <columns.size() ; i++) {
//            String actualColumnName = columns.get(i).getText();
//            System.out.println("ColumnName: "+columns.get(i).getText()+", position: "+ (i) );
//
//            if(actualColumnName.equals(columnName)){
//                index=i+1;
//                break;
//            }
//
//
//        }
//        Assert.assertEquals(index,3);
//    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
