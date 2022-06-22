package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.AdminHomePageObject;
import pageObjects.nopCommerce.AdminLoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Admin extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPage;
    AdminHomePageObject adminHomePage;

    String email, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        email = "admin@yourstore.com";
        password = "admin";
    }

    @Test
    public void Admin_01_Search_With_Product_Name() {
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        Assert.assertEquals(adminLoginPage.getAdminLoginPageTitle(), "Admin area demo");

        adminLoginPage.enterToEmailTextbox(email);
        adminLoginPage.enterToPasswordTextbox(password);
        adminLoginPage.clickToLoginButton();

        adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
        Assert.assertEquals(adminHomePage.getHomePageContentHeader(), "Dashboard");

        adminHomePage.clickToSidebarMenu("Catalog");
        adminHomePage.clickToItemInSidebarMenu("Products");

        adminHomePage.enterToProductNameTextbox("Lenovo IdeaCentre 600 All-in-One PC");
        adminHomePage.clickToSearchButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}