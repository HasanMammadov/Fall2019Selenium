package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vytrack.AbstractTestBase;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private  WebElement owner;

    @FindBy(css = "[id^=date_selector_oro_calendar_event_form_start]")// ^ Css de start with demekdi
    private  WebElement startDate;

    @FindBy(css = "[id^=time_selector_oro_calendar_event_form_start]")
    private WebElement startTime;

    @FindBy(css = "[id^=time_selector_oro_calendar_event_form_end]")
    private WebElement endTime;


    @FindBy(css = "[class='grid-header-cell__link']")
    private List<WebElement> columnsNames;


    public List<String> getColumnNames(){
        BrowserUtils.waitForPageToLoad(15);
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        return BrowserUtils.getTextFromWebElements(columnsNames);
    }

    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(owner));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        return owner.getText().trim();
    }


    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }

    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");

    }

    public String getEndTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return endTime.getAttribute("value");
    }



}
