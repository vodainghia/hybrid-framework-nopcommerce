package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;
import pageUIs.nopCommerce.MyAccountPageUI;

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

	public void clickToMyProductReviewsMenu() {
		waitForElementVisible(driver, LoginPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, LoginPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public String getProductPageTitle() {
		waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_PAGE_TITLE);
		return getElementText(driver, LoginPageUI.PRODUCT_REVIEW_PAGE_TITLE);
	}

	public void enterToReviewTitleTextbox(String reviewTitle) {
		waitForElementClickable(driver, LoginPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void enterToReviewTextTextbox(String reviewText) {
		waitForElementClickable(driver, LoginPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX, reviewText);
	}

	public void selectReviewRatingRadio(int ratingRadio) {
		switch (ratingRadio) {
			case 1:
				waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
				clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
				break;
			case 2:
				waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
				clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
				break;
			case 3:
				waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
				clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
				break;
			case 4:
				waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
				clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
				break;
			case 5:
				waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
				clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
				break;
			default:
				System.out.println("Please enter an integer from 1 to 5");
				break;
		}
	}

	public void clickToSubmitReviewButton() {
		waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
		clickToElement(driver, LoginPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
	}

	public boolean isReviewResultPageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.PRODUCT_REVIEW_RESULT_TEXT);
		return isElementDisplayed(driver, LoginPageUI.PRODUCT_REVIEW_RESULT_TEXT);
	}
}
