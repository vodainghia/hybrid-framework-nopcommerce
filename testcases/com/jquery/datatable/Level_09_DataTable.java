package com.jquery.datatable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void Table_01_Paging() {
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageActivedByNumber("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageActivedByNumber("5"));

        homePage.openPageByNumber("20");
        Assert.assertTrue(homePage.isPageActivedByNumber("20"));
    }

    //@Test
    public void Table_02_Input() {
        // input in textboxes
        homePage.inputToHeaderTextboxByName("Females", "24218");

        homePage.inputToHeaderTextboxByName("Males", "25266");

        homePage.inputToHeaderTextboxByName("Country", "Albania");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void Table_03_Click_Icon() {
        // click to icon
        homePage.clickToIconByCountryName("Argentina", "remove");
        homePage.sleepInSecond(2);

        homePage.clickToIconByCountryName("Algeria", "remove");
        homePage.sleepInSecond(2);

        homePage.clickToIconByCountryName("Arab Rep of Egypt", "edit");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        homePage.clickToIconByCountryName("AFRICA", "edit");
        homePage.sleepInSecond(2);
    }

    @Test
    public void Table_04_Verify_Row_Values() {
        // search then verify returned values
        homePage.inputToHeaderTextboxByName("Country", "Albania");
        Assert.assertTrue(homePage.isRowValueDisplayed("24128", "Albania", "25266", "49397"));
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        homePage.inputToHeaderTextboxByName("Country", "Algeria");
        Assert.assertTrue(homePage.isRowValueDisplayed("283821", "Algeria", "295140", "578961"));
        homePage.sleepInSecond(2);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
