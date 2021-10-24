package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.*;

public class My_Account extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    LoginPageObject loginPage;
    OrderPageObject orderPage;
    RegisterPageObject registerPage;
    MyAccountPageObject myAccountPage;

    String email, password, firstName, lastName, birthDay, birthMonth, birthYear, updatedEmail, newPassword;
    String companyName, country, province, city, address1, address2, postalCode, phoneNumber, faxNumber;
    String productTitle, reviewTitle, reviewText;
    int ratingRadio;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        email = getRandomEmail();
        password = "123456";
        newPassword = "123457";
        firstName = "Automation";
        lastName = "FC";
        birthDay = "1";
        birthMonth = "January";
        birthYear = "1999";
        updatedEmail = getRandomEmail();
        companyName = "Automation FC";
        country = "Viet Nam";
        province = "Other";
        city = "Sai Gon";
        address1 = "227 Nguyen Van Cu";
        address2 = "268 Ly Thuong Kiet";
        postalCode = "700000";
        phoneNumber = "0123456789";
        faxNumber = "0123456789";
        productTitle = "Build your own computer";
        reviewTitle = "test reivew";
        reviewText = "this is a review";
        ratingRadio = 5;
    }

    @Test
    public void My_Account_01_Customer_Info() {
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        homePage.openHeaderPageByName(driver, "Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        Assert.assertTrue(registerPage.isRegisterPageTitleDisplayed());

        registerPage.clickToGenderMaleRadioButton();
        registerPage.enterToFirstnameTextbox("John");
        registerPage.enterToLastnameTextbox("Wick");
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

        registerPage.openHeaderPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
        Assert.assertTrue(myAccountPage.isCustomerPageTitleDisplayed());

        myAccountPage.clickToGenderFemaleRadioButtonInCustomer();
        myAccountPage.enterToFirstnameTextboxInCustomer(firstName);
        myAccountPage.enterToLastnameTextboxInCustomer(lastName);
        myAccountPage.selectDOBDropdownInCustomer(birthDay, birthMonth, birthYear);
        myAccountPage.enterToEmailTextboxInCustomer(updatedEmail);
        myAccountPage.enterToCompanyNameTextboxInCustomer(companyName);
        myAccountPage.clickToSaveButtonInCustomer();

        Assert.assertTrue(myAccountPage.isCustomerPageTitleDisplayed());
        Assert.assertTrue(myAccountPage.isGenderFemaleRadioButtonSelectedInCustomer());
        Assert.assertEquals(myAccountPage.getFirstnameTextboxInCustomer(), firstName);
        Assert.assertEquals(myAccountPage.getLastnameTextboxInCustomer(), lastName);
        Assert.assertTrue(myAccountPage.isDOBDropdownDisplayingCorrectInCustomer(birthDay, birthMonth, birthYear));
        Assert.assertEquals(myAccountPage.getEmailTextboxInCustomer(), updatedEmail);
        Assert.assertEquals(myAccountPage.getCompanyNameTextboxInCustomer(), companyName);
    }

    @Test
    public void My_Account_02_Add_Address() {
        myAccountPage.clickToAddressesMenu();
        Assert.assertTrue(myAccountPage.isAddressesPageTitleDisplayed());

        myAccountPage.clickToAddNewButtonInAddresses();
        myAccountPage.enterToFirstnameTextboxInAddresses(firstName);
        myAccountPage.enterToLastnameTextboxInAddresses(lastName);
        myAccountPage.enterToEmailTextboxInAddresses(updatedEmail);
        myAccountPage.enterToCompanyTextboxInAddresses(companyName);
        myAccountPage.selectToCountryDropdownInAddresses(country);
        myAccountPage.selectToStateProvinceDropdownInAddresses(province);
        myAccountPage.enterToCityTextboxInAddresses(city);
        myAccountPage.enterToAddress1TextboxInAddresses(address1);
        myAccountPage.enterToAddress2TextboxInAddresses(address2);
        myAccountPage.enterToZipPostalCodeTextboxInAddresses(postalCode);
        myAccountPage.enterToPhoneNumberTextboxInAddresses(phoneNumber);
        myAccountPage.enterToFaxNumberTextboxInAddresses(faxNumber);
        myAccountPage.clickToSaveButtonInAddresses();

        Assert.assertTrue(myAccountPage.isAddressesPageTitleDisplayed());
        Assert.assertTrue(myAccountPage.getFullnameTextInAddresses(firstName, lastName));
        Assert.assertTrue(myAccountPage.getEmailTextInAddresses(updatedEmail));
        Assert.assertTrue(myAccountPage.getPhoneTextInAddresses(phoneNumber));
        Assert.assertTrue(myAccountPage.getFaxTextInAddresses(faxNumber));
        Assert.assertEquals(myAccountPage.getCompanyNameTextInAddresses(), companyName);
        Assert.assertEquals(myAccountPage.getAddress1TextInAddresses(), address1);
        Assert.assertEquals(myAccountPage.getAddress2TextInAddresses(), address2);
        Assert.assertTrue(myAccountPage.getCityStateZipTextInAddresses(city, postalCode));
        Assert.assertEquals(myAccountPage.getCountryTextInAddresses(), country);
    }

    @Test
    public void My_Account_03_Change_Password() {
        myAccountPage.clickToChangePasswordMenu();
        Assert.assertTrue(myAccountPage.isChangePasswordPageTitleDisplayed());

        myAccountPage.enterToOldPasswordTextboxInChangePassword(password);
        myAccountPage.enterToNewPasswordTextboxInChangePassword(newPassword);
        myAccountPage.enterToConfirmPasswordTextboxInChangePassword(newPassword);
        myAccountPage.clickToChangePasswordButtonInChangePassword();
        Assert.assertEquals(myAccountPage.getNotificationBarTextInChangePassword(), "Password was changed");
        myAccountPage.clickToCloseNotificationBarButtonInChangePassword();

        myAccountPage.openHeaderPageByName(driver, "Log out");
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        homePage.openHeaderPageByName(driver, "Log in");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());

        loginPage.enterToEmailTextbox(updatedEmail);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidateErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
        loginPage.enterToPasswordTextbox(newPassword);
        loginPage.clickToLoginButton();
        Assert.assertTrue(loginPage.isLoginPageSliderDisplayed());
    }

    @Test
    public void My_Account_04_My_Product_Reviews() {
        loginPage.hoverToTopMenuByName(driver, "Computers ");
        loginPage.clickToMenuSublist(driver, "Desktops ");

        orderPage = PageGeneratorManager.getOrderPage(driver);
        orderPage.clickToProductTitle(driver, productTitle);
        orderPage.clickToMyProductReviewsMenu();
        Assert.assertEquals(orderPage.getProductPageTitle(), "Product reviews for " + productTitle);

        orderPage.enterToReviewTitleTextbox(reviewTitle);
        orderPage.enterToReviewTextTextbox(reviewText);
        orderPage.selectReviewRatingRadio(ratingRadio);
        orderPage.clickToSubmitReviewButton();
        Assert.assertTrue(orderPage.isReviewResultPageDisplayed());

        orderPage.openHeaderPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
        Assert.assertTrue(myAccountPage.isCustomerPageTitleDisplayed());

        myAccountPage.clickToMyProductReviewsMenu();
        Assert.assertTrue(myAccountPage.isMyProductReviewsPageTitleDisplayed());
        Assert.assertEquals(myAccountPage.getReviewTextInMyProductReviews(), reviewText);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
