package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Search extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    OrderPageObject orderPage;
    RegisterPageObject registerPage;

    String email, password, unexistingKeyword, relativeKeyword, absoluteKeyword, advancedSearchKeyword;
    String[] relativeProductNames;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        email = getRandomEmail();
        password = "123456";
        unexistingKeyword = "Macbook Pro 2050";
        relativeKeyword = "Lenovo";
        relativeProductNames = new String[] {"Lenovo IdeaCentre 600 All-in-One PC", "Lenovo Thinkpad X1 Carbon Laptop"};
        absoluteKeyword = "ThinkPad X1 Carbon";
        advancedSearchKeyword = "Apple MacBook Pro";
    }

    @Test
    public void Search_01_Empty_Data() {
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

        registerPage.openFooterPageByName(driver, "Search");
        orderPage = PageGeneratorManager.getOrderPage(driver);
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.getSearchTermWarningMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_02_Unexisting_Data() {
        orderPage.enterToSearchKeywordTextbox(unexistingKeyword);
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_03_Relative_Data() {
        orderPage.enterToSearchKeywordTextbox(relativeKeyword);
        orderPage.clickToSearchButton();
        Assert.assertTrue(orderPage.areAllResultsCorrect(relativeProductNames));
    }

    @Test
    public void Search_04_Absolute_Data() {
        orderPage.enterToSearchKeywordTextbox(absoluteKeyword);
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.isResultCorrect(), "Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Test
    public void Search_05_Advanced_Search_With_Parent_Categories() {
        orderPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        orderPage.selectToAdvancedSearchCheckbox();
        orderPage.selectToCategoryDropdown("Computers");
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_06_Advanced_Search_With_Sub_Categories() {
        orderPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        orderPage.selectToAdvancedSearchCheckbox();
        orderPage.selectToCategoryDropdown("Computers");
        orderPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.isResultCorrect(), "Apple MacBook Pro 13-inch");
    }

    @Test
    public void Search_07_Advanced_Search_With_Incorrect_Manufacturer() {
        orderPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        orderPage.selectToAdvancedSearchCheckbox();
        orderPage.selectToCategoryDropdown("Computers");
        orderPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        orderPage.selectToManufacturerDropdown("HP");
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_08_Advanced_Search_With_Correct_Manufacturer() {
        orderPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        orderPage.selectToAdvancedSearchCheckbox();
        orderPage.selectToCategoryDropdown("Computers");
        orderPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        orderPage.selectToManufacturerDropdown("Apple");
        orderPage.clickToSearchButton();
        Assert.assertEquals(orderPage.isResultCorrect(), "Apple MacBook Pro 13-inch");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
