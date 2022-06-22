package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
    private final WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageContentHeader() {
        waitForElementVisible(driver, AdminHomePageUI.PAGE_CONTENT_HEADER_TEXT);
        return getElementText(driver, AdminHomePageUI.PAGE_CONTENT_HEADER_TEXT);
    }

    public void clickToSidebarMenu(String sidebarMenu) {
        waitForElementClickable(driver, AdminHomePageUI.DYNAMIC_SIDEBAR_MENU, sidebarMenu);
        clickToElement(driver, AdminHomePageUI.DYNAMIC_SIDEBAR_MENU, sidebarMenu);
        clickToElement(driver, AdminHomePageUI.DYNAMIC_SIDEBAR_MENU, sidebarMenu);
    }

    public void clickToItemInSidebarMenu(String item) {
        waitForElementClickable(driver, AdminHomePageUI.DYNAMIC_ITEM_IN_SIDEBAR_MENU, item);
        clickToElement(driver, AdminHomePageUI.DYNAMIC_ITEM_IN_SIDEBAR_MENU, item);
    }

    public void enterToProductNameTextbox(String productName) {
        waitForElementClickable(driver, AdminHomePageUI.PRODUCT_NAME_TEXTBOX);
        sendkeyToElement(driver, AdminHomePageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, AdminHomePageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminHomePageUI.SEARCH_BUTTON);
        sleepInSecond(5);
    }
}