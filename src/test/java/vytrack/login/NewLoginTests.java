package vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack.AbstractTestBase;

public class NewLoginTests extends AbstractTestBase {
    @Test
    public void verifyPageTitle(){


        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        test.info("Login as a store manager");

        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");
    }


    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify page title");

        LoginPage loginPage = new LoginPage();//
        loginPage.login();
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning message is displayed");


    }
}
