package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientPageTest extends BaseTest {

    @BeforeClass
    public void patientPageSetup() {
        adminDashBoardPage = loginPage.verifyLoginFunctionality(prop.getProperty("userID"),prop.getProperty("password"));
        findPatientRecordPage = adminDashBoardPage.goToFindPatientRecordPage();
        patientPage = findPatientRecordPage.goToPatientPage(prop.getProperty("patientName"));
    }
    @Test
    public void verifyGeneralActionsLinks() {
        Assert.assertEquals(patientPage.getGeneralActionsList(), Constants.getGeneralActions());
    }




}
