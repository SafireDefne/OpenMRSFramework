package com.openmrs.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {
    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if(prop.getProperty("headless").equalsIgnoreCase("true")) {
            co.addArguments("--headless");
        } else if(prop.getProperty("incognito").equalsIgnoreCase("true")) {
            co.addArguments("--incognito");
        }
        return co;
    }
    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if(prop.getProperty("headless").equalsIgnoreCase("true")) {
            fo.addArguments("--headless");
        } else if(prop.getProperty("incognito").equalsIgnoreCase("true")) {
            fo.addArguments("--incognito");
        }
        return fo;
    }


}
