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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Register extends BaseTest {
	WebDriver driver;
	BasePage basePage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;

	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		email = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		Assert.assertTrue(registerPage.isRegisterPageTitleDisplayed());

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstnameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastnameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox("!nvalidema1l@");
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox("12345");
		registerPage.enterToConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Confirm_Not_Match_Password() {
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox("123457");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Register_Successfully() {
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
	}

	@Test
	public void Register_06_Existing_Email() {
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		Assert.assertTrue(registerPage.isRegisterPageTitleDisplayed());
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
