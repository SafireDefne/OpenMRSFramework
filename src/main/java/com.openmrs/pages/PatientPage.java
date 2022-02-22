package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PatientPage extends BasePage {
    private WebDriver driver;
    ElementUtil elementUtil;

    public PatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
    private By generalActions = By.xpath("//ul[@class='float-left']/li/descendant::a/div[1]");

    public List<String> getGeneralActionsList() {
        List<String> generalActionsList = new ArrayList<>();
        List<WebElement> elements = elementUtil.getElements(generalActions);
        for(WebElement elm : elements) {
            generalActionsList.add(elm.getText());
        }
        return generalActionsList;
    }
}
