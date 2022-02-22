package com.openmrs.base;

import com.openmrs.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public BasePage basePage;
    public Properties prop;
    public LoginPage loginPage;
    public AdminDashBoardPage adminDashBoardPage;
    public FindPatientRecordPage findPatientRecordPage;
    public PatientPage patientPage;
    public RegisterPatientPage registerPatientPage;



    @BeforeTest
    public void setUp() {
        basePage = new BasePage();
        prop = basePage.init_prop();
        driver = basePage.init_driver(prop.getProperty("browser"));
        loginPage = new LoginPage(driver);
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
