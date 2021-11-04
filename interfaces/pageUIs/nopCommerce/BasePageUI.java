package pageUIs.nopCommerce;

public class BasePageUI {
    // Many page in Footer
    public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
    public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
    public static final String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";

    // 1 locator (dynamic) for many pages
    public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
    public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//*[text()='%s']";

    public static final String DYNAMIC_TOP_MENU = "//div[@class='header-menu']/ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_TOP_MENU_SUBLIST = "//div[@class='header-menu']/ul[contains(@class,'notmobile')]//a[contains(text(),'%s')]";
}
