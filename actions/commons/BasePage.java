package commons;

import static commons.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.ProductPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;
import pageUIs.nopCommerce.BasePageUI;

public class BasePage {
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        alert = waitForAlertPresence(driver);
        alert.accept();
    }

    public void cancelAlert(WebDriver driver) {
        alert = waitForAlertPresence(driver);
        alert.dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String value) {
        alert = waitForAlertPresence(driver);
        alert.sendKeys(value);
    }

    public String getAlertText(WebDriver driver) {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allTabIDs = driver.getWindowHandles();
        for (String TabID : allTabIDs) {
            if (!TabID.equals(windowID)) {
                driver.switchTo().window(TabID);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String WindowID : allWindowIDs) {
            driver.switchTo().window(WindowID);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedWindowTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindowsIDs = driver.getWindowHandles();
        for (String WindowID : allWindowsIDs) {
            if (!WindowID.equals(parentID)) {
                driver.switchTo().window(WindowID);
                driver.close();
                sleepInSecond(1);
            }

            if (driver.getWindowHandles().size() == 1) {
                driver.switchTo().window(parentID);
                break;
            }
        }
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public String getDynamicLocator(String locator, String... params) {
        return String.format(locator, (Object[]) params);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String value, String... params) {
        getElement(driver, getDynamicLocator(locator, params)).clear();
        getElement(driver, getDynamicLocator(locator, params)).sendKeys(value);
    }

    public int getElementSize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
        select = new Select(getElement(driver, locator));
        select.selectByVisibleText(itemText);
    }

    public String getSelectedItemDropdown(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        select = new Select(getElement(driver, locator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        explicitWait = new WebDriverWait(driver, shortTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).getText();
    }

    public List<String> getElementsText(WebDriver driver, String locator) {
        List<String> elementsText = new ArrayList<String>();
        for (WebElement element : getElements(driver, locator)) {
            elementsText.add(element.getText());
        }
        return elementsText;
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
        if (!isElementSelected(driver, getDynamicLocator(locator, params))) {
            getElement(driver, getDynamicLocator(locator, params)).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver, String locator, String... params) {
        if (isElementSelected(driver, getDynamicLocator(locator, params))) {
            getElement(driver, getDynamicLocator(locator, params)).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
        return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
    }

    public boolean isElementUnDisplayed(WebDriver driver, String locator) {
        try {
            return !isElementDisplayed(driver, locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public WebDriver switchToIFrameByElement(WebDriver driver, String locator) {
        return driver.switchTo().frame(getElement(driver, locator));
    }

    public WebDriver switchToDefaultContent(WebDriver driver) {
        return driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String... params) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
        sleepInSecond(1);
    }

    public void scrollToElement(WebDriver driver, String locator, String... params) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, getDynamicLocator(locator, params)));
        sleepInSecond(1);
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitForAllElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
        explicitWait = new WebDriverWait(driver, shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
    }

    public SearchPageObject openSearchPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.SEARCH_PAGE_FOOTER);
        clickToElement(driver, BasePageUI.SEARCH_PAGE_FOOTER);
        return PageGeneratorManager.getSearchPage(driver);
    }

    public MyAccountPageObject openMyAccountPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
        clickToElement(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
        return PageGeneratorManager.getMyAccountPage(driver);
    }

    public ProductPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ORDER_PAGE_FOOTER);
        clickToElement(driver, BasePageUI.ORDER_PAGE_FOOTER);
        return PageGeneratorManager.getProductPage(driver);
    }

    // Option 1: less than 10 pages
    public BasePage getFooterPageByName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);

        switch (pageName) {
            case "Search":
                return PageGeneratorManager.getSearchPage(driver);
            case "My account":
                return PageGeneratorManager.getMyAccountPage(driver);
            default:
                return PageGeneratorManager.getProductPage(driver);
        }
    }

    // Option 2: Multiple pages
    public void openFooterPageByName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
    }

    public void openHeaderPageByName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
    }

    public void hoverToHearPageByName(WebDriver driver, String pageName) {
        scrollToElement(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
        hoverToElement(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
    }

    public void hoverToTopMenuByName(WebDriver driver, String menuName) {
        scrollToElement(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
        waitForElementClickable(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
        hoverToElement(driver, BasePageUI.DYNAMIC_TOP_MENU, menuName);
    }

    public void clickToMenuSublist(WebDriver driver, String menuSublistName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_TOP_MENU_SUBLIST, menuSublistName);
        clickToElement(driver, BasePageUI.DYNAMIC_TOP_MENU_SUBLIST, menuSublistName);
    }

    public String getCurrentDatetime(String pattern) {
        return getCurrentDatetimeAsFormat(pattern);
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Alert alert;
    private Select select;
    private Actions action;
    private long shortTimeout = GlobalContants.SHORT_TIMEOUT;
    //private long longTimeout = GlobalContants.LONG_TIMEOUT;
    private WebDriverWait explicitWait;
    private JavascriptExecutor jsExecutor;
}