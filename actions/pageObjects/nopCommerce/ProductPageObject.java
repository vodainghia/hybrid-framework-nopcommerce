package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;

import java.util.Arrays;
import java.util.List;

import static commons.utils.orderListString;

public class ProductPageObject extends BasePage {
    private final WebDriver driver;
    private boolean isDisplayed;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMyProductReviewsMenu() {
        waitForElementVisible(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public String getProductPageTitle() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_PAGE_TITLE);
        return getElementText(driver, ProductPageUI.PRODUCT_REVIEW_PAGE_TITLE);
    }

    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementClickable(driver, ProductPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void enterToReviewTextTextbox(String reviewText) {
        waitForElementClickable(driver, ProductPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void clickToProductTitle(String productTitle) {
        waitForElementClickable(driver, ProductPageUI.PRODUCT_TITLE, productTitle);
        clickToElement(driver, ProductPageUI.PRODUCT_TITLE, productTitle);
    }

    public void selectReviewRatingRadio(int ratingRadio) {
        switch (ratingRadio) {
            case 1:
                waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
                clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
                break;
            case 2:
                waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
                clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
                break;
            case 3:
                waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
                clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
                break;
            case 4:
                waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
                clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
                break;
            case 5:
                waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
                clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
                break;
            default:
                System.out.println("Please enter an integer from 1 to 5");
                break;
        }
    }

    public void clickToSubmitReviewButton() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
        clickToElement(driver, ProductPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
    }

    public boolean isReviewResultPageDisplayed() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_REVIEW_RESULT_TEXT);
        return isElementDisplayed(driver, ProductPageUI.PRODUCT_REVIEW_RESULT_TEXT);
    }

    public String getProductOverviewPageTitle() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_OVERVIEW_TEXT);
        return getElementText(driver, ProductPageUI.PRODUCT_OVERVIEW_TEXT);
    }

    public void clickToSearchButton() {
        waitForElementVisible(driver, ProductPageUI.SEARCH_BUTTON);
        clickToElement(driver, ProductPageUI.SEARCH_BUTTON);
    }

    public String getSearchTermWarningMessage() {
        waitForElementVisible(driver, ProductPageUI.SEARCH_WARNING_MESSAGE);
        return getElementText(driver, ProductPageUI.SEARCH_WARNING_MESSAGE);
    }

    public void enterToSearchKeywordTextbox(String unexistingKeyword) {
        waitForElementClickable(driver, ProductPageUI.SEARCH_KEYWORD_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.SEARCH_KEYWORD_TEXTBOX, unexistingKeyword);
    }

    public String getNoResultMessage() {
        waitForElementVisible(driver, ProductPageUI.SEARCH_NO_RESULT_MESSAGE);
        return getElementText(driver, ProductPageUI.SEARCH_NO_RESULT_MESSAGE);
    }

    //option 1: worse performance, runtime = 1.4s
    public boolean areAllResultsCorrectly(String[] productNames) {
        waitForElementVisible(driver, ProductPageUI.SEARCH_RESULTS);
        for (String productName : productNames) {
            isDisplayed = isElementDisplayed(driver, ProductPageUI.DYNAMIC_SEARCH_RESULTS, productName);
            if (!isDisplayed) {
                break;
            }
        }
        return isDisplayed;
    }

    //option 2: better performance, runtime = 0.75s
    public boolean areAllResultsCorrect(String[] productNames) {
        waitForElementVisible(driver, ProductPageUI.SEARCH_RESULTS);
        List<String> elementsText = getElementsText(driver, ProductPageUI.SEARCH_RESULTS);
        for (String productName : productNames) {
            elementsText.remove(productName);
        }
        return elementsText.size() == 0;
    }

    public String isResultCorrect() {
        waitForElementVisible(driver, ProductPageUI.SEARCH_RESULTS);
        return getElementText(driver, ProductPageUI.SEARCH_RESULTS);
    }

    public void selectToAdvancedSearchCheckbox() {
        waitForElementClickable(driver, ProductPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckboxOrRadio(driver, ProductPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectToCategoryDropdown(String categoryName) {
        waitForElementClickable(driver, ProductPageUI.CATEGORY_DROPDOWN);
        selectDropdownByText(driver, ProductPageUI.CATEGORY_DROPDOWN, categoryName);
    }

    public void selectToAutomaticallySearchSubCategoriesCheckbox() {
        waitForElementClickable(driver, ProductPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        checkToCheckboxOrRadio(driver, ProductPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public void selectToManufacturerDropdown(String manufacturerName) {
        waitForElementClickable(driver, ProductPageUI.MANUFACTURER_DROPDOWN);
        selectDropdownByText(driver, ProductPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
    }

    public void selectToSortByDropdown(String sortCriteria) {
        waitForElementClickable(driver, ProductPageUI.SORT_BY_DROPDOWN);
        selectDropdownByText(driver, ProductPageUI.SORT_BY_DROPDOWN, sortCriteria);
    }

    public boolean areAllResultsSortedFromAToZ() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> expectedList = orderListString(productNames);
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromZToA() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> expectedList = orderListString(productNames);
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromLowToHigh() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> expectedList = orderListString(productNames);
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromHighToLow() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> expectedList = orderListString(productNames);
        return productNames.equals(expectedList);
    }

    public void selectToPageSizeDropdown(String pageSize) {
        waitForElementClickable(driver, ProductPageUI.PAGE_SIZE_DROPDOWN);
        selectDropdownByText(driver, ProductPageUI.PAGE_SIZE_DROPDOWN, pageSize);
    }

    public int returnedProductQuantity() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        return productNames.size();
    }

    public String getCurrentPage() {
        waitForElementInvisible(driver, ProductPageUI.AJAX_PRODUCT_BUSY);
        waitForElementVisible(driver, ProductPageUI.CURRENT_PAGE_BUTTON);
        return getElementText(driver, ProductPageUI.CURRENT_PAGE_BUTTON);
    }

    public boolean isNextPageButtonDisplaying() {
        return isElementDisplayed(driver, ProductPageUI.NEXT_PAGE_BUTTON);
    }

    public void clickToNextPageButton() {
        waitForElementVisible(driver, ProductPageUI.NEXT_PAGE_BUTTON);
        clickToElement(driver, ProductPageUI.NEXT_PAGE_BUTTON);
    }

    public boolean isPreviousPageButtonDisplaying() {
        return isElementDisplayed(driver, ProductPageUI.PREVIOUS_PAGE_BUTTON);
    }

    public boolean isPagingUnDisplaying() {
        waitForElementInvisible(driver, ProductPageUI.PAGING);
        return isElementUnDisplayed(driver, ProductPageUI.PAGING);
    }

    public void clickToAddToWishlistButton() {
        waitForElementVisible(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public String getBarNotificationText() {
        waitForElementVisible(driver, ProductPageUI.BAR_NOTIFICATION_TEXT);
        return getElementText(driver, ProductPageUI.BAR_NOTIFICATION_TEXT);
    }

    public void clickToCloseBarNotification() {
        waitForElementVisible(driver, ProductPageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
        clickToElement(driver, ProductPageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
        waitForElementInvisible(driver, ProductPageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
    }

    public void clickToAddToCompareListButton(String productTitle) {
        waitForElementVisible(driver, ProductPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON, productTitle);
        clickToElement(driver, ProductPageUI.DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON, productTitle);
    }

    public String getProductPrice(String productTitle) {
        waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productTitle);
        return getElementText(driver, ProductPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productTitle);
    }

    public boolean areProductNamesDisplayingCorrect(String... params) {
        waitForAllElementVisible(driver, ProductPageUI.PRODUCT_TITLE_LIST);
        List<String> productNames = getElementsText(driver, ProductPageUI.PRODUCT_TITLE_LIST);
        List<String> expectedList = Arrays.asList(params);
        return orderListString(productNames).equals(orderListString(expectedList));
    }

    public boolean areProductPricesDisplayingCorrect(String... params) {
        waitForAllElementVisible(driver, ProductPageUI.PRODUCT_PRICE_LIST);
        List<String> productPrices = getElementsText(driver, ProductPageUI.PRODUCT_PRICE_LIST);
        List<String> expectedList = Arrays.asList(params);
        return orderListString(productPrices).equals(orderListString(expectedList));
    }

    public void clickToClearListButton() {
        waitForElementVisible(driver, ProductPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, ProductPageUI.CLEAR_LIST_BUTTON);
    }

    public String getMessage() {
        waitForElementVisible(driver, ProductPageUI.MESSAGE);
        return getElementText(driver, ProductPageUI.MESSAGE);
    }

    public boolean areProductUnDisplaying() {
        waitForElementInvisible(driver, ProductPageUI.PRODUCT_TITLE_LIST);
        return isElementUnDisplayed(driver, ProductPageUI.PRODUCT_TITLE_LIST);
    }

    public void viewProductDetailsSerial(String categoryName, String subCategoryName, String[] productNames) {
        for (String productName : productNames) {
            hoverToTopMenuByName(driver, categoryName);
            clickToMenuSublist(driver, subCategoryName);
            clickToProductTitle(productName);
        }
    }
}