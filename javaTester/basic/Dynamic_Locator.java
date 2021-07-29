package basic;

public class Dynamic_Locator {

	public static void main(String[] args) {
		// UI
		//String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
		//String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
		//String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
		
		String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
		
		String DYNAMIC_SIDEBAR_TEXT = "//sidebar[@id='%s']//div[text()='%s']";
		
		String DYNAMIC_COUNTRY_CITY_STREET = "//div[@id='%s']//div[@id='%s']//div[@id='%s']";
		
		// Page Object
		clickToElement(DYNAMIC_PAGE_FOOTER, "Search");
		clickToElement(DYNAMIC_PAGE_FOOTER, "My account");
		clickToElement(DYNAMIC_PAGE_FOOTER, "Orders");
		
		clickToElement(DYNAMIC_SIDEBAR_TEXT, "Customer", "John Wick");
		
		clickToElement(DYNAMIC_COUNTRY_CITY_STREET, "Customer", "John Wick", "US");
	}
	
	// Fix cứng locator
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}

	// 1 tham số dynamic
	public static void clickToElement(String locator, String firstParam) {
		System.out.println(String.format(locator, firstParam));
	}
	
	// 2 tham số dynamic
	public static void clickToElement(String locator, String firstParam, String secondParam) {
		System.out.println(String.format(locator, firstParam, secondParam));
	}
	
	// 3 tham số dynamic
	public static void clickToElement(String locator, String firstParam, String secondParam, String thirdParam) {
		System.out.println(String.format(locator, firstParam, secondParam, thirdParam));
	}
	
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator, (Object[]) params));
	}
}
