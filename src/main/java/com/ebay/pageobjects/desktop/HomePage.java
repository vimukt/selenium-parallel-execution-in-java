package com.ebay.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;


public class HomePage {
	private WebDriver driver;

	@FindBy(id = "gh-ac")
	private WebElement searchTxt;

	@FindBy(id = "gh-btn")
	private WebElement searchBtn;

	@FindBy(css = "#qtyTextBox")
	private WebElement quantityTxt;

	@FindBy(css = "#atcRedesignId_btn")
	private WebElement addToCartBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(10, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}

	public CheckoutPage searchFor(String item) {
		searchTxt.sendKeys(item);
		 searchBtn.click();
		return new CheckoutPage(driver);
	}

}
