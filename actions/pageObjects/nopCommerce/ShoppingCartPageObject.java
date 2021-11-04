package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.ShoppingCartPageUI;

import java.util.ArrayList;
import java.util.List;

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

    public void clickToEditButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.EDIT_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.EDIT_BUTTON);
    }

    public void clickToRemoveButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON);
    }

    public String getMessage() {
        waitForElementVisible(driver, ShoppingCartPageUI.MESSAGE);
        return getElementText(driver, ShoppingCartPageUI.MESSAGE);
    }

    public boolean isProductUnDisplaying() {
        waitForElementInvisible(driver, ShoppingCartPageUI.ADDED_PRODUCT_TEXT);
        return isElementUnDisplayed(driver, ShoppingCartPageUI.ADDED_PRODUCT_TEXT);
    }

    public void enterToQuantityTextbox(String quantity) {
        waitForElementClickable(driver, ShoppingCartPageUI.QUANTITY_SHOPPING_CART_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_SHOPPING_CART_TEXTBOX, quantity);
    }

    public void clickToUpdateShoppingCartButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
    }

    public String getSkuOnShoppingCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.SKU_SHOPPING_CART_TEXT);
        return getElementText(driver, ShoppingCartPageUI.SKU_SHOPPING_CART_TEXT);
    }

    public String getUnitPriceOnShoppingCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.UNIT_PRICE_SHOPPING_CART_TEXT);
        return getElementText(driver, ShoppingCartPageUI.UNIT_PRICE_SHOPPING_CART_TEXT);
    }

    public String getQuantityOnShoppingCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_SHOPPING_CART_TEXTBOX);
        return getElementAttributeValue(driver, ShoppingCartPageUI.QUANTITY_SHOPPING_CART_TEXTBOX, "value");
    }

    public String getSubTotalOnShoppingCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.PRODUCT_SUB_TOTAL_SHOPPING_CART_TEXT);
        return getElementText(driver, ShoppingCartPageUI.PRODUCT_SUB_TOTAL_SHOPPING_CART_TEXT);
    }

    public String getOrderTotalOnShoppingCart() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_TOTAL_SHOPPING_CART_TEXTBOX);
        return getElementText(driver, ShoppingCartPageUI.ORDER_TOTAL_SHOPPING_CART_TEXTBOX);
    }

    public void selectToGiftWrappingDropdown(String item) {
        waitForElementClickable(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, item);
    }

    public void selectToTermOfServiceCheckbox() {
        waitForElementClickable(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
        checkToCheckboxOrRadio(driver, ShoppingCartPageUI.TERM_OF_SERVICE_CHECKBOX);
    }

    public void clickToCheckoutButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        checkToCheckboxOrRadio(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
    }

    public void unSelectToShipToSameAddressCheckbox() {
        waitForElementClickable(driver, ShoppingCartPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        uncheckToCheckbox(driver, ShoppingCartPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void selectToCountryBillingDropdown(String country) {
        waitForElementClickable(driver, ShoppingCartPageUI.COUNTRY_BILLING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.COUNTRY_BILLING_DROPDOWN, country);
    }

    public void selectToStateProvinceBillingDropdown(String state) {
        waitForElementClickable(driver, ShoppingCartPageUI.STATE_PROVINCE_BILLING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.STATE_PROVINCE_BILLING_DROPDOWN, state);
    }

    public void enterToCityBillingTextbox(String city) {
        waitForElementClickable(driver, ShoppingCartPageUI.CITY_BILLING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.CITY_BILLING_TEXTBOX, city);
    }

    public void enterToAddress1BillingTextbox(String address) {
        waitForElementClickable(driver, ShoppingCartPageUI.ADDRESS_1_BILLING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.ADDRESS_1_BILLING_TEXTBOX, address);
    }

    public void enterToPostalCodeBillingTextbox(String zip) {
        waitForElementClickable(driver, ShoppingCartPageUI.POSTAL_CODE_BILLING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.POSTAL_CODE_BILLING_TEXTBOX, zip);
    }

    public void enterToPhoneNumberBillingTextbox(String phone) {
        waitForElementClickable(driver, ShoppingCartPageUI.PHONE_NUMBER_BILLING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.PHONE_NUMBER_BILLING_TEXTBOX, phone);
    }

    public void clickToContinueBillingButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTINUE_BILLING_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONTINUE_BILLING_BUTTON);
    }

    public void selectToNewAddressShippingDropdown(String address) {
        waitForElementClickable(driver, ShoppingCartPageUI.ADDRESS_SELECT_SHIPPING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.ADDRESS_SELECT_SHIPPING_DROPDOWN, address);
    }

    public void enterToFirstnameShippingTextbox(String firstNameShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.FIRSTNAME_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.FIRSTNAME_SHIPPING_TEXTBOX, firstNameShipping);
    }

    public void enterToLastnameShippingTextbox(String lastNameShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.LASTNAME_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.LASTNAME_SHIPPING_TEXTBOX, lastNameShipping);
    }

    public void enterToEmailShippingTextbox(String emailShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.EMAIL_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.EMAIL_SHIPPING_TEXTBOX, emailShipping);
    }

    public void selectToCountryShippingDropdown(String countryShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.COUNTRY_SHIPPING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.COUNTRY_SHIPPING_DROPDOWN, countryShipping);
        sleepInSecond(1);
    }

    public void selectToStateProvinceShippingDropdown(String stateShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.STATE_SHIPPING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.STATE_SHIPPING_DROPDOWN, stateShipping);
    }

    public void enterToCityShippingTextbox(String cityShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.CITY_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.CITY_SHIPPING_TEXTBOX, cityShipping);
    }

    public void enterToAddress1ShippingTextbox(String addressShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.ADDRESS_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.ADDRESS_SHIPPING_TEXTBOX, addressShipping);
    }

    public void enterToPostalCodeShippingTextbox(String zipShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.ZIP_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.ZIP_SHIPPING_TEXTBOX, zipShipping);
    }

    public void enterToPhoneNumberShippingTextbox(String phoneNumberShipping) {
        waitForElementClickable(driver, ShoppingCartPageUI.PHONE_NUMBER_SHIPPING_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.PHONE_NUMBER_SHIPPING_TEXTBOX, phoneNumberShipping);
    }

    public void clickToContinueShippingButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTINUE_SHIPPING_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONTINUE_SHIPPING_BUTTON);
    }

    public void selectToShippingMethodRadio(String shippingMethod) {
        waitForElementClickable(driver, ShoppingCartPageUI.DYNAMIC_SHIPPING_METHOD_RADIO, shippingMethod);
        checkToCheckboxOrRadio(driver, ShoppingCartPageUI.DYNAMIC_SHIPPING_METHOD_RADIO, shippingMethod);
    }

    public void clickToContinueShippingMethodButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONTINUE_SHIPPING_METHOD_BUTTON);
    }

    public void selectToPaymentMethodRadio(String paymentMethod) {
        waitForElementClickable(driver, ShoppingCartPageUI.DYNAMIC_PAYMENT_METHOD_RADIO, paymentMethod);
        checkToCheckboxOrRadio(driver, ShoppingCartPageUI.DYNAMIC_PAYMENT_METHOD_RADIO, paymentMethod);
    }

    public void clickToContinuePaymentMethodButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTINUE_PAYMENT_METHOD_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONTINUE_PAYMENT_METHOD_BUTTON);
    }

    public String getPaymentInforDisplaying() {
        waitForElementVisible(driver, ShoppingCartPageUI.PAYMENT_INFOR_TEXT);
        return getElementText(driver, ShoppingCartPageUI.PAYMENT_INFOR_TEXT);
    }

    public void clickToContinuePaymentInforButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONTINUE_PAYMENT_INFOR_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONTINUE_PAYMENT_INFOR_BUTTON);
    }

    public boolean areBillingAddressDisplayingOnConfirmOrder(ArrayList<String> list) {
        waitForAllElementVisible(driver, ShoppingCartPageUI.BILLING_INFOR_CONFIRM_ORDER_LIST);
        List<String> attrs = getElementsText(driver, ShoppingCartPageUI.BILLING_INFOR_CONFIRM_ORDER_LIST);
        list.removeIf(attrs::contains);
        return list.size() == 0;
    }

    public String getNameBillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_NAME_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_NAME_TEXT);
    }

    public String getEmailBillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_EMAIL_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_EMAIL_TEXT);
    }

    public String getPhoneBillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_PHONE_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_PHONE_TEXT);
    }

    public String getFaxBillingOnOverview() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_FAX_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_FAX_TEXT);
    }

    public String getCompanyBillingOnOverview() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_COMPANY_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_COMPANY_TEXT);
    }

    public String getAddress1BillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_ADDRESS_1_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_ADDRESS_1_TEXT);
    }

    public String getCityStateZipBillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_CITY_STATE_ZIP_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_CITY_STATE_ZIP_TEXT);
    }

    public String getCountryBillingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_COUNTRY_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_BILLING_COUNTRY_TEXT);
    }

    public String getPaymentMethodOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_PAYMENT_METHOD_TEXT);
    }

    public boolean areShippingAddressDisplayingOnConfirmOrder(ArrayList<String> list) {
        waitForAllElementVisible(driver, ShoppingCartPageUI.SHIPPING_INFOR_CONFIRM_ORDER_LIST);
        List<String> attrs = getElementsText(driver, ShoppingCartPageUI.SHIPPING_INFOR_CONFIRM_ORDER_LIST);
        list.removeIf(attrs::contains);
        return list.size() == 0;
    }

    public String getNameShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_NAME_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_NAME_TEXT);
    }

    public String getEmailShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_EMAIL_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_EMAIL_TEXT);
    }

    public String getPhoneShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_PHONE_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_PHONE_TEXT);
    }

    public String getFaxShippingOnOverview() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_FAX_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_FAX_TEXT);
    }

    public String getCompanyShippingOnOverview() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COMPANY_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COMPANY_TEXT);
    }

    public String getAddress1ShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_ADDRESS_1_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_ADDRESS_1_TEXT);
    }

    public String getCityStateZipShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_CITY_STATE_ZIP_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_CITY_STATE_ZIP_TEXT);
    }

    public String getCountryShippingOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COUNTRY_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COUNTRY_TEXT);
    }

    public String getShippingMethodOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_METHOD_TEXT);
    }

    public String getSkuOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SKU_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SKU_TEXT);
    }

    public String getProductNameOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_PRODUCT_NAME_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_PRODUCT_NAME_TEXT);
    }

    public String getUnitPriceOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_UNIT_PRICE_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_UNIT_PRICE_TEXT);
    }

    public String getQuantityOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_QUANTITY_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_QUANTITY_TEXT);
    }

    public String getSubTotalOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SUB_TOTAL_TEXT);
    }

    public String getCartOptionOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_CART_OPTION_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_CART_OPTION_TEXT);
    }

    public String getOrderSubTotalOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_ORDER_SUB_TOTAL_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_ORDER_SUB_TOTAL_TEXT);
    }

    public String getShippingCostOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_SHIPPING_COST_TEXT);
    }

    public String getTaxValueOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_TAX_VALUE_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_TAX_VALUE_TEXT);
    }

    public String getOrderTotalOnConfirmOrder() {
        waitForElementVisible(driver, ShoppingCartPageUI.CONFIRM_ORDER_ORDER_TOTAL_TEXT);
        return getElementText(driver, ShoppingCartPageUI.CONFIRM_ORDER_ORDER_TOTAL_TEXT);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CONFIRM_ORDER_CONFIRM_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CONFIRM_ORDER_CONFIRM_BUTTON);
    }

    public String getOrderCompletePageTitle() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_COMPLETE_PAGE_TITLE);
        return getElementText(driver, ShoppingCartPageUI.ORDER_COMPLETE_PAGE_TITLE);
    }

    public String getOrderCompleteTitle() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_COMPLETE_TITLE);
        return getElementText(driver, ShoppingCartPageUI.ORDER_COMPLETE_TITLE);
    }

    public String getOrderNumberText() {
        waitForElementVisible(driver, ShoppingCartPageUI.ORDER_NUMBER_TEXT);
        String orderNumberText = getElementText(driver, ShoppingCartPageUI.ORDER_NUMBER_TEXT);
        return orderNumberText.substring(orderNumberText.length() - 4);
    }

    public void selectToCreditCartDropdown(String visaCreditCard) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_CREDIT_CARD_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.PAYMENT_INFOR_CREDIT_CARD_DROPDOWN, visaCreditCard);
    }

    public void enterToCardholderNameTextbox(String cardHolderName) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_HOLDER_NAME_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_HOLDER_NAME_DROPDOWN, cardHolderName);
    }

    public void enterToCardNumberTextbox(String cardNumber) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_NUMBER_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_NUMBER_DROPDOWN, cardNumber);
    }

    public void selectToExpirationMonthDropdown(String expirationMonth) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_EXPIRATION_MONTH_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.PAYMENT_INFOR_EXPIRATION_MONTH_DROPDOWN, expirationMonth);
    }

    public void selectToExpirationYearDropdown(String expirationYear) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_EXPIRATION_YEAR_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.PAYMENT_INFOR_EXPIRATION_YEAR_DROPDOWN, expirationYear);
    }

    public void enterToCardCodeTextbox(String cardCode) {
        waitForElementClickable(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_CODE_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.PAYMENT_INFOR_CARD_CODE_DROPDOWN, cardCode);
    }

    public void waitForSomeSeconds(int seconds) {
        sleepInSecond(seconds);
    }

    public void selectToNewAddressbillingDropdown(String address) {
        waitForElementClickable(driver, ShoppingCartPageUI.ADDRESS_SELECT_BILLING_DROPDOWN);
        selectDropdownByText(driver, ShoppingCartPageUI.ADDRESS_SELECT_BILLING_DROPDOWN, address);
    }

    public void enterToFirstnameBillingTextbox(String firstName) {
        waitForElementClickable(driver, ShoppingCartPageUI.FIRSTNAME_BILLING_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.FIRSTNAME_BILLING_DROPDOWN, firstName);
    }

    public void enterToLastnameBillingTextbox(String lastName) {
        waitForElementClickable(driver, ShoppingCartPageUI.LASTNAME_BILLING_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.LASTNAME_BILLING_DROPDOWN, lastName);
    }

    public void enterToEmailBillingTextbox(String email) {
        waitForElementClickable(driver, ShoppingCartPageUI.EMAIL_BILLING_DROPDOWN);
        sendkeyToElement(driver, ShoppingCartPageUI.EMAIL_BILLING_DROPDOWN, email);
    }
}