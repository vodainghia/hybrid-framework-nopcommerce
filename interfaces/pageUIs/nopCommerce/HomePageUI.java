package pageUIs.nopCommerce;

public class HomePageUI {
	/* public: phạm vi rộng ngoài package
	 * static: biến tĩnh, cho phép 1 class khác truy cập đến biến của class này mà
	 * KHÔNG cần khởi tạo đối tượng của class này lên
	 * e.g.: HomePageUI.HOMEPAGE_SLIDER
	 * final: ngăn cản việc gán lại giá trị cho biến này
	 * static final: trong Java xem là hằng số (constant), theo convention Java phải viết hoa
	 * và phân cách bởi dấu "_"
	 */
	public static final String HOMEPAGE_SLIDER = "//div[@id='nivo-slider']";
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
}
