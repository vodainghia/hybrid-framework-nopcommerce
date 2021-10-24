package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.OrderPageUI;

import java.util.List;

public class OrderPageObject extends BasePage {
    private final WebDriver driver;
    private boolean isDisplayed;

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMyProductReviewsMenu() {
        waitForElementVisible(driver, OrderPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, OrderPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public String getProductPageTitle() {
        waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_PAGE_TITLE);
        return getElementText(driver, OrderPageUI.PRODUCT_REVIEW_PAGE_TITLE);
    }

    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementClickable(driver, OrderPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, OrderPageUI.PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void enterToReviewTextTextbox(String reviewText) {
        waitForElementClickable(driver, OrderPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX);
        sendkeyToElement(driver, OrderPageUI.PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void selectReviewRatingRadio(int ratingRadio) {
        switch (ratingRadio) {
            case 1:
                waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
                clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_RATING_1_POINT_RADIO);
                break;
            case 2:
                waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
                clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_RATING_2_POINT_RADIO);
                break;
            case 3:
                waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
                clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_RATING_3_POINT_RADIO);
                break;
            case 4:
                waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
                clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_RATING_4_POINT_RADIO);
                break;
            case 5:
                waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
                clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_RATING_5_POINT_RADIO);
                break;
            default:
                System.out.println("Please enter an integer from 1 to 5");
                break;
        }
    }

    public void clickToSubmitReviewButton() {
        waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
        clickToElement(driver, OrderPageUI.PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON);
    }

    public boolean isReviewResultPageDisplayed() {
        waitForElementVisible(driver, OrderPageUI.PRODUCT_REVIEW_RESULT_TEXT);
        return isElementDisplayed(driver, OrderPageUI.PRODUCT_REVIEW_RESULT_TEXT);
    }

    public void clickToSearchButton() {
        waitForElementVisible(driver, OrderPageUI.SEARCH_BUTTON);
        clickToElement(driver, OrderPageUI.SEARCH_BUTTON);
    }

    public String getSearchTermWarningMessage() {
        waitForElementVisible(driver, OrderPageUI.SEARCH_WARNING_MESSAGE);
        return getElementText(driver, OrderPageUI.SEARCH_WARNING_MESSAGE);
    }

    public void enterToSearchKeywordTextbox(String unexistingKeyword) {
        waitForElementClickable(driver, OrderPageUI.SEARCH_KEYWORD_TEXTBOX);
        sendkeyToElement(driver, OrderPageUI.SEARCH_KEYWORD_TEXTBOX, unexistingKeyword);
    }

    public String getNoResultMessage() {
        waitForElementVisible(driver, OrderPageUI.SEARCH_NO_RESULT_MESSAGE);
        return getElementText(driver, OrderPageUI.SEARCH_NO_RESULT_MESSAGE);
    }

    //option 1: worse performance, runtime = 1.4s
    public boolean areAllResultsCorrectly(String[] productNames) {
        waitForElementVisible(driver, OrderPageUI.SEARCH_RESULTS);
        for (String productName : productNames) {
            isDisplayed = isElementDisplayed(driver, OrderPageUI.DYNAMIC_SEARCH_RESULTS, productName);
            if (!isDisplayed) {
                break;
            }
        }
        return isDisplayed;
    }

    //option 2: better performance, runtime = 0.75s
    public boolean areAllResultsCorrect(String[] productNames) {
        waitForElementVisible(driver, OrderPageUI.SEARCH_RESULTS);
        List<String> elementsText = getElementsText(driver, OrderPageUI.SEARCH_RESULTS);
        for (String productName : productNames) {
            elementsText.remove(productName);
        }
        return elementsText.size() == 0;
    }

    public String isResultCorrect() {
        waitForElementVisible(driver, OrderPageUI.SEARCH_RESULTS);
        return getElementText(driver, OrderPageUI.SEARCH_RESULTS);
    }

    public void selectToAdvancedSearchCheckbox() {
        waitForElementClickable(driver, OrderPageUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckboxOrRadio(driver, OrderPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectToCategoryDropdown(String categoryName) {
        waitForElementClickable(driver, OrderPageUI.CATEGORY_DROPDOWN);
        selectDropdownByText(driver, OrderPageUI.CATEGORY_DROPDOWN, categoryName);
    }

    public void selectToAutomaticallySearchSubCategoriesCheckbox() {
        waitForElementClickable(driver, OrderPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        checkToCheckboxOrRadio(driver, OrderPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public void selectToManufacturerDropdown(String manufacturerName) {
        waitForElementClickable(driver, OrderPageUI.MANUFACTURER_DROPDOWN);
        selectDropdownByText(driver, OrderPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
    }
}
