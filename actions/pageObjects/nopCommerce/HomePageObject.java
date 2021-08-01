package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		/* Đây là contructor: Hàm khởi tạo
		 * Khi new 1 class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		 * Không có kiểu trả về
		 * 1 class có thể có nhiều hàm khởi tạo -> Tính Đa hình
		 */
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOMEPAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOMEPAGE_SLIDER);
	}


}
