package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By logo = By.xpath("//div/a/img");
    private By locations = By.xpath("//*[@id='sessionLocation']/li");
    private By loginBtn = By.id("loginButton");
    private By cantLogin = By.id("cantLogin");
    private By cantLoginMessage = By.xpath("//p[@class='dialog-instructions']");
    private By errorMessageWithoutCredentialAndLocation = By.id("sessionLocationError");
    private By errorMessageWithoutCredentialButWithLocation = By.id("error-message");
    private By laboratory = By.id("Laboratory");
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By registerAPatient = By.xpath("//div[3]/div/a[3]");
    private By okayBtn = By.xpath("//button[text()='Okay']");


    public boolean verifyLogo() {
        return elementUtil.checkIsDisplayed(logo);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getLocationsNames() {
       List<String> locationsNames = new ArrayList<>();
       List<WebElement> elements = elementUtil.getElements(locations);
       for (WebElement elm : elements) {
           locationsNames.add(elm.getText());
       }
       return locationsNames;
     }

    public boolean verifyLoginBtnStatus() {
        return elementUtil.checkIsEnabled(loginBtn);
    }

    public boolean verifyCantloginLink() {
        return elementUtil.checkIsDisplayed(cantLogin);
    }
    public String verifyCantLoginMessage() {
        elementUtil.doClick(cantLogin);
        return elementUtil.doGetText(cantLoginMessage);
    }
    public void clickOnOkayBtn() {
        elementUtil.waitForElementToBeClickable(okayBtn,10);
        elementUtil.doClick(okayBtn);
    }

    public String verifyErrorMessageWithoutCredentialAndLocation() {
        elementUtil.doClick(loginBtn);
        elementUtil.waitForElementToBePresent(errorMessageWithoutCredentialAndLocation,20);
        return elementUtil.doGetText(errorMessageWithoutCredentialAndLocation);
    }

    public String verifyErrorMessageWithoutCredentialButWithLocation() {
        elementUtil.doClick(okayBtn);
        elementUtil.doClick(laboratory);
        elementUtil.doClick(loginBtn);
        elementUtil.waitForElementToBePresent(errorMessageWithoutCredentialButWithLocation,20);
        return elementUtil.doGetText(errorMessageWithoutCredentialButWithLocation);
    }

    public AdminDashBoardPage verifyLoginFunctionality(String userID, String password) {
        //elementUtil.doClick(okayBtn);
        elementUtil.doSendKeys(userNameField,userID);
        elementUtil.doSendKeys(passwordField,password);
        elementUtil.doClick(laboratory);
        elementUtil.doClick(loginBtn);
        return new AdminDashBoardPage(driver);
    }

}
