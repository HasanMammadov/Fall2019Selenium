package vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import vytrack.AbstractTestBase;



public class NewCalendarEventsTest extends AbstractTestBase {


@Test
    public void defaultOptionsTest(){

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    loginPage.login();

    calendarEventsPage.navigateTo("Activities","Calendar Events");
    calendarEventsPage.clickToCreateCalendarEvent();
    Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());

    String actualStartDate = calendarEventsPage.getStartDate();
    String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");

    Assert.assertEquals(actualStartDate,expectedStartDate);




    }
    @Test
    public void timeDifference(){

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    loginPage.login();
    calendarEventsPage.navigateTo("Activities","Calendar Events");
    calendarEventsPage.clickToCreateCalendarEvent();

    String startTime = calendarEventsPage.getStartTime();
    String endTime = calendarEventsPage.getEndTime();
    String format = "h:mm a";

    long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format);
    Assert.assertEquals(actual,1);





    }





}
