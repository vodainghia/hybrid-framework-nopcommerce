package pageUIs.nopCommerce;

public class AdminHomePageUI {
    public static final String PAGE_CONTENT_HEADER_TEXT = "//div[@class='content-header']";
    public static final String DYNAMIC_SIDEBAR_MENU = "(//p[contains(text(),'Catalog')])[1]";
    public static final String DYNAMIC_ITEM_IN_SIDEBAR_MENU = "//ul[@style='display: block;']//p[contains(text(),'%s')]";
    public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
    public static final String SEARCH_BUTTON = "//button[@id='search-products']";
}
