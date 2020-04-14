package com.automation.pages.activities;
import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    private WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;


    @FindBy(css = "[class='fa-cog hide-text']")
    private WebElement GridOptions;

    @FindBy(css = "[class='visibility-cell']")
    private List<WebElement> gridCheckBoxes;


    @FindBy(css = "[class='grid-header-cell__label']")
    private WebElement GridTitle;

    @FindBy(css = "[class='caret']")
    private WebElement caretButton;

    @FindBy(css = "[type='submit']")
    private  List<WebElement> saveCloseNewButtons;


    @FindBy(css = "[title='Cancel']")
    private WebElement cancel;

    @FindBy(css = "[class='oro-subtitle']")
    private WebElement allCalendarEvents;


    @FindBy(xpath = "//li[text()='9:00 PM']")
    private WebElement pM9;

    @FindBy(css = "[data-name='field__all-day']")
    private WebElement allDayEventCheckBox;



    @FindBy(css = "[id^=recurrence-repeats]")
    private WebElement repeatOptions;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    private WebElement repeat;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "//span[text()='Daily every 1 day']")
    private WebElement dailyEveryOneDay;

    @FindBy(xpath = "//div[2]/div[2]/label/input[2]")
    private WebElement send10input;

    @FindBy(xpath = "//label[text()='Summary:']")
    private WebElement summary;
    @FindBy(xpath = "//span[text()='Daily every 1 day']")
    private WebElement dailyOneDay;

    @FindBy(xpath = "//span[text()=', end after 10 occurrences']")
    private WebElement after10occurens;

    @FindBy(xpath = "//*[text()='By']/preceding-sibling::input")
    private WebElement clickBy;

    @FindBy(css = "[id^='dp']")
    private WebElement enterByDate;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    private WebElement summaryInfo;

    @FindBy(xpath = "//input[@value='monday']")
    private WebElement weeklyMonday;

    @FindBy(xpath = "//input[@value='friday']")
    private WebElement weeklyFriday;

    public void clickMonday(){
        weeklyMonday.click();
    }

    public void clickFriday(){
        weeklyFriday.click();
    }



    public void selectWeekly(){
        BrowserUtils.waitForPageToLoad(15);
        Select select = new Select(driver.findElement(By.cssSelector("[id^=recurrence-repeats]")));
        repeatOptions.click();
        select.selectByValue("weekly");
        BrowserUtils.wait(2);

    }




    public void clickBy(){
        BrowserUtils.waitForPageToLoad(20);
        clickBy.click();
    }

    public void enterDateNov182021(){
        BrowserUtils.waitForPageToLoad(20);

        enterByDate.sendKeys("Nov 18, 2021");
    }
    public void enter10(){
        BrowserUtils.waitForPageToLoad(10);
        send10input.click();
        send10input.sendKeys("10"+ Keys.ENTER);
    }

    public String getSummaryMessage(){
        BrowserUtils.waitForPageToLoad(10);
BrowserUtils.wait(2);
        String message = summaryInfo.getText();

        return message.trim();
    }


    public WebElement getDailyEveryOneDay(){
        return  dailyEveryOneDay;
    }

    public List<WebElement> repeatEveryDay(){
        return radioButtons;
    }

    public void clickRepeat(){

        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(4);

        wait.until(ExpectedConditions.elementToBeClickable(repeat)).click();

    }
    public String getDailySelectedByDefault(){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(4);
        Select select = new Select(driver.findElement(By.cssSelector("[id^=recurrence-repeats]")));
        String defaultOption = select.getFirstSelectedOption().getAttribute("value");

        return defaultOption;
    }
    public List<String> allOptions(){
        BrowserUtils.wait(2);

        Select select = new Select(driver.findElement(By.cssSelector("[id^=recurrence-repeats]")));
        List<WebElement> elements =select.getOptions();

        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }








    public WebElement getRepeatWebelement(){
        return repeat;

    }


    public WebElement getEndDateWebElement(){
        return endDate;
    }

    public WebElement getStartDateWebElement(){
        return startDate;
    }

    public WebElement getEndTimeWebElement(){
        return endTime;
    }

    public WebElement getStartTimeWebElement(){
        return startTime;
    }



    public WebElement getAllDayEventCheckBox(){

        return allDayEventCheckBox;

    }

    public void clickAllDayEventCheckBox(){
        BrowserUtils.waitForPageToLoad(20);

        wait.until(ExpectedConditions.elementToBeClickable(allDayEventCheckBox)).click();
        wait.until(ExpectedConditions.invisibilityOf(startTime));
        wait.until(ExpectedConditions.invisibilityOf(endTime));

    }



    public String verify10PM(){
        BrowserUtils.waitForPageToLoad(20);

        wait.until(ExpectedConditions.elementToBeClickable(startTime)).click();
        pM9.click();

        return endTime.getAttribute("value");
    }


        public int differenceEndAndStart(){
//
String start =getStartTime();
    start=start.substring(0,start.indexOf(":"));

    int startInt = Integer.parseInt(start);

    String end = getEndTime();
    end=end.substring(0,end.indexOf(":"));
            int endInt = Integer.parseInt(end);

        int result = endInt-startInt;

        return result;

     }

// this method will click Activities, calendar event page next to save and close
    public void clickOnCancel(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();

    }


    public WebElement allCalendarEventsIsDisplayed(){
        return allCalendarEvents;
    }


    public void clickSaveAndCloseNew(){
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        caretButton.click();


        }

        public WebElement SaveAndCloseNewOptions(){
            WebElement element = null;
            for (int i = 0; i <saveCloseNewButtons.size() ; i++) {
                element = saveCloseNewButtons.get(i);
            }
            return element;
        }



    public WebElement getGridTitle(){
        BrowserUtils.waitForPageToLoad(20);
        return GridTitle;
    }

    public void clickGridCheckBoxes(){

        for (int i = 1; i <gridCheckBoxes.size() ; i++) {
            gridCheckBoxes.get(i).click();
        }
    }

    public void clickGridOptions(){
        wait.until(ExpectedConditions.elementToBeClickable(GridOptions)).click();
    }

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        BrowserUtils.waitForPageToLoad(20);
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }

    public void clickOnSaveAndClose() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitleText() {
        BrowserUtils.waitForPageToLoad(20);

        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }

    //#############################################################
    public List<String> getColumnNames() {
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

    public String getStartTime() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    public String getOwnerName() {
        BrowserUtils.waitForPageToLoad(20);
        //wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public String getStartDate() {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }
}
