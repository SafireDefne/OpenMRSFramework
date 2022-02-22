package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindPatientRecordPageTest extends BaseTest {
    @BeforeClass
    public void findPatientRecordPageSetup() {
        adminDashBoardPage = loginPage.verifyLoginFunctionality(prop.getProperty("userID"),prop.getProperty("password"));
        findPatientRecordPage = adminDashBoardPage.goToFindPatientRecordPage();
    }

    @Test(priority = 1)
    public void verifyFindPatientRecordPage() {
        Assert.assertEquals(findPatientRecordPage.verifyPageName(), Constants.FIND_PATIENT_RECORD_PAGE_NAME);
        Assert.assertTrue(findPatientRecordPage.verifySearchFieldIsEnabled());
    }
    @Test(priority = 2)
    public void verifySearchFunctionTest() {
        Assert.assertEquals(findPatientRecordPage.verifySearchFunction(prop.getProperty("patientName")),prop.getProperty("patientName"));
    }

    @Test(priority = 3)
    public void clickOnPatientNameTest() {
        findPatientRecordPage.goToPatientPage(prop.getProperty("patientName"));
        Assert.assertTrue(findPatientRecordPage.verifyPatientPage());
    }




}
