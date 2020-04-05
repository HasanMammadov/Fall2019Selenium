package com.automation.test.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.test.vytrack.AbstractTestBase;

public class NewVehicleTests extends AbstractTestBase {

    @Test
    public void verifyTitle(){

        LoginPage loginPage = new LoginPage();

        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();// bu sehifeye girir

        vehiclesPage.navigateTo("Fleet", "Vehicle Costs");//
        String expectedTitle = "All - Vehicle Costs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
