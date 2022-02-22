package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPatientPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;


    RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    private By givenName = By.name("givenName");
    private By middleName = By.name("middleName");
    private By familyName = By.name("familyName");
    private By nextBtn = By.id("next-button");
    private By genderMale = By.xpath("//option[text()='Male']");
    private By genderFemale = By.xpath("//option[text()='Female']");
    private By birthDay = By.id("birthdateDay-field");
    private By birthMonth = By.id("birthdateMonth-field");
    private By birthYear = By.id("birthdateYear-field");
    private By address1 = By.id("address1");
    private By cityVillage = By.id("cityVillage");
    private By sProvince = By.id("stateProvince");
    private By countryField = By.id("country");
    private By pCode = By.id("postalCode");
    private By tNum = By.name("phoneNumber");
    private By selectRelationType = By.xpath("//select[@id='relationship_type']/option[1]");
    private By relationDoctor = By.xpath("//select[@id='relationship_type']/option[2]");
    private By relationSibling = By.xpath("//select[@id='relationship_type']/option[3]");
    private By relationParent = By.xpath("//select[@id='relationship_type']/option[4]");
    private By relationAuntUncle = By.xpath("//select[@id='relationship_type']/option[5]");
    private By relationSupervisor = By.xpath("//select[@id='relationship_type']/option[6]");
    private By relationPatient = By.xpath("//select[@id='relationship_type']/option[7]");
    private By relationChild = By.xpath("//select[@id='relationship_type']/option[8]");
    private By relationNieceNephew = By.xpath("//select[@id='relationship_type']/option[9]");
    private By relationSupervisee = By.xpath("//select[@id='relationship_type']/option[10]");
    private By personName = By.xpath("//p/input[@placeholder='Person Name']");
    private By confirmBtn = By.id("submit");
    private By logoutBtn = By.xpath("//div[2]/ul/li[3]/a");



    public PatientPage registerPatient(String gName, String mName, String fName, String gender,
                                                          String day, String month, String year, String address,
                                                          String city, String state, String country, String zip,
                                                          String phone,String relation, String pName) {


        elementUtil.doSendKeys(givenName,elementUtil.generateRandomString(5) + gName);
        elementUtil.doSendKeys(middleName,elementUtil.generateRandomString(6) + mName);
        elementUtil.doSendKeys(familyName,elementUtil.generateRandomString(5) + fName);
        elementUtil.doClick(nextBtn);
        if(gender.equalsIgnoreCase("female")) {
            elementUtil.doClick(genderFemale);
        } else {
            elementUtil.doClick(genderMale);
        }
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(birthDay,day);
        elementUtil.doSendKeys(birthMonth,month);
        elementUtil.doSendKeys(birthYear,year);
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(address1,address);
        elementUtil.doSendKeys(cityVillage,city);
        elementUtil.doSendKeys(sProvince,state);
        elementUtil.doSendKeys(countryField,country);
        elementUtil.doSendKeys(pCode,zip);
        elementUtil.doClick(nextBtn);
        elementUtil.doSendKeys(tNum,phone);
        elementUtil.doClick(nextBtn);

        if(relation.equalsIgnoreCase("doctor")) {
            elementUtil.doClick(relationDoctor);
        } else if(relation.equalsIgnoreCase("sibling")) {
            elementUtil.doClick(relationSibling);
        }else if(relation.equalsIgnoreCase("parent")) {
            elementUtil.doClick(relationParent);
        }else if(relation.equalsIgnoreCase("auntuncle")) {
            elementUtil.doClick(relationAuntUncle);
        }else if(relation.equalsIgnoreCase("supervisor")) {
            elementUtil.doClick(relationSupervisor);
        }else if(relation.equalsIgnoreCase("patient")) {
            elementUtil.doClick(relationPatient);
        }else if(relation.equalsIgnoreCase("child")) {
            elementUtil.doClick(relationChild);
        }else if(relation.equalsIgnoreCase("niecenephew")) {
            elementUtil.doClick(relationNieceNephew);
        }else if(relation.equalsIgnoreCase("supervisee")) {
            elementUtil.doClick(relationSupervisee);
        }else  {
            elementUtil.doClick(selectRelationType);
        }

        elementUtil.doSendKeys(personName,pName);
        elementUtil.doClick(nextBtn);
        elementUtil.doClick(confirmBtn);
        return new PatientPage(driver);

    }

}
