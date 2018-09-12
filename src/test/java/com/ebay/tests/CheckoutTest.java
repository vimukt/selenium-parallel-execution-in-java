package com.ebay.tests;

import com.ebay.pageobjects.desktop.BasePage;
import com.ebay.pageobjects.desktop.CheckoutPage;
import com.ebay.pageobjects.desktop.HomePage;
import com.ebay.pageobjects.desktop.LoginPage;
import com.ebay.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTest {

	@Test
	@Parameters({ "browser", "userName", "password" })
	public void checkoutItems(@Optional("chrome") String browser, String userName, String password)
			throws Exception {

		WebDriver driver = Utils.getDriver(browser);
		BasePage basePage = new BasePage(driver);
	/*	
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		loginPage = basePage.gotoLoginPage();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		homePage = loginPage.login();
		checkoutPage = homePage.searchFor("Erasers");
		checkoutPage.addItemsFromSearchToCart(2);
		// assert checkout count message.
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertTrue(checkoutPage.validateItemCountInTheCartAndMessage());

		// clean up for next execution
		checkoutPage.removeItems();

		// sign out

		checkoutPage.logout();
*/
		driver.quit();

	}
}
