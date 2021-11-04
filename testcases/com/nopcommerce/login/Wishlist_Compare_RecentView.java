package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

public class Wishlist_Compare_RecentView extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    ProductPageObject productPage;
    RegisterPageObject registerPage;
    WishListPageObject wishListPage;
    ShoppingCartPageObject shoppingCartPage;

    String firstName, lastName, email, password, productTitleMacbookPro, productPriceMacbookPro, productTitleSamsungUltrabook;
    String productPriceSamsungUltrabook, productTitleAsusLaptop, productTitleHPSpectre, productTitleHPEnvy;
    String[] productNames;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        firstName = "John";
        lastName = "Wick";
        email = getRandomEmail();
        password = "123456";
        productTitleMacbookPro = "Apple MacBook Pro 13-inch";
        productTitleSamsungUltrabook = "Samsung Series 9 NP900X4C Premium Ultrabook";
        productTitleAsusLaptop = "Asus N551JK-XO076H Laptop";
        productTitleHPSpectre = "HP Spectre XT Pro UltraBook";
        productTitleHPEnvy = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        productNames = new String[]{productTitleMacbookPro, productTitleSamsungUltrabook, productTitleAsusLaptop, productTitleHPSpectre, productTitleHPEnvy};
    }

    @Test
    public void Wishlist_Compare_RecentView_01_Add_To_Wishlist() {
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.openHeaderPageByName(driver, "Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        registerPage.clickToGenderMaleRadioButton();
        registerPage.enterToFirstnameTextbox(firstName);
        registerPage.enterToLastnameTextbox(lastName);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        registerPage.hoverToTopMenuByName(driver, "Computers");
        registerPage.clickToMenuSublist(driver, "Notebooks");

        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleMacbookPro);
        Assert.assertEquals(productPage.getProductOverviewPageTitle(), productTitleMacbookPro);

        productPage.clickToAddToWishlistButton();
        Assert.assertEquals(productPage.getBarNotificationText(), "The product has been added to your wishlist");

        productPage.clickToCloseBarNotification();
        productPage.openHeaderPageByName(driver, "Wishlist");
        wishListPage = PageGeneratorManager.getWishlistPage(driver);
        Assert.assertTrue(wishListPage.isWishListPageTitleDisplayed());
        Assert.assertEquals(wishListPage.getAddedProductName(), productTitleMacbookPro);

        wishListPage.clickToShareLink();
        Assert.assertTrue(wishListPage.isWishListSharingPageTitleDisplayed(firstName, lastName));
    }

    @Test
    public void Wishlist_Compare_RecentView_02_Add_Product_To_Cart_From_Wishlist() {
        wishListPage.backToPreviousPage();
        Assert.assertTrue(wishListPage.isWishListPageTitleDisplayed());

        wishListPage.selectAddToCartCheckbox();
        wishListPage.clickToAddToCartButton();
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.isShoppingCartPageTitleDisplayed());
        Assert.assertEquals(shoppingCartPage.getAddedProductName(), productTitleMacbookPro);

        shoppingCartPage.openHeaderPageByName(driver, "Wishlist");
        wishListPage = PageGeneratorManager.getWishlistPage(driver);
        Assert.assertTrue(wishListPage.isWishListPageTitleDisplayed());
        Assert.assertEquals(wishListPage.getMessage(), "The wishlist is empty!");
    }

    @Test
    public void Wishlist_Compare_RecentView_03_Remove_Product_In_Wishlist() {
        wishListPage.hoverToTopMenuByName(driver, "Computers");
        wishListPage.clickToMenuSublist(driver, "Notebooks");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleMacbookPro);
        productPage.clickToAddToWishlistButton();
        productPage.clickToCloseBarNotification();
        productPage.openHeaderPageByName(driver, "Wishlist");

        wishListPage = PageGeneratorManager.getWishlistPage(driver);
        wishListPage.clickToRemoveFromCartButton();
        Assert.assertEquals(wishListPage.getMessage(), "The wishlist is empty!");
        Assert.assertTrue(wishListPage.isProductUnDisplaying());
    }

    @Test
    public void Wishlist_Compare_RecentView_04_Add_Product_To_Compare() {
        wishListPage.hoverToTopMenuByName(driver, "Computers");
        wishListPage.clickToMenuSublist(driver, "Notebooks");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToAddToCompareListButton(productTitleMacbookPro);
        Assert.assertEquals(productPage.getBarNotificationText(), "The product has been added to your product comparison");
        productPriceMacbookPro = productPage.getProductPrice(productTitleMacbookPro);
        productPage.clickToAddToCompareListButton(productTitleSamsungUltrabook);
        Assert.assertEquals(productPage.getBarNotificationText(), "The product has been added to your product comparison");
        productPriceSamsungUltrabook = productPage.getProductPrice(productTitleSamsungUltrabook);

        productPage.openFooterPageByName(driver, "Compare products list");
        Assert.assertTrue(productPage.areCompareProductNamesDisplayingCorrect(productTitleMacbookPro, productTitleSamsungUltrabook));
        Assert.assertTrue(productPage.areProductPricesDisplayingCorrect(productPriceMacbookPro, productPriceSamsungUltrabook));
        productPage.clickToClearListButton();
        Assert.assertEquals(productPage.getMessage(), "You have no items to compare.");
        Assert.assertTrue(productPage.areProductUnDisplaying());
    }

    @Test
    public void Wishlist_Compare_RecentView_05_Recently_Viewed_Products() {
        productPage.viewProductDetailsSerial("Computers", "Notebooks", productNames);
        productPage.openFooterPageByName(driver, "Recently viewed products");
        Assert.assertTrue(productPage.areRecentlyViewedProductNamesDisplayingCorrect(productTitleAsusLaptop, productTitleHPSpectre, productTitleHPEnvy));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
