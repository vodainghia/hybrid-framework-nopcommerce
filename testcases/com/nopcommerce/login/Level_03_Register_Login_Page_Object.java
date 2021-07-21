package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	BasePage basePage;
	String emailPassword, password;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		emailPassword = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		// step 1: Open URL -> Home page
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		// step 2: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// step 3: Click to Register link -> Register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
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
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		
		// step 13: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		// step 1: Click to Login link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		// step 2: Input to Email texbox
		loginPage.enterToEmailTextbox(emailPassword);
		
		// step 3: Input to Password texbox
		loginPage.enterToPasswordTextbox(password);
		
		// step 4: Click to Login button
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		
		// step 5: Verify Home page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(99999) + "@live.com";
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
