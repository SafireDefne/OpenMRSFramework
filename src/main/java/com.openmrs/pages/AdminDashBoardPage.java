package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminDashBoardPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;


    private By adminLink = By.xpath("//li[@class='nav-item identifier']");
    private By selectedLocation = By.id("selected-location");
    private By apps = By.xpath("//div[3]/div/a");
    private By logoutBtn = By.xpath("//div/ul/li[3]/a");
    private By userNameField = By.id("username");
    private By registerAPatient = By.xpath("//div[3]/div/a[3]");
    private By gName = By.name("givenName");
    private By findPatientRecord = By.xpath("//div[3]/div[3]/div/a[1]");
    public AdminDashBoardPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }


    public String verifyLoggedAsAdmin() {
        return elementUtil.doGetText(adminLink);
    }

    public String verifyLocationIsCorrect() {
        return elementUtil.doGetText(selectedLocation);
    }

    public List<String> verifyAppsAvailability() {
        List<String> appsNames = new ArrayList<>();
        List<WebElement> elements = elementUtil.getElements(apps);
        for(WebElement elm : elements) {
            appsNames.add(elm.getText());
        }
        return appsNames;
    }

    public RegisterPatientPage goToRegisterPatientPage() {
        elementUtil.waitForElementToBeClickable(registerAPatient,90);
        elementUtil.doClick(registerAPatient);
        return new RegisterPatientPage(driver);
    }
    public boolean verifyGivenNameField() {
        return elementUtil.checkIsDisplayed(gName);
    }

    public void verifyLogout() {
        elementUtil.doClick(logoutBtn);
        elementUtil.checkIsDisplayed(userNameField);
    }

    public FindPatientRecordPage goToFindPatientRecordPage() {
        elementUtil.doClick(findPatientRecord);
        return new FindPatientRecordPage(driver);
    }


}
