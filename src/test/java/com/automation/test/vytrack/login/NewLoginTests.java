package com.automation.test.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.test.vytrack.AbstractTestBase;

public class NewLoginTests extends AbstractTestBase {

    @Test(groups = "smoke")
    public void verifyPageTitle() {
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test = report.createTest("Verify page title");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //like system.out, but it goes to report as well
        test.info("Login as store manager");//log some steps
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed


        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter wrong credentials and verify warning message
     */

    @Test
    public void verifyWarningMessage() {
        test = report.createTest("Verify warning message");

        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");

        test.pass("Warning message is displayed");
    }

    @DataProvider
    public Object[][] testData(){

        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16",         "UserUser123"}
        };
    }
@Test(dataProvider = "credentialsFromExel")
    public void LoginTestWithExel(String execute,String username,String password,String firstname,String lastname,String result){
        test= report.createTest("Login test for username ::"+username);

        if(execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username,password);
            test.info("Login as" +username);
            test.pass("Successfully logged in as "+username);
            test.info(String.format("First name: %s, Last name: %s, Username: %s",firstname, lastname,username));
        }else {
            test.skip("Test was skipped for user: "+username);

            throw  new SkipException("Test was skipped for user: "+username);
        }
    }





    @DataProvider
    public Object[][] credentialsFromExel(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return  excelUtil.getDataArray();

    }

    @Test(dataProvider = "testData")
    public void test(String username,String password){
        test = report.createTest("Verify page title as "+username);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        test.info("Login as "+username);
        BrowserUtils.wait(2);

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Title was verified as a Dashboard");
    }






    @Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) {
        test = report.createTest("Verify page title as " + userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        test.info("Login as " + userName);//log some steps
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");
    }

    @DataProvider
    public Object[][] credentials() {
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16", "UserUser123"}
        };
    }

    //Object[][] or Object[] or Iterator<Object[]>
    //Object[] - 1 column with a data
    //Object[][] 2+
}
