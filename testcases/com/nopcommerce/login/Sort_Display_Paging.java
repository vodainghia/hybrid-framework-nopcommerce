package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.ProductPageObject;

public class Sort_Display_Paging extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    ProductPageObject productPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
    }

    @Test
    public void Sort_Paging_01_Name_From_A_To_Z() {
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isHomePageSliderDisplayed());

        homePage.hoverToTopMenuByName(driver, "Computers ");
        homePage.clickToMenuSublist(driver, "Notebooks ");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.selectToSortByDropdown("Name: A to Z");
        Assert.assertTrue(productPage.areAllResultsSortedFromAToZ());
    }

    @Test
    public void Sort_Paging_02_Name_From_Z_To_A() {
        productPage.selectToSortByDropdown("Name: Z to A");
        Assert.assertTrue(productPage.areAllResultsSortedFromZToA());
    }

    @Test
    public void Sort_Paging_03_Name_From_Low_To_High() {
        productPage.selectToSortByDropdown("Price: Low to High");
        Assert.assertTrue(productPage.areAllResultsSortedFromLowToHigh());
    }

    @Test
    public void Sort_Paging_04_Name_From_High_To_Low() {
        productPage.selectToSortByDropdown("Price: High to Low");
        Assert.assertTrue(productPage.areAllResultsSortedFromHighToLow());
    }

    @Test
    public void Sort_Paging_05_Display_3_Products_Per_Page() {
        productPage.selectToPageSizeDropdown("3");
        Assert.assertEquals(productPage.returnedProductQuantity(), 3);
        Assert.assertEquals(productPage.getCurrentPage(), "1");
        Assert.assertTrue(productPage.isNextPageButtonDisplaying());

        productPage.clickToNextPageButton();
        Assert.assertEquals(productPage.getCurrentPage(), "2");
        Assert.assertTrue(productPage.isPreviousPageButtonDisplaying());
    }

    @Test
    public void Sort_Paging_06_Display_6_Products_Per_Page() {
        productPage.selectToPageSizeDropdown("6");
        Assert.assertEquals(productPage.returnedProductQuantity(), 6);
        Assert.assertTrue(productPage.isPagingUnDisplaying());
    }

    @Test
    public void Sort_Paging_07_Display_9_Products_Per_Page() {
        productPage.selectToPageSizeDropdown("9");
        Assert.assertEquals(productPage.returnedProductQuantity(), 6);
        Assert.assertTrue(productPage.isPagingUnDisplaying());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}