package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	BasePage basePage;
	String emailPassword, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailPassword = getRandomEmail();
		password = "123456";
		
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		//registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(emailPassword);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		//homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		//loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailPassword);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	// Option 1: less than 10 pages
	@Test
	public void Login_03_Open_Page_At_Footer() {
		// Home page -> Search page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		// Search page -> My Account page
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");
		
		// My Account page -> Order page
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");
		
		// Order page -> My Account page
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");
		
		// My Account page -> Search page
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");
		
		// Search page -> Order page
		orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver, "Orders");
	}
	
	// Option 2: Multiple pages
	@Test
	public void Login_04_Open_Page_At_Footer() {
		// Order page -> My Account page
		orderPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		// My Account page -> Search page
		myAccountPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		// Search page -> Order page
		searchPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
