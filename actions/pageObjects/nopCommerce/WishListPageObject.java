package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.WishListPageUI;

public class WishListPageObject extends BasePage {
    private final WebDriver driver;

    public WishListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWishListPageTitleDisplayed() {
        waitForElementVisible(driver, WishListPageUI.WISHLIST_PAGE_TITLE);
        return isElementDisplayed(driver, WishListPageUI.WISHLIST_PAGE_TITLE);
    }

    public boolean isWishListSharingPageTitleDisplayed(String firstName, String lastName) {
        waitForElementVisible(driver, WishListPageUI.WISHLIST_SHARING_PAGE_TITLE, "Wishlist of " + firstName + " " + lastName);
        return isElementDisplayed(driver, WishListPageUI.WISHLIST_SHARING_PAGE_TITLE, "Wishlist of " + firstName + " " + lastName);
    }

    public String getAddedProductName() {
        waitForElementVisible(driver, WishListPageUI.ADDED_PRODUCT_TEXT);
        return getElementText(driver, WishListPageUI.ADDED_PRODUCT_TEXT);
    }

    public void clickToShareLink() {
        waitForElementVisible(driver, WishListPageUI.SHARE_LINK);
        clickToElement(driver, WishListPageUI.SHARE_LINK);
    }

    public void backToPreviousPage() {
        backToPage(driver);
    }

    public void selectAddToCartCheckbox() {
        waitForElementVisible(driver, WishListPageUI.ADD_TO_CART_CHECKBOX);
        checkToCheckboxOrRadio(driver, WishListPageUI.ADD_TO_CART_CHECKBOX);
    }

    public void clickToAddToCartButton() {
        waitForElementVisible(driver, WishListPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishListPageUI.ADD_TO_CART_BUTTON);
    }

    public String getMessage() {
        waitForElementVisible(driver, WishListPageUI.MESSAGE);
        return getElementText(driver, WishListPageUI.MESSAGE);
    }

    public void clickToRemoveFromCartButton() {
        waitForElementVisible(driver, WishListPageUI.REMOVE_FROM_CART_BUTTON);
        clickToElement(driver, WishListPageUI.REMOVE_FROM_CART_BUTTON);
    }

    public boolean isProductUnDisplaying() {
        waitForElementInvisible(driver, WishListPageUI.ADDED_PRODUCT_TEXT);
        return isElementUnDisplayed(driver, WishListPageUI.ADDED_PRODUCT_TEXT);
    }
}
