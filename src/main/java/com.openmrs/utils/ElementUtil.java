package com.openmrs.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public boolean checkIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String doGetText(By locator) {
       return getElement(locator).getText();
    }

    private List<WebElement> getAllDropDownOptions(By locator) {
        Select select = new Select(getElement(locator));
        return select.getOptions();
    }

    public boolean compareDropDownOptions(By locator, String[] expected) {
     List<WebElement> options = getAllDropDownOptions(locator);
     int i = 0;
     for(WebElement elm : options) {
         if(!elm.getText().equals(expected[i])) {
             return false;
         }
         i = i + 1;
     }
     return true;
    }

    public String generateRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            stringBuilder.append(str.charAt(secureRandom.nextInt(str.length())));

        }
        return stringBuilder.toString();
    }

    public void waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBePresent(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public Alert waitForAlertToBePresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String waitForTitleToBePresent(String title, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }
    public void waitForFameToBeAvailableAndSwitchToIt(WebDriver driver, int timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public boolean waitForUrl(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public boolean checkIsEnabled(By locator) {
        return getElement(locator).isEnabled();
    }





}
