package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	@FindBy(css = "input[id='Email']")
	WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void clickToLoginButton() {
		scrollToElement(driver, loginButton);
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}
}
