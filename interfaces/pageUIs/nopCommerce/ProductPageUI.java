package pageUIs.nopCommerce;

public class ProductPageUI {
    public static final String ADD_YOUR_REVIEW_LINK = "//div[@class='product-review-links']/a[text()='Add your review']";
    public static final String PRODUCT_REVIEW_PAGE_TITLE = "//div[@class='page-title']/h1";
    public static final String PRODUCT_REVIEW_REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
    public static final String PRODUCT_REVIEW_REVIEW_TEXT_TEXTBOX = "//textarea[@id='AddProductReview_ReviewText']";
    public static final String PRODUCT_REVIEW_RATING_1_POINT_RADIO = "//input[@id='addproductrating_1']";
    public static final String PRODUCT_REVIEW_RATING_2_POINT_RADIO = "//input[@id='addproductrating_2']";
    public static final String PRODUCT_REVIEW_RATING_3_POINT_RADIO = "//input[@id='addproductrating_3']";
    public static final String PRODUCT_REVIEW_RATING_4_POINT_RADIO = "//input[@id='addproductrating_4']";
    public static final String PRODUCT_REVIEW_RATING_5_POINT_RADIO = "//input[@id='addproductrating_5']";
    public static final String PRODUCT_REVIEW_SUBMIT_REIVEW_BUTTON = "//button[@name='add-review']";
    public static final String PRODUCT_REVIEW_RESULT_TEXT = "//div[@class='result']";
    public static final String PRODUCT_OVERVIEW_TEXT = "//form[@id='product-details-form']//h1";
    public static final String PRODUCT_TITLE = "//h2[@class='product-title']/a[text()='%s']";

    public static final String SEARCH_BUTTON = "//div[@class='search-input']//button";
    public static final String SEARCH_WARNING_MESSAGE = "//div[@class='search-results']//div[@class='warning']";
    public static final String SEARCH_KEYWORD_TEXTBOX = "//div[@class='search-input']//input[@id='q']";
    public static final String SEARCH_NO_RESULT_MESSAGE = "//div[@class='search-results']//div[@class='no-result']";
    public static final String SEARCH_RESULTS = "//div[@class='item-box']//h2/a";
    public static final String DYNAMIC_SEARCH_RESULTS = "//div[@class='item-box']//h2/a[text()='%s']";
    public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
    public static final String ADVANCED_SEARCH_CHECKBOX = "//input[@id='advs']";
    public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX = "//input[@id='isc']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
    public static final String SORT_BY_DROPDOWN = "//select[@id='products-orderby']";
    public static final String ITEM_BOX_TEXT = "//div[@class='item-box']//h2/a";
    public static final String ITEM_BOX_PRICE = "//div[@class='item-box']//span";
    public static final String PAGE_SIZE_DROPDOWN = "//select[@id='products-pagesize']";
    public static final String CURRENT_PAGE_BUTTON = "//li[@class='current-page']/span";
    public static final String NEXT_PAGE_BUTTON = "//li[@class='next-page']";
    public static final String PREVIOUS_PAGE_BUTTON = "//li[@class='previous-page']";
    public static final String PAGING = "//div[@class='pager']";
    public static final String ADD_TO_WISHLIST_BUTTON = "//button[@id='add-to-wishlist-button-4']";
    public static final String BAR_NOTIFICATION_TEXT = "//div[@id='bar-notification']//p";
    public static final String BAR_NOTIFICATION_CLOSE_BUTTON = "//div[@id='bar-notification']//span";
    public static final String AJAX_PRODUCT_BUSY = "//div[@class='ajax-products-busy']";
    public static final String DYNAMIC_ADD_TO_COMPARE_LIST_BUTTON = "//a[text()='%s']/parent::h2/following-sibling::div//button[@title='Add to compare list']";
    public static final String PRODUCT_TITLE_LIST = "//tr[@class='product-name']//a";
    public static final String DYNAMIC_PRODUCT_PRICE_TEXT = "//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//span";
    public static final String PRODUCT_PRICE_LIST = "//tr[@class='product-price']/td[@style]";
    public static final String CLEAR_LIST_BUTTON = "//a[@class='clear-list']";
    public static final String MESSAGE = "//div[@class='no-data']";
}
