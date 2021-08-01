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
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator extends BaseTest {
	WebDriver driver;
	BasePage basePage;
	String emailPassword, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailPassword = getRandomEmail();
		password = "123456";
		
		// step 1: Open URL -> Home page
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_01_Register_To_System() {
		// step 2: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// step 3: Click to Register link -> Register page
		//registerPage = homePage.clickToRegisterLink();
		
		// step 4: Click to Gender male radio
		registerPage.clickToGenderMaleRadioButton();
		
		// step 5: Input to Firstname textbox
		registerPage.enterToFirstnameTextbox("John");
		
		// step 6: Input to Lastname textbox
		registerPage.enterToLastnameTextbox("Wick");
		
		// step 7: Input to Email textbox
		registerPage.enterToEmailTextbox(emailPassword);
		
		// step 8: Input to Password textbox
		registerPage.enterToPasswordTextbox(password);
		
		// step 9: Input to Confirm Password textbox
		registerPage.enterToConfirmPasswordTextbox(password);
		
		// step 10: Click to Register button
		registerPage.clickToRegisterButton();
		
		// step 11: Verify success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		// step 12: Click to Logout link -> Home page
		//homePage = registerPage.clickToLogoutLink();
		
		// step 13: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		// step 1: Click to Login link
		//loginPage = homePage.clickToLoginLink();
		
		// step 2: Input to Email texbox
		loginPage.enterToEmailTextbox(emailPassword);
		
		// step 3: Input to Password texbox
		loginPage.enterToPasswordTextbox(password);
		
		// step 4: Click to Login button
		homePage = loginPage.clickToLoginButton();
		
		// step 5: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
