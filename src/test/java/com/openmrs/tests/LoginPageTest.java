package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLogoTest() {
        Assert.assertTrue(loginPage.verifyLogo());
    }
    @Test(priority = 2)
    public void validatePageTitleTest() {
        Assert.assertEquals(loginPage.getPageTitle(), Constants.PAGE_TITLE);
    }
    @Test(priority = 3)
    public void verifyLocationsTest() {
        Assert.assertEquals(loginPage.getLocationsNames(),Constants.actualLocations());
    }
    @Test(priority = 4)
    public void verifyLoginBtnStatusTest() {
        Assert.assertTrue(loginPage.verifyLoginBtnStatus());
    }

    @Test(priority = 5)
    public void verifyCantLoginLinkTest() {
        Assert.assertTrue(loginPage.verifyCantloginLink());

    }

    @Test(priority = 7)
    public void verifyCantLoginMessageTest() {
        Assert.assertEquals(loginPage.verifyCantLoginMessage(),Constants.CANT_LOGIN_MESSAGE);
    }
    @Test(priority = 6)
    public void verifyErrorMessageWithoutCredentialAndLocationTest() {
        Assert.assertEquals(loginPage.verifyErrorMessageWithoutCredentialAndLocation(),Constants.ERROR_MESSAGE_WITHOUT_CREDENTIAL_AND_LOCATION);
    }
    @Test(priority = 8)
    public void verifyErrorMessageWithoutCredentialButWithLocationTest() {
        Assert.assertEquals(loginPage.verifyErrorMessageWithoutCredentialButWithLocation(),Constants.ERROR_MESSAGE_WITHOUT_CREDENTIAL_BUT_WITH_LOCATION);
    }
    @Test(priority = 9)
    public void verifyLoginFunctionalityTest() {
        loginPage.verifyLoginFunctionality(prop.getProperty("userID"),prop.getProperty("password"));
    }


}
