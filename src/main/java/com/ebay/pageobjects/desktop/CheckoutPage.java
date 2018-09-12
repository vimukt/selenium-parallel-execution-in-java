package com.ebay.pageobjects.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class CheckoutPage {

	private WebDriver driver;

	@FindBy(id = "gh-ac")
	private WebElement searchTxt;

	@FindBy(id = "gh-btn")
	private WebElement searchBtn;

	@FindBy(css = "#qtyTextBox")
	private WebElement quantityTxt;

	@FindBy(id = "atcRedesignId_btn")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//li[@id='srp-river-results-listing1']//*[@class='s-item__link']")
	private WebElement item1;

	@FindBy(xpath = "//*[@id=\'atcRedesignId_overlay-atc-container\']//*[@class='app-atc-layer__actionRow']//a[2]")
	private WebElement gotoCart;

	@FindBy(xpath = "//h1[@class='main-title']")
	private WebElement checkoutItemTxt;

	@FindBy(xpath = "//*[@data-test-id='cart-remove-item']")
	private WebElement removeItems;

	@FindBy(xpath = "//button[@id='gh-ug']")
	private WebElement greetBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signOut;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(10, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	/**
	 * @param item
	 * search for an item.
	 */
	public void searchFor(String item) {
		searchTxt.sendKeys(item);
		searchBtn.click();

	}

	/**
	 * @param number
	 * add number(s) of item for a given product to the cart.
	 */
	public void addItemsFromSearchToCart(int number) {

		String url = item1.getAttribute("href");
		driver.navigate().to(url);
		quantityTxt.clear();
		quantityTxt.sendKeys(Integer.toString(number));
		addToCartBtn.click();
		String gotoCartUrl = addToCartBtn.getAttribute("href");
		driver.navigate().to(gotoCartUrl);

	}

	public Boolean validateItemCountInTheCartAndMessage() {

		String checkoutTitelText = checkoutItemTxt.getText();
		return checkoutTitelText.equals("Shopping cart (2 items)") ? true : false;

	}

	public void removeItems() {
		removeItems.click();
	}

	public void logout() {
		greetBtn.click();
		// String strSignOut = signOut.getAttribute("href");
		// System.out.println(strSignOut);
	}
}
