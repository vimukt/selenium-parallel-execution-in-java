package com.ebay.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;


public class LoginPage {
	private WebDriver driver;
	@FindBy(id = "userid")
    private WebElement userNameTxt;
    
    @FindBy(id = "pass")
    private WebElement passwordTxt;
    
    @FindBy(id = "sgnBt")
    private WebElement loginBtn;


    
    public LoginPage(WebDriver driver) {
    	 this.driver = driver;
    	 PageFactory.initElements(driver, this);
    	 @SuppressWarnings("deprecation")
 		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 		.withTimeout(60, TimeUnit.SECONDS)
 		.pollingEvery(10, TimeUnit.SECONDS)
 		.ignoring(NoSuchElementException.class);
    }
    
    public void enterUserName(String userName) {
    	userNameTxt.sendKeys(userName);
    }

    public void enterPassword(String pass) {
    	passwordTxt.sendKeys(pass);
    }
    
    public HomePage login() {
    	loginBtn.click();
    	return new HomePage(driver);
    	
    }
    
}
