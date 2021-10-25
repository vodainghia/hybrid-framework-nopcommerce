package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.ProductPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Search extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    ProductPageObject productPage;
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
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.getSearchTermWarningMessage(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_02_Unexisting_Data() {
        productPage.enterToSearchKeywordTextbox(unexistingKeyword);
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_03_Relative_Data() {
        productPage.enterToSearchKeywordTextbox(relativeKeyword);
        productPage.clickToSearchButton();
        Assert.assertTrue(productPage.areAllResultsCorrect(relativeProductNames));
    }

    @Test
    public void Search_04_Absolute_Data() {
        productPage.enterToSearchKeywordTextbox(absoluteKeyword);
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.isResultCorrect(), "Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Test
    public void Search_05_Advanced_Search_With_Parent_Categories() {
        productPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        productPage.selectToAdvancedSearchCheckbox();
        productPage.selectToCategoryDropdown("Computers");
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_06_Advanced_Search_With_Sub_Categories() {
        productPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        productPage.selectToAdvancedSearchCheckbox();
        productPage.selectToCategoryDropdown("Computers");
        productPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.isResultCorrect(), "Apple MacBook Pro 13-inch");
    }

    @Test
    public void Search_07_Advanced_Search_With_Incorrect_Manufacturer() {
        productPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        productPage.selectToAdvancedSearchCheckbox();
        productPage.selectToCategoryDropdown("Computers");
        productPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        productPage.selectToManufacturerDropdown("HP");
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.getNoResultMessage(), "No products were found that matched your criteria.");
    }

    @Test
    public void Search_08_Advanced_Search_With_Correct_Manufacturer() {
        productPage.enterToSearchKeywordTextbox(advancedSearchKeyword);
        productPage.selectToAdvancedSearchCheckbox();
        productPage.selectToCategoryDropdown("Computers");
        productPage.selectToAutomaticallySearchSubCategoriesCheckbox();
        productPage.selectToManufacturerDropdown("Apple");
        productPage.clickToSearchButton();
        Assert.assertEquals(productPage.isResultCorrect(), "Apple MacBook Pro 13-inch");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
