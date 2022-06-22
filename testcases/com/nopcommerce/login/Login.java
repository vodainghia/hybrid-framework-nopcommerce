package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	String email, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		email = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.enterToEmailTextbox("asc#2@");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Login_03_Unregister_Email() {
        loginPage.enterToEmailTextbox(email);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidateErrorMessage(), "Login was unsuccessful. Please correct the " +
                "errors and try again.\nNo customer account found");
    }

	@Test
	public void Login_04_Empty_Password() {
		loginPage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		Assert.assertTrue(registerPage.isRegisterPageTitleDisplayed());

		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Wick");
		registerPage.enterToEmailTextbox(email);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        registerPage.openHeaderPageByName(driver, "Log out");
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        homePage.openHeaderPageByName(driver, "Log in");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());

        loginPage.enterToEmailTextbox(email);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidateErrorMessage(), "Login was unsuccessful. Please correct the " +
                "errors and try again.\nThe credentials provided are incorrect");
    }

	@Test
	public void Login_05_Uncorrect_Password() {
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox("123457");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidateErrorMessage(), "Login was unsuccessful. Please correct the " +
                "errors and try again.\nThe credentials provided are incorrect");
    }

	@Test
	public void Login_06_Login_Successfully() {
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isLoginPageSliderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}