package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPatientRecordPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;


    public FindPatientRecordPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By pageName = By.tagName("h2");
    private By searchField = By.id("patient-search");
    private By appearedPatientName = By.xpath("//tbody/tr/td[2]");
    private By patientNameOnTitle = By.xpath("//ul[@id='breadcrumbs']/li[2]");



    public String verifyPageName() {
        return elementUtil.doGetText(pageName);
    }

    public boolean verifySearchFieldIsEnabled() {
        return elementUtil.checkIsEnabled(searchField);
    }

    public String verifySearchFunction(String patientName) {
        elementUtil.doSendKeys(searchField,patientName);
        return elementUtil.doGetText(appearedPatientName);
    }

    public PatientPage goToPatientPage(String patientName) {
        elementUtil.doSendKeys(searchField,patientName);
        elementUtil.doClick(appearedPatientName);
        return new PatientPage(driver);
    }
    public boolean verifyPatientPage() {
        return elementUtil.checkIsDisplayed(patientNameOnTitle);
    }












}
