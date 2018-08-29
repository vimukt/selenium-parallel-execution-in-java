package com.ebay.utils;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Utils {

    /**
     * Return a new RemoteWebDriver instance based on the grid for a given browser
     * @param browser a browser that will run the test
     * @return a new RemoteWebDriver instance
     * @throws Exception if the browser is not mapped
     */
    public static WebDriver getDriver(String browser) throws Exception {

        // a composition of the target grid address and port
        String url = getValueFromConf("grid.url"); //"http://localhost:4444/wd/hub";
        
        return new RemoteWebDriver(new URL(url), returnCapability(browser));
    }
        
        

    /**
     * Return a DesiredCapability for a given browser
     * @param browser the browser name. Allowed browsers are: chrome, firefox
     * @return a DesiredCapability
     * @throws Exception if the browser is not mapped
     */
    private static DesiredCapabilities returnCapability(String browser) throws Exception {
        DesiredCapabilities desiredCapabilities;

        String path = "" ;
        switch (browser.toLowerCase()) {
            case "chrome":
            	path = "src/main/resources/chromedriver";
            	//System.setProperty("webdriver.chrome.driver","./chromedriver"); 
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
                desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                //desiredCapabilities.setPlatform(org.openqa.selenium.Platform.HIGH_SIERRA);
                
                
                
                break;

            case "firefox":
            	path = "src/main/resources/geckodriver";
                desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                desiredCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
                desiredCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                break;

      
            default:
                throw new Exception("Browser not supported or misspelled");
        }

        return desiredCapabilities;
    }

    /**
     * Return a value from conf/config.properties given a property
     * @param property an existing property from config/config.properties
     * @return the value of a property
     */
    public static String getValueFromConf(String property) {
        Properties properties;
        String value = null;
        try {
            properties = new Properties();
            properties.load(new FileReader(new File("conf/config.properties")));

            value =  properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
