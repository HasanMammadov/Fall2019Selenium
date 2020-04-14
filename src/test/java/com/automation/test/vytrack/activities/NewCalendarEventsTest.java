package com.automation.test.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.test.vytrack.AbstractTestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NewCalendarEventsTest extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/
    @Test
    public void defaultOptionsTest() {
        test = report.createTest("Verify default login options");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());

        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM d, yyyy");

        Assert.assertEquals(actualStartDate, expectedStartDate);

        test.pass("Default options verified");

    }

    /**
     * 35 minutes until 4:05
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/

    @Test
    public void timeDifferenceTest() {
        test = report.createTest("Verify time difference");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login();

        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime = calendarEventsPage.getStartTime(); //get start time
        String endTime = calendarEventsPage.getEndTime(); //get end time
        String format = "h:mm a";//format 5:15 AM for example

        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

        Assert.assertEquals(actual, 1, "Time difference is not correct");

        test.pass("Time difference verified");

    }

    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */

    @Test
    public void verifyColumnNamesTest() {
        test = report.createTest("Verify column names");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");

        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
        test.pass("Column names verified");

    }

//    public Object[] eve

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description) {
        //if you have more one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //only for extent report. To create a test in html report
        test = report.createTest("Create calendar event for " + title);
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();

        //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);

        //for extent report. specify that test passed in report (if all assertions passed)
        test.pass("Calendar event was created successfully!");
    }

    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"},
                {"Sprint Review", "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}
        };
    }

    @Test
    public void VerifyTitleIsDisplayed() {
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify Title is Displayed");
        loginPage.login();
        test.info("Login as a store manager and Title column verify ");
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickGridOptions();
        calendarEventsPage.clickGridCheckBoxes();

        Assert.assertTrue(calendarEventsPage.getGridTitle().isDisplayed());
        test.pass("Title still displayed");

    }

    @Test
    public void VerifySaveAndCloseAndNewAvailable() {//test case3
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest(" Verify Save And Close And New are Available");

        loginPage.login();
        test.info("Login as a store manager and");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickSaveAndCloseNew();

        Assert.assertTrue(calendarEventsPage.SaveAndCloseNewOptions().isDisplayed());
        test.pass("“Save And Close”, “Save And New” and “Save” options are available");


    }

    @Test
    public void VerifyAllCalendarEventsDisplayed() {//test case 4
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest(" Verify All Calendar Events page subtitle is Displayed");

        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickOnCancel();

        Assert.assertTrue(calendarEventsPage.allCalendarEventsIsDisplayed().isDisplayed());
        test.pass("All Calendar Events page subtitle is displayed");

    }

    @Test
    public void VerifyDifferenceOneHour() {//test case 5

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that difference between end and start time is exactly 1 hour");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertTrue(calendarEventsPage.differenceEndAndStart() == 1);
        test.pass("Difference between end and start time is exactly 1 hour");


    }

    @Test
    public void VerifyEndTime10PM() {//test case 6

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that end time is 10:PM");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertTrue(calendarEventsPage.verify10PM().equals("10:00 PM"));
        test.pass("End time is 10:00PM");

    }


    @Test
    public void VerifyAllDayEvent() {//test case 7

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “All-Day Event” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickAllDayEventCheckBox();
        Assert.assertTrue(calendarEventsPage.getAllDayEventCheckBox().isSelected());
        test.pass("“All-Day Event” checkbox is selected");
        Assert.assertFalse(calendarEventsPage.getStartTimeWebElement().isDisplayed());
        test.pass("start time input boxes is not displayed");
        Assert.assertFalse(calendarEventsPage.getEndTimeWebElement().isDisplayed());
        test.pass("end time input boxes is not displayed");

        Assert.assertTrue(calendarEventsPage.getStartDateWebElement().isDisplayed());
        test.pass("Start date input boxes is displayed");

        Assert.assertTrue(calendarEventsPage.getEndDateWebElement().isDisplayed());
        test.pass("End date input boxes is displayed");


    }

    @Test()
    public void RepeatCheckbox() {//test case 8

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “Repeat” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickRepeat();

        Assert.assertTrue(calendarEventsPage.getRepeatWebelement().isSelected());
        test.pass(" “Repeat” checkbox is selected");
        System.out.printf(calendarEventsPage.getDailySelectedByDefault());

        Assert.assertTrue(calendarEventsPage.getDailySelectedByDefault().equals("daily"));


        List<String> actual = calendarEventsPage.allOptions();
        List<String> expected = new ArrayList<>(Arrays.asList("Daily", "Weekly", "Monthly", "Yearly"));

        Assert.assertEquals(actual, expected);

    }


    @Test()
    public void tets9() {//test case 9

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “Repeat” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickRepeat();

        Assert.assertTrue(calendarEventsPage.getRepeatWebelement().isSelected());
        test.pass(" “Repeat” checkbox is selected");

        Assert.assertTrue(calendarEventsPage.repeatEveryDay().get(0).isSelected());
        test.pass(" “Repeat Every” radio button is selected");

        Assert.assertTrue(calendarEventsPage.repeatEveryDay().get(2).isSelected());
        test.pass(" Verify that “Never” radio button is selected");

//Verify that “Never” radio button is selected
        Assert.assertTrue(calendarEventsPage.getDailyEveryOneDay().isDisplayed());
        test.pass(" following message is displayed: “Summary: Daily every 1 day”");


    }

    @Test()
    public void tets10() {//test case 10

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “Repeat” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickRepeat();
        calendarEventsPage.enter10();

        Assert.assertEquals(calendarEventsPage.getSummaryMessage(), "Summary:\nDaily every 1 day, end after 10 occurrences");

    }


    @Test()
    public void tets11() {//test case 11

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “Repeat” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickRepeat();
        calendarEventsPage.clickBy();
        calendarEventsPage.enterDateNov182021();
        Assert.assertEquals(calendarEventsPage.getSummaryMessage(), "Summary:\nDaily every 1 day, end by Nov 18, 2021");
        test.pass(" following message is displayed: “Summary:Summary:\nDaily every 1 day, end by Nov 18, 2021");

    }

    @Test()
    public void tets12() {//test case 12

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        test = report.createTest("Verify that “Repeat” checkbox is selected");


        loginPage.login();
        test.info("Login as a store manager");

        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.clickRepeat();
        calendarEventsPage.selectWeekly();
        calendarEventsPage.clickMonday();
        calendarEventsPage.clickFriday();

        Assert.assertEquals(calendarEventsPage.getSummaryMessage(),"Summary:\nWeekly every 1 week on Monday, Friday");
        test.pass(" following message is displayed: “Summary:Weekly every 1 week on Monday, Friday");

    }
}