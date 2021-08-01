package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		scrollToElement(driver, LoginPageUI.LOGIN_BUTTON);
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isLoginPageTitleDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_PAGE_TITLE);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_PAGE_TITLE);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getValidateErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE);
	}

	public boolean isLoginPageSliderDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_PAGE_SLIDER);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_PAGE_SLIDER);
	}

}
