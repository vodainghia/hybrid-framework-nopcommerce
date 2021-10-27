package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
    private final WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingCartPageTitleDisplayed() {
        waitForElementVisible(driver, ShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE);
        return isElementDisplayed(driver, ShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE);
    }

    public String getAddedProductName() {
        waitForElementVisible(driver, ShoppingCartPageUI.ADDED_PRODUCT_TEXT);
        return getElementText(driver, ShoppingCartPageUI.ADDED_PRODUCT_TEXT);
    }
}
