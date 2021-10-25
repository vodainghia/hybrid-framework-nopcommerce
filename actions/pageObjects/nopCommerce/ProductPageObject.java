package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductPageUI;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        sleepInSecond(2);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> expectedList = productNames.stream().sorted().collect(Collectors.toList());
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromZToA() {
        sleepInSecond(2);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> expectedList = productNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromLowToHigh() {
        sleepInSecond(2);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> expectedList = productNames.stream().sorted().collect(Collectors.toList());
        return productNames.equals(expectedList);
    }

    public boolean areAllResultsSortedFromHighToLow() {
        sleepInSecond(2);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_PRICE);
        List<String> expectedList = productNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return productNames.equals(expectedList);
    }

    public void selectToPageSizeDropdown(String pageSize) {
        waitForElementClickable(driver, ProductPageUI.PAGE_SIZE_DROPDOWN);
        selectDropdownByText(driver, ProductPageUI.PAGE_SIZE_DROPDOWN, pageSize);
    }

    public int returnedProductQuantity() {
        sleepInSecond(2);
        waitForAllElementVisible(driver, ProductPageUI.ITEM_BOX_TEXT);
        List<String> productNames = getElementsText(driver, ProductPageUI.ITEM_BOX_TEXT);
        return productNames.size();
    }

    public String getCurrentPage() {
        sleepInSecond(2);
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
}
