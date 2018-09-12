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
import java.util.HashMap;
import java.util.Map;
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
     * @param browser the browser name. Allowed browsers are: chrome, firefox & Simulate Mobile Devices with Device Mode (chrome).
     * @return a DesiredCapability
     * @throws Exception if the browser is not mapped
     */
    private static DesiredCapabilities returnCapability(String browser) throws Exception {
        DesiredCapabilities desiredCapabilities;
        Map<String, Object> chromeOptions ;
        String path = "" ;
        switch (browser.toLowerCase()) {
            case "chrome":
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
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

            case "nexus 5":
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> nexus5 = new HashMap<String, String>();
            	nexus5.put("deviceName", "Nexus 5");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", nexus5);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                break;
            	
            case "nexus 6":
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> nexus6 = new HashMap<String, String>();
            	nexus6.put("deviceName", "Google Nexus 6");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", nexus6);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "pixel 2":
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> pixel2 = new HashMap<String, String>();
            	pixel2.put("deviceName", "Pixel 2");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", pixel2);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "pixel 2 xl":
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> pixel2xl = new HashMap<String, String>();
            	pixel2xl.put("deviceName", "Pixel 2 XL");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", pixel2xl);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "iphone 5" : 
            case "iphone se": 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> iphone5_se = new HashMap<String, String>();
            	iphone5_se.put("deviceName", "iPhone 5/SE");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", iphone5_se);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "iphone 6" :
            case "iphone 7" :
            case "iphone 8" :	 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> iphone6_7_8 = new HashMap<String, String>();
            	iphone6_7_8.put("deviceName", "iPhone 6/7/8");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", iphone6_7_8);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "iphone 6 plus" :
            case "iphone 7 plus" :
            case "iphone 8 plus" :	 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> iphone6_7_8_plus = new HashMap<String, String>();
            	iphone6_7_8_plus.put("deviceName", "iPhone 6/7/8 Plus");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", iphone6_7_8_plus);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);  	
            	break;
            	
            case "iphone x" :	 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> iphonex = new HashMap<String, String>();
            	iphonex.put("deviceName", "iPhone X");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", iphonex);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);	
            	break;
            	
            case "ipad" :	 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> ipad = new HashMap<String, String>();
            	ipad.put("deviceName", "iPad");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", ipad);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            	break;
            	
            case "ipad Pro" :	 
            	path = "src/main/resources/chromedriver";
            	System.setProperty("webdriver.chrome.driver",path); 
            	Map<String, String> ipad_pro = new HashMap<String, String>();
            	ipad_pro.put("deviceName", "iPad Pro");
            	chromeOptions = new HashMap<String, Object>();
            	chromeOptions.put("mobileEmulation", ipad_pro);
            	desiredCapabilities = DesiredCapabilities.chrome();
            	desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);	
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
