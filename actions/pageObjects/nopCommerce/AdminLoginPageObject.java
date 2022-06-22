package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private final WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getAdminLoginPageTitle() {
        waitForElementVisible(driver, AdminLoginPageUI.ADMIN_LOGIN_PAGE_TITLE);
        return getElementText(driver, AdminLoginPageUI.ADMIN_LOGIN_PAGE_TITLE);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        //return PageGeneratorManager.getHomePage(driver);
    }
}