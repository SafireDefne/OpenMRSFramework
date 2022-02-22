package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDashBoardPageTest extends BaseTest {

    @BeforeClass
    public void adminDashBoardPageSetup() {
        adminDashBoardPage = loginPage.verifyLoginFunctionality(prop.getProperty("userID"), prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void verifyLoggedAsAdminTest() {
        Assert.assertEquals(adminDashBoardPage.verifyLoggedAsAdmin(),prop.getProperty("userID"));
    }

    @Test(priority = 2)
    public void verifyLocationTest() {
        Assert.assertEquals(adminDashBoardPage.verifyLocationIsCorrect(),prop.getProperty("location"));
    }

    @Test(priority = 3)

    public void verifyAppsAvailabilityTest() {
        Assert.assertEquals(adminDashBoardPage.verifyAppsAvailability(), Constants.actualApps());
    }


    @Test(priority = 4)
    public void goToRegisterPatientPageTest() {
        adminDashBoardPage.goToRegisterPatientPage();
        Assert.assertTrue(adminDashBoardPage.verifyGivenNameField());


    }
    @Test(priority = 5)

    public void verifyLogoutTest() {
        adminDashBoardPage.verifyLogout();
    }

}
