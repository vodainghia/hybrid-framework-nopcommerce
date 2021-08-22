package pageUIs.nopCommerce;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String LOGIN_BUTTON = "//button[text()='Log in']";
	public static final String LOGIN_PAGE_TITLE = "//div[@class='page-title']/h1[text()='Welcome, Please Sign In!']";
	
	public static final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String VALIDATE_ERROR_MESSAGE = "//div[@class='page-body']//div[contains(@class,'validation-summary-errors')]";
	public static final String LOGIN_PAGE_SLIDER = "//div[@id='nivo-slider']";

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
}
