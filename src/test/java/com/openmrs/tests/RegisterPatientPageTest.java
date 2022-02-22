package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.ExcelUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPatientPageTest extends BaseTest {

    @BeforeClass
    public void registerPatientPageSetup() {
        adminDashBoardPage = loginPage.verifyLoginFunctionality(prop.getProperty("userID"), prop.getProperty("password"));
        registerPatientPage = adminDashBoardPage.goToRegisterPatientPage();


    }
    @Test(dataProvider = "getUserData")
    public void registerPatientTest(String gName, String mName, String fName, String gender,
                                    String day, String month, String year, String address,
                                    String city, String state, String country, String zip,
                                    String phone,String relation, String pName) {
        registerPatientPage.registerPatient(gName, mName, fName, gender, day, month, year, address, city,
                state, country, zip, phone, relation, pName);
    }

    @DataProvider
    public Object[][] getUserData() {
        return ExcelUtil.getTestData("Sheet3");
    }
}
