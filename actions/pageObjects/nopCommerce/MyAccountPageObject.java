package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
    private WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCustomerPageTitleDisplayed() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_PAGE_TITLE);
        return isElementDisplayed(driver, MyAccountPageUI.CUSTOMER_PAGE_TITLE);
    }

    public void clickToGenderFemaleRadioButtonInCustomer() {
        scrollToElement(driver, MyAccountPageUI.CUSTOMER_GENDER_FEMALE_RADIO);
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_GENDER_FEMALE_RADIO);
        checkToCheckboxOrRadio(driver, MyAccountPageUI.CUSTOMER_GENDER_FEMALE_RADIO);
    }

    public void enterToFirstnameTextboxInCustomer(String firstName) {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CUSTOMER_FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastnameTextboxInCustomer(String lastName) {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_LASTNAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CUSTOMER_LASTNAME_TEXTBOX, lastName);
    }

    protected void selectBirthDayDropdownCustomer(String birthDay) {
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_BIRTHDAY_DROPDOWN);
        selectDropdownByText(driver, MyAccountPageUI.CUSTOMER_BIRTHDAY_DROPDOWN, birthDay);
    }

    protected void selectBirthMonthDropdownCustomer(String birthMonth) {
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_BIRTHMONTH_DROPDOWN);
        selectDropdownByText(driver, MyAccountPageUI.CUSTOMER_BIRTHMONTH_DROPDOWN, birthMonth);
    }

    protected void selectBirthYearDropdownCustomer(String birthYear) {
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_BIRTHYEAR_DROPDOWN);
        selectDropdownByText(driver, MyAccountPageUI.CUSTOMER_BIRTHYEAR_DROPDOWN, birthYear);
    }

    public void selectDOBDropdownInCustomer(String birthDay, String birthMonth, String birthYear) {
        selectBirthDayDropdownCustomer(birthDay);
        selectBirthMonthDropdownCustomer(birthMonth);
        selectBirthYearDropdownCustomer(birthYear);
    }

    public void enterToEmailTextboxInCustomer(String emailAddress) {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_EMAIL_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CUSTOMER_EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyNameTextboxInCustomer(String companyName) {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CUSTOMER_COMPANY_NAME_TEXTBOX, companyName);
    }

    public void clickToSaveButtonInCustomer() {
        scrollToElement(driver, MyAccountPageUI.CUSTOMER_SAVE_BUTTON);
        waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUI.CUSTOMER_SAVE_BUTTON);
    }

    public boolean isGenderFemaleRadioButtonSelectedInCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_GENDER_FEMALE_RADIO);
        return isElementSelected(driver, MyAccountPageUI.CUSTOMER_GENDER_FEMALE_RADIO);
    }

    public String getFirstnameTextboxInCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_FIRSTNAME_TEXTBOX);
        return getElementAttributeValue(driver, MyAccountPageUI.CUSTOMER_FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastnameTextboxInCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_LASTNAME_TEXTBOX);
        return getElementAttributeValue(driver, MyAccountPageUI.CUSTOMER_LASTNAME_TEXTBOX, "value");
    }

    public String getEmailTextboxInCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_EMAIL_TEXTBOX);
        return getElementAttributeValue(driver, MyAccountPageUI.CUSTOMER_EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameTextboxInCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_COMPANY_NAME_TEXTBOX);
        return getElementAttributeValue(driver, MyAccountPageUI.CUSTOMER_COMPANY_NAME_TEXTBOX, "value");
    }

    protected String getBirthDayDropdownCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_BIRTHDAY_DROPDOWN);
        return getSelectedItemDropdown(driver, MyAccountPageUI.CUSTOMER_BIRTHDAY_DROPDOWN);
    }

    protected String getBirthMonthDropdownCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_BIRTHMONTH_DROPDOWN);
        return getSelectedItemDropdown(driver, MyAccountPageUI.CUSTOMER_BIRTHMONTH_DROPDOWN);
    }

    protected String getBirthYearDropdownCustomer() {
        waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_BIRTHYEAR_DROPDOWN);
        return getSelectedItemDropdown(driver, MyAccountPageUI.CUSTOMER_BIRTHYEAR_DROPDOWN);
    }

    public boolean isDOBDropdownDisplayingCorrectInCustomer(String birthDay, String birthMonth, String birthYear) {
        return getBirthDayDropdownCustomer().equals(birthDay) && getBirthMonthDropdownCustomer().equals(birthMonth) && getBirthYearDropdownCustomer().equals(birthYear);
    }

    public void clickToAddressesMenu() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_MENU_LINK);
        clickToElement(driver, MyAccountPageUI.ADDRESSES_MENU_LINK);
    }

    public boolean isAddressesPageTitleDisplayed() {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_PAGE_TITLE);
        return isElementDisplayed(driver, MyAccountPageUI.ADDRESSES_PAGE_TITLE);
    }

    public void clickToAddNewButtonInAddresses() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_ADD_NEW_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADDRESSES_ADD_NEW_BUTTON);
    }

    public void enterToFirstnameTextboxInAddresses(String firstName) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastnameTextboxInAddresses(String lastName) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_LASTNAME_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextboxInAddresses(String updatedEmail) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_EMAIL_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_EMAIL_TEXTBOX, updatedEmail);
    }

    public void enterToCompanyTextboxInAddresses(String companyName) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_COMPANY_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_COMPANY_TEXTBOX, companyName);
    }

    public void selectToCountryDropdownInAddresses(String countryName) {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_COUNTRY_DROPDOWN);
        selectDropdownByText(driver, MyAccountPageUI.ADDRESSES_COUNTRY_DROPDOWN, countryName);
    }

    public void selectToStateProvinceDropdownInAddresses(String provinceName) {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_STATE_PROVINCE_DROPDOWN);
        selectDropdownByText(driver, MyAccountPageUI.ADDRESSES_STATE_PROVINCE_DROPDOWN, provinceName);
    }

    public void enterToCityTextboxInAddresses(String cityName) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_CITY_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_CITY_TEXTBOX, cityName);
    }

    public void enterToAddress1TextboxInAddresses(String address1) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_ADDRESS_1_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_ADDRESS_1_TEXTBOX, address1);
    }

    public void enterToAddress2TextboxInAddresses(String address2) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_ADDRESS_2_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_ADDRESS_2_TEXTBOX, address2);
    }

    public void enterToZipPostalCodeTextboxInAddresses(String postalCode) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_ZIP_POSTALCODE_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_ZIP_POSTALCODE_TEXTBOX, postalCode);
    }

    public void enterToPhoneNumberTextboxInAddresses(String phoneNumber) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void enterToFaxNumberTextboxInAddresses(String faxNumber) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_FAX_NUMBER_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.ADDRESSES_FAX_NUMBER_TEXTBOX, faxNumber);
    }

    public void clickToSaveButtonInAddresses() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADDRESSES_SAVE_BUTTON);
    }

    public boolean getFullnameTextInAddresses(String firstName, String lastName) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_FULLNAME_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_FULLNAME_TEXT).equals(firstName + " " + lastName);
    }

    public boolean getEmailTextInAddresses(String updatedEmail) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_EMAIL_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_EMAIL_TEXT).equals("Email: " + updatedEmail);
    }

    public boolean getPhoneTextInAddresses(String phoneNumber) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_PHONE_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_PHONE_TEXT).equals("Phone number: " + phoneNumber);
    }

    public boolean getFaxTextInAddresses(String faxNumber) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_FAX_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_FAX_TEXT).equals("Fax number: " + faxNumber);
    }

    public String getCompanyNameTextInAddresses() {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_COMPANY_NAME_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_COMPANY_NAME_TEXT);
    }

    public String getAddress1TextInAddresses() {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_ADDRESS1_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_ADDRESS1_TEXT);
    }

    public String getAddress2TextInAddresses() {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_ADDRESS2_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_ADDRESS2_TEXT);
    }

    public boolean getCityStateZipTextInAddresses(String city, String postalCode) {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_CITY_STATE_ZIP_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_CITY_STATE_ZIP_TEXT).equals(city + ", " + postalCode);
    }

    public String getCountryTextInAddresses() {
        waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_COUNTRY_TEXT);
        return getElementText(driver, MyAccountPageUI.ADDRESSES_COUNTRY_TEXT);
    }

    public void clickToChangePasswordMenu() {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_MENU_LINK);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_MENU_LINK);
    }

    public boolean isChangePasswordPageTitleDisplayed() {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_PAGE_TITLE);
        return isElementDisplayed(driver, MyAccountPageUI.CHANGE_PASSWORD_PAGE_TITLE);
    }

    public void enterToOldPasswordTextboxInChangePassword(String password) {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_OLD_PASSWORD_TEXTBOX, password);
    }

    public void enterToNewPasswordTextboxInChangePassword(String newPassword) {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void enterToConfirmPasswordTextboxInChangePassword(String newPassword) {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_CONFIRM_PASSWORD_TEXTBOX, newPassword);
    }

    public void clickToChangePasswordButtonInChangePassword() {
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_CHANGE_PASSWORD_BUTTON);
    }

    public String getNotificationBarTextInChangePassword() {
        waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_NOTIFICATION_BAR);
        return getElementText(driver, MyAccountPageUI.CHANGE_PASSWORD_NOTIFICATION_BAR);
    }

    public void clickToCloseNotificationBarButtonInChangePassword() {
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_NOTIFICATION_BAR_CLOSE_BUTTON);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_NOTIFICATION_BAR_CLOSE_BUTTON);
        waitForElementInvisible(driver, MyAccountPageUI.CHANGE_PASSWORD_NOTIFICATION_BAR_CLOSE_BUTTON);
    }

    public void clickToMyProductReviewsMenu() {
        waitForElementVisible(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_MENU_LINK);
        clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_MENU_LINK);
    }

    public boolean isMyProductReviewsPageTitleDisplayed() {
        waitForElementVisible(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_PAGE_TITLE);
        return isElementDisplayed(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_PAGE_TITLE);
    }

    public String getReviewTextInMyProductReviews() {
        waitForElementVisible(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_REVIEW_TEXT);
        return getElementText(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_REVIEW_TEXT);
    }

    public void clickToOrdersMenu() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_MENU_LINK);
        clickToElement(driver, MyAccountPageUI.ORDERS_MENU_LINK);
    }

    public String getOrderItemTitle() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_ITEM_TITLE);
        String orderNumberText = getElementText(driver, MyAccountPageUI.ORDERS_ORDER_ITEM_TITLE);
        return orderNumberText.substring(orderNumberText.length() - 4);
    }

    public void clickToDetailbutton() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_DETAIL_BUTTON);
        clickToElement(driver, MyAccountPageUI.ORDERS_ORDER_DETAIL_BUTTON);
    }

    public String getOrderNumberOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_OVERVIEW_TEXT);
        String orderNumberText = getElementText(driver, MyAccountPageUI.ORDERS_ORDER_OVERVIEW_TEXT);
        return orderNumberText.substring(orderNumberText.length() - 4);
    }

    public String getOrderDateOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_DATE_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_ORDER_DATE_TEXT);
    }

    public String getOrderStatusOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_STATUS_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_ORDER_STATUS_TEXT);
    }

    public String getOrderTotalOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_TOTAL_OVERVIEW_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_ORDER_TOTAL_OVERVIEW_TEXT);
    }

    public String getNameBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_NAME_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_NAME_TEXT);
    }

    public String getEmailBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_EMAIL_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_EMAIL_TEXT);
    }

    public String getPhoneBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_PHONE_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_PHONE_TEXT);
    }

    public String getFaxBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_FAX_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_FAX_TEXT);
    }

    public String getCompanyBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_COMPANY_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_COMPANY_TEXT);
    }

    public String getAddress1BillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_ADDRESS_1_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_ADDRESS_1_TEXT);
    }

    public String getCityStateZipBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_CITY_STATE_ZIP_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_CITY_STATE_ZIP_TEXT);
    }

    public String getCountryBillingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_BILLING_COUNTRY_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_BILLING_COUNTRY_TEXT);
    }

    public String getPaymentMethodOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_PAYMENT_METHOD_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_PAYMENT_METHOD_TEXT);
    }

    public String getPaymentStatusOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_PAYMENT_STATUS_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_PAYMENT_STATUS_TEXT);
    }

    public String getNameShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_NAME_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_NAME_TEXT);
    }

    public String getEmailShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_EMAIL_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_EMAIL_TEXT);
    }

    public String getPhoneShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_PHONE_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_PHONE_TEXT);
    }

    public String getFaxShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_FAX_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_FAX_TEXT);
    }

    public String getCompanyShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_COMPANY_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_COMPANY_TEXT);
    }

    public String getAddress1ShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_ADDRESS_1_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_ADDRESS_1_TEXT);
    }

    public String getCityStateZipShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_CITY_STATE_ZIP_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_CITY_STATE_ZIP_TEXT);
    }

    public String getCountryShippingOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_COUNTRY_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_COUNTRY_TEXT);
    }

    public String getShippingMethodOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_METHOD_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_METHOD_TEXT);
    }

    public String getShippingStatusOnOverview() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_STATUS_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_STATUS_TEXT);
    }

    public String getSkuOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SKU_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SKU_TEXT);
    }

    public String getProductNameOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_PRODUCT_NAME_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_PRODUCT_NAME_TEXT);
    }

    public String getUnitPriceOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_UNIT_PRICE_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_UNIT_PRICE_TEXT);
    }

    public String getQuantityOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_QUANTITY_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_QUANTITY_TEXT);
    }

    public String getSubTotalOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SUB_TOTAL_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SUB_TOTAL_TEXT);
    }

    public String getCartOptionOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_CART_OPTION_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_CART_OPTION_TEXT);
    }

    public String getOrderSubTotalOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_SUB_TOTAL_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_ORDER_SUB_TOTAL_TEXT);
    }

    public String getShippingCostOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_SHIPPING_COST_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_SHIPPING_COST_TEXT);
    }

    public String getTaxValueOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_TAX_VALUE_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_TAX_VALUE_TEXT);
    }

    public String getOrderTotalOnConfirmOrder() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_ORDER_TOTAL_TEXT);
        return getElementText(driver, MyAccountPageUI.ORDERS_ORDER_TOTAL_TEXT);
    }

    public void clickToReorderButton() {
        waitForElementVisible(driver, MyAccountPageUI.ORDERS_REORDER_BUTTON);
        clickToElement(driver, MyAccountPageUI.ORDERS_REORDER_BUTTON);
    }
}