package com.nopcommerce.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Order extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    ProductPageObject productPage;
    RegisterPageObject registerPage;
    MyAccountPageObject myAccountPage;
    ShoppingCartPageObject shoppingCartPage;

    String firstNameBilling, lastNameBilling, emailBilling, password, productTitleBuildComputer, expectedProcessor;
    String expectedRam, expectedHdd, expectedOs, updatedProcessor, updatedRam, updatedHdd, updatedOs, productTitleLenovoPc;
    String productTitleMacBookPro, countryBilling, stateBilling, cityBilling, addressBilling, zipBilling, phoneNumberBilling;
    String firstNameShipping, lastNameShipping, emailShipping, countryShipping, stateShipping, cityShipping, addressShipping;
    String zipShipping, phoneNumberShipping, expectedPaymentInfor, paymentMethodCheque, shippingMethod, expectedSku;
    String expectedUnitPrice, expectedQuantity, expectedSubTotal, expectedCartOption, expectedOrderTotal, softMO, softAcrobat;
    String softCommander, listExpectedAttributes, listUpdatedAttributes, orderNumber, orderDate, paymentMethodCredit;
    String visaCreditCard, cardHolderName, cardNumber, expirationMonth, expirationYear, cardCode;
    String firstNameBillingNew, lastNameBillingNew, emailBillingNew, countryBillingNew, stateBillingNew, cityBillingNew;
    String addressBillingNew, zipBillingNew, phoneNumberBillingNew, firstNameShippingNew, lastNameShippingNew;
    String emailShippingNew, countryShippingNew, stateShippingNew, cityShippingNew, addressShippingNew, zipShippingNew;
    String phoneNumberShippingNew, shippingMethodNew;
    ArrayList<String> listExpectedSoftwares, listUpdatedSoftwaresUnCheck;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);

        firstNameBilling = "John";
        lastNameBilling = "Wick";
        emailBilling = getRandomEmail();
        password = "123456";
        productTitleBuildComputer = "Build your own computer";
        productTitleLenovoPc = "Lenovo IdeaCentre 600 All-in-One PC";
        productTitleMacBookPro = "Apple MacBook Pro 13-inch";
        expectedProcessor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        updatedProcessor = "2.2 GHz Intel Pentium Dual-Core E2200";
        expectedRam = "8GB [+$60.00]";
        updatedRam = "4GB [+$20.00]";
        expectedHdd = "400 GB [+$100.00]";
        updatedHdd = "320 GB";
        expectedOs = "Vista Premium [+$60.00]";
        updatedOs = "Vista Home [+$50.00]";
        softMO = "Microsoft Office [+$50.00]";
        softAcrobat = "Acrobat Reader [+$10.00]";
        softCommander = "Total Commander [+$5.00]";
        listExpectedSoftwares = new ArrayList<>(
                Arrays.asList(softMO, softAcrobat, softCommander));
        listUpdatedSoftwaresUnCheck = new ArrayList<>(
                Arrays.asList(softAcrobat, softCommander));
        listExpectedAttributes = "Processor: " + expectedProcessor + "\n" + "RAM: " + expectedRam + "\n" + "HDD: " +
                expectedHdd + "\n" + "OS: " + expectedOs + "\n" + "Software: " + softMO + "\n" + "Software: " +
                softAcrobat + "\n" + "Software: " + softCommander;
        listUpdatedAttributes = "Processor: " + updatedProcessor + "\n" + "RAM: " + updatedRam + "\n" + "HDD: " +
                updatedHdd + "\n" + "OS: " + updatedOs + "\n" + "Software: " + softMO;
        expectedCartOption = "No";
        countryBilling = "Viet Nam";
        stateBilling = "Other";
        cityBilling = "Sai Gon";
        addressBilling = "227 Nguyen Van Cu";
        zipBilling = "700000";
        phoneNumberBilling = "0123456789";

        firstNameShipping = "Keanu";
        lastNameShipping = "Reeves";
        emailShipping = getRandomEmail();
        countryShipping = "Viet Nam";
        stateShipping = "Other";
        cityShipping = "Sai Gon";
        addressShipping = "268 Lý Thường Kiệt";
        zipShipping = "700000";
        phoneNumberShipping = "9876543210";
        paymentMethodCheque = "Check / Money Order";
        shippingMethod = "Ground";
        expectedPaymentInfor = "Mail Personal or Business Check, Cashier's Check or money order to:\n" +
                "\n" + "NOP SOLUTIONS\n" + "your address here,\n" + "New York, NY 10001\n" + "USA\n" + "Notice that " +
                "if you pay by Personal or Business Check, your order may be held for up to 10 days after we receive " +
                "your check to allow enough time for the check to clear. If you want us to ship faster upon receipt " +
                "of your payment, then we recommend your send a money order or Cashier's check.\n" +
                "P.S. You can edit this text from admin panel.";
        paymentMethodCredit = "Credit Card";
        visaCreditCard = "Visa";
        cardHolderName = firstNameBilling + " " + lastNameBilling;
        cardNumber = "4111111111111111";
        expirationMonth = "11";
        expirationYear = "2025";
        cardCode = "911";

        firstNameBillingNew = "new first";
        lastNameBillingNew = "last billing";
        emailBillingNew = getRandomEmail();
        countryBillingNew = "Viet Nam";
        stateBillingNew = "Other";
        cityBillingNew = "Sai Gon";
        addressBillingNew = "new billing addr";
        zipBillingNew = "700000";
        phoneNumberBillingNew = "0988999888";
        firstNameShippingNew = "new first";
        lastNameShippingNew = "last shipping";
        emailShippingNew = getRandomEmail();
        countryShippingNew = "Viet Nam";
        stateShippingNew = "Other";
        cityShippingNew = "Sai Gon";
        addressShippingNew = "new shipping addr";
        zipShippingNew = "700000";
        phoneNumberShippingNew = "0988888999";
        shippingMethodNew = "Next Day Air";
    }

    @Test
    public void Order_01_Add_Product_To_Cart() {
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.openHeaderPageByName(driver, "Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        registerPage.clickToGenderMaleRadioButton();
        registerPage.enterToFirstnameTextbox(firstNameBilling);
        registerPage.enterToLastnameTextbox(lastNameBilling);
        registerPage.enterToEmailTextbox(emailBilling);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        registerPage.hoverToTopMenuByName(driver, "Computers");
        registerPage.clickToMenuSublist(driver, "Desktops");

        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleBuildComputer);
        productPage.selectToProcessorDropdown(expectedProcessor);
        productPage.selectToRamDropdown(expectedRam);
        productPage.selectToHddRadio(expectedHdd);
        productPage.selectToOsRadio(expectedOs);
        productPage.selectToSoftwareCheckbox(listExpectedSoftwares);
        productPage.clickToAddToCartButton();
        Assert.assertEquals(productPage.getBarNotificationText(), "The product has been added to your shopping cart");
        productPage.clickToCloseBarNotification();

        productPage.hoverToHearPageByName(driver, "Shopping cart");
        Assert.assertEquals(productPage.getCountMessageOnFlyoutCart(), "There are 1 item(s) in your cart.");
        Assert.assertEquals(productPage.getAllAttributesOnFlyoutCart(), listExpectedAttributes);
        Assert.assertEquals(productPage.getSubTotalOnFlyoutCart(), "$1,500.00");
    }

    @Test
    public void Order_02_Edit_Product_In_Cart() {
        productPage.openHeaderPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        shoppingCartPage.clickToEditButton();
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.selectToProcessorDropdown(updatedProcessor);
        productPage.selectToRamDropdown(updatedRam);
        productPage.selectToHddRadio(updatedHdd);
        productPage.selectToOsRadio(updatedOs);
        productPage.unSelectToSoftwareCheckbox(listUpdatedSoftwaresUnCheck);
        productPage.enterToQuantityTextbox("2");
        productPage.clickToUpdateButton();
        Assert.assertEquals(productPage.getProductPriceText(), "$1,320.00");
        Assert.assertEquals(productPage.getBarNotificationText(), "The product has been added to your shopping cart");
        productPage.clickToCloseBarNotification();
        productPage.hoverToHearPageByName(driver, "Shopping cart");
        Assert.assertEquals(productPage.getCountMessageOnFlyoutCart(), "There are 2 item(s) in your cart.");
        Assert.assertEquals(productPage.getAllAttributesOnFlyoutCart(), listUpdatedAttributes);
        Assert.assertEquals(productPage.getSubTotalOnFlyoutCart(), "$2,640.00");
    }

    @Test
    public void Order_03_Remove_Product_From_Cart() {
        productPage.openHeaderPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        shoppingCartPage.clickToRemoveButton();
        Assert.assertEquals(shoppingCartPage.getMessage(), "Your Shopping Cart is empty!");
        Assert.assertTrue(shoppingCartPage.isProductUnDisplaying());
    }

    @Test
    public void Order_04_Update_Shopping_Cart() {
        shoppingCartPage.hoverToTopMenuByName(driver, "Computers");
        shoppingCartPage.clickToMenuSublist(driver, "Desktops");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleLenovoPc);
        productPage.clickToAddToCartButton();
        productPage.clickToCloseBarNotification();
        productPage.openHeaderPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        shoppingCartPage.enterToQuantityTextbox("5");
        shoppingCartPage.clickToUpdateShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getSubTotalOnShoppingCart(), "$2,500.00");
        shoppingCartPage.clickToRemoveButton();
    }

    @Test
    public void Order_05_Checkout_Payment_Method_By_Cheque() {
        shoppingCartPage.hoverToTopMenuByName(driver, "Computers");
        shoppingCartPage.clickToMenuSublist(driver, "Notebooks");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleMacBookPro);
        productPage.clickToAddToCartButton();
        productPage.clickToCloseBarNotification();
        productPage.openHeaderPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        expectedSku = shoppingCartPage.getSkuOnShoppingCart();
        expectedUnitPrice = shoppingCartPage.getUnitPriceOnShoppingCart();
        expectedQuantity = shoppingCartPage.getQuantityOnShoppingCart();
        expectedSubTotal = shoppingCartPage.getSubTotalOnShoppingCart();
        expectedOrderTotal = shoppingCartPage.getOrderTotalOnShoppingCart();
        shoppingCartPage.selectToGiftWrappingDropdown(expectedCartOption);
        shoppingCartPage.selectToTermOfServiceCheckbox();
        shoppingCartPage.clickToCheckoutButton();

        shoppingCartPage.unSelectToShipToSameAddressCheckbox();
        shoppingCartPage.selectToCountryBillingDropdown(countryBilling);
        shoppingCartPage.selectToStateProvinceBillingDropdown(stateBilling);
        shoppingCartPage.enterToCityBillingTextbox(cityBilling);
        shoppingCartPage.enterToAddress1BillingTextbox(addressBilling);
        shoppingCartPage.enterToPostalCodeBillingTextbox(zipBilling);
        shoppingCartPage.enterToPhoneNumberBillingTextbox(phoneNumberBilling);
        shoppingCartPage.clickToContinueBillingButton();

        shoppingCartPage.selectToNewAddressShippingDropdown("New Address");
        shoppingCartPage.enterToFirstnameShippingTextbox(firstNameShipping);
        shoppingCartPage.enterToLastnameShippingTextbox(lastNameShipping);
        shoppingCartPage.enterToEmailShippingTextbox(emailShipping);
        shoppingCartPage.selectToCountryShippingDropdown(countryShipping);
        shoppingCartPage.selectToStateProvinceShippingDropdown(stateShipping);
        shoppingCartPage.enterToCityShippingTextbox(cityShipping);
        shoppingCartPage.enterToAddress1ShippingTextbox(addressShipping);
        shoppingCartPage.enterToPostalCodeShippingTextbox(zipShipping);
        shoppingCartPage.enterToPhoneNumberShippingTextbox(phoneNumberShipping);
        shoppingCartPage.clickToContinueShippingButton();

        shoppingCartPage.selectToShippingMethodRadio(shippingMethod);
        shoppingCartPage.clickToContinueShippingMethodButton();

        shoppingCartPage.selectToPaymentMethodRadio(paymentMethodCheque);
        shoppingCartPage.clickToContinuePaymentMethodButton();

        Assert.assertEquals(shoppingCartPage.getPaymentInforDisplaying(), expectedPaymentInfor);
        shoppingCartPage.clickToContinuePaymentInforButton();

        Assert.assertEquals(shoppingCartPage.getNameBillingOnConfirmOrder(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(shoppingCartPage.getEmailBillingOnConfirmOrder(), "Email: " + emailBilling);
        Assert.assertEquals(shoppingCartPage.getPhoneBillingOnConfirmOrder(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(shoppingCartPage.getAddress1BillingOnConfirmOrder(), addressBilling);
        Assert.assertEquals(shoppingCartPage.getCityStateZipBillingOnConfirmOrder(), cityBilling + "," + zipBilling);
        Assert.assertEquals(shoppingCartPage.getCountryBillingOnConfirmOrder(), countryBilling);
        Assert.assertEquals(shoppingCartPage.getPaymentMethodOnConfirmOrder(), paymentMethodCheque);
        Assert.assertEquals(shoppingCartPage.getNameShippingOnConfirmOrder(), firstNameShipping + " " + lastNameShipping);
        Assert.assertEquals(shoppingCartPage.getEmailShippingOnConfirmOrder(), "Email: " + emailShipping);
        Assert.assertEquals(shoppingCartPage.getPhoneShippingOnConfirmOrder(), "Phone: " + phoneNumberShipping);
        Assert.assertEquals(shoppingCartPage.getAddress1ShippingOnConfirmOrder(), addressShipping);
        Assert.assertEquals(shoppingCartPage.getCityStateZipShippingOnConfirmOrder(), cityShipping + "," + zipShipping);
        Assert.assertEquals(shoppingCartPage.getCountryShippingOnConfirmOrder(), countryShipping);
        Assert.assertEquals(shoppingCartPage.getShippingMethodOnConfirmOrder(), shippingMethod);
        Assert.assertEquals(shoppingCartPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(shoppingCartPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(shoppingCartPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(shoppingCartPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(shoppingCartPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(shoppingCartPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
        shoppingCartPage.clickToConfirmButton();

        Assert.assertEquals(shoppingCartPage.getOrderCompletePageTitle(), "Thank you");
        Assert.assertEquals(shoppingCartPage.getOrderCompleteTitle(), "Your order has been successfully processed!");
        orderNumber = shoppingCartPage.getOrderNumberText();

        shoppingCartPage.openHeaderPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
        myAccountPage.clickToOrdersMenu();
        Assert.assertEquals(myAccountPage.getOrderItemTitle(), orderNumber);
        myAccountPage.clickToDetailbutton();

        Assert.assertEquals(myAccountPage.getOrderNumberOnOverview(), orderNumber);
        orderDate = myAccountPage.getCurrentDatetime("EEEEE, MMMM dd, yyyy");
        Assert.assertEquals(myAccountPage.getOrderDateOnOverview(), "Order Date: " + orderDate);
        Assert.assertEquals(myAccountPage.getOrderStatusOnOverview(), "Order Status: Pending");
        Assert.assertEquals(myAccountPage.getOrderTotalOnOverview(), "Order Total: " + expectedOrderTotal);
        Assert.assertEquals(myAccountPage.getNameBillingOnOverview(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(myAccountPage.getEmailBillingOnOverview(), "Email: " + emailBilling);
        Assert.assertEquals(myAccountPage.getPhoneBillingOnOverview(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(myAccountPage.getAddress1BillingOnOverview(), addressBilling);
        Assert.assertEquals(myAccountPage.getCityStateZipBillingOnOverview(), cityBilling + "," + zipBilling);
        Assert.assertEquals(myAccountPage.getCountryBillingOnOverview(), countryBilling);
        Assert.assertEquals(myAccountPage.getPaymentMethodOnOverview(), paymentMethodCheque);
        Assert.assertEquals(myAccountPage.getPaymentStatusOnOverview(), "Pending");
        Assert.assertEquals(myAccountPage.getNameShippingOnOverview(), firstNameShipping + " " + lastNameShipping);
        Assert.assertEquals(myAccountPage.getEmailShippingOnOverview(), "Email: " + emailShipping);
        Assert.assertEquals(myAccountPage.getPhoneShippingOnOverview(), "Phone: " + phoneNumberShipping);
        Assert.assertEquals(myAccountPage.getAddress1ShippingOnOverview(), addressShipping);
        Assert.assertEquals(myAccountPage.getCityStateZipShippingOnOverview(), cityShipping + "," + zipShipping);
        Assert.assertEquals(myAccountPage.getCountryShippingOnOverview(), countryShipping);
        Assert.assertEquals(myAccountPage.getShippingMethodOnOverview(), shippingMethod);
        Assert.assertEquals(myAccountPage.getShippingStatusOnOverview(), "Not yet shipped");
        Assert.assertEquals(myAccountPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(myAccountPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(myAccountPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(myAccountPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(myAccountPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(myAccountPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
    }

    @Test
    public void Order_06_Checkout_Payment_Method_By_Credit() {
        shoppingCartPage.waitForSomeSeconds(20);
        shoppingCartPage.hoverToTopMenuByName(driver, "Computers");
        shoppingCartPage.clickToMenuSublist(driver, "Notebooks");
        productPage = PageGeneratorManager.getProductPage(driver);
        productPage.clickToProductTitle(productTitleMacBookPro);
        productPage.clickToAddToCartButton();
        productPage.clickToCloseBarNotification();
        productPage.openHeaderPageByName(driver, "Shopping cart");
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        expectedSku = shoppingCartPage.getSkuOnShoppingCart();
        expectedUnitPrice = shoppingCartPage.getUnitPriceOnShoppingCart();
        expectedQuantity = shoppingCartPage.getQuantityOnShoppingCart();
        expectedSubTotal = shoppingCartPage.getSubTotalOnShoppingCart();
        expectedOrderTotal = shoppingCartPage.getOrderTotalOnShoppingCart();
        shoppingCartPage.selectToGiftWrappingDropdown(expectedCartOption);
        shoppingCartPage.selectToTermOfServiceCheckbox();
        shoppingCartPage.clickToCheckoutButton();

        shoppingCartPage.clickToContinueBillingButton();

        shoppingCartPage.selectToShippingMethodRadio(shippingMethod);
        shoppingCartPage.clickToContinueShippingMethodButton();

        shoppingCartPage.selectToPaymentMethodRadio(paymentMethodCredit);
        shoppingCartPage.clickToContinuePaymentMethodButton();

        shoppingCartPage.selectToCreditCartDropdown(visaCreditCard);
        shoppingCartPage.enterToCardholderNameTextbox(cardHolderName);
        shoppingCartPage.enterToCardNumberTextbox(cardNumber);
        shoppingCartPage.selectToExpirationMonthDropdown(expirationMonth);
        shoppingCartPage.selectToExpirationYearDropdown(expirationYear);
        shoppingCartPage.enterToCardCodeTextbox(cardCode);
        shoppingCartPage.clickToContinuePaymentInforButton();

        Assert.assertEquals(shoppingCartPage.getNameBillingOnConfirmOrder(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(shoppingCartPage.getEmailBillingOnConfirmOrder(), "Email: " + emailBilling);
        Assert.assertEquals(shoppingCartPage.getPhoneBillingOnConfirmOrder(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(shoppingCartPage.getAddress1BillingOnConfirmOrder(), addressBilling);
        Assert.assertEquals(shoppingCartPage.getCityStateZipBillingOnConfirmOrder(), cityBilling + "," + zipBilling);
        Assert.assertEquals(shoppingCartPage.getCountryBillingOnConfirmOrder(), countryBilling);
        Assert.assertEquals(shoppingCartPage.getPaymentMethodOnConfirmOrder(), paymentMethodCredit);
        Assert.assertEquals(shoppingCartPage.getNameShippingOnConfirmOrder(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(shoppingCartPage.getEmailShippingOnConfirmOrder(), "Email: " + emailBilling);
        Assert.assertEquals(shoppingCartPage.getPhoneShippingOnConfirmOrder(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(shoppingCartPage.getAddress1ShippingOnConfirmOrder(), addressBilling);
        Assert.assertEquals(shoppingCartPage.getCityStateZipShippingOnConfirmOrder(), cityBilling + "," + zipBilling);
        Assert.assertEquals(shoppingCartPage.getCountryShippingOnConfirmOrder(), countryBilling);
        Assert.assertEquals(shoppingCartPage.getShippingMethodOnConfirmOrder(), shippingMethod);
        Assert.assertEquals(shoppingCartPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(shoppingCartPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(shoppingCartPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(shoppingCartPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(shoppingCartPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(shoppingCartPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
        shoppingCartPage.clickToConfirmButton();

        Assert.assertEquals(shoppingCartPage.getOrderCompletePageTitle(), "Thank you");
        Assert.assertEquals(shoppingCartPage.getOrderCompleteTitle(), "Your order has been successfully processed!");
        orderNumber = shoppingCartPage.getOrderNumberText();

        shoppingCartPage.openHeaderPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
        myAccountPage.clickToOrdersMenu();
        Assert.assertEquals(myAccountPage.getOrderItemTitle(), orderNumber);
        myAccountPage.clickToDetailbutton();

        Assert.assertEquals(myAccountPage.getOrderNumberOnOverview(), orderNumber);
        orderDate = myAccountPage.getCurrentDatetime("EEEEE, MMMM dd, yyyy");
        Assert.assertEquals(myAccountPage.getOrderDateOnOverview(), "Order Date: " + orderDate);
        Assert.assertEquals(myAccountPage.getOrderStatusOnOverview(), "Order Status: Pending");
        Assert.assertEquals(myAccountPage.getOrderTotalOnOverview(), "Order Total: " + expectedOrderTotal);
        Assert.assertEquals(myAccountPage.getNameBillingOnOverview(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(myAccountPage.getEmailBillingOnOverview(), "Email: " + emailBilling);
        Assert.assertEquals(myAccountPage.getPhoneBillingOnOverview(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(myAccountPage.getAddress1BillingOnOverview(), addressBilling);
        Assert.assertEquals(myAccountPage.getCityStateZipBillingOnOverview(), cityBilling + "," + zipBilling);
        Assert.assertEquals(myAccountPage.getCountryBillingOnOverview(), countryBilling);
        Assert.assertEquals(myAccountPage.getPaymentMethodOnOverview(), paymentMethodCredit);
        Assert.assertEquals(myAccountPage.getPaymentStatusOnOverview(), "Pending");
        Assert.assertEquals(myAccountPage.getNameShippingOnOverview(), firstNameBilling + " " + lastNameBilling);
        Assert.assertEquals(myAccountPage.getEmailShippingOnOverview(), "Email: " + emailBilling);
        Assert.assertEquals(myAccountPage.getPhoneShippingOnOverview(), "Phone: " + phoneNumberBilling);
        Assert.assertEquals(myAccountPage.getAddress1ShippingOnOverview(), addressBilling);
        Assert.assertEquals(myAccountPage.getCityStateZipShippingOnOverview(), cityBilling + "," + zipBilling);
        Assert.assertEquals(myAccountPage.getCountryShippingOnOverview(), countryBilling);
        Assert.assertEquals(myAccountPage.getShippingMethodOnOverview(), shippingMethod);
        Assert.assertEquals(myAccountPage.getShippingStatusOnOverview(), "Not yet shipped");
        Assert.assertEquals(myAccountPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(myAccountPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(myAccountPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(myAccountPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(myAccountPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(myAccountPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
    }

    @Test
    public void Order_07_ReOrder() {
        shoppingCartPage.waitForSomeSeconds(20);
        myAccountPage.clickToReorderButton();
        shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
        shoppingCartPage.enterToQuantityTextbox("10");
        shoppingCartPage.clickToUpdateShoppingCartButton();
        expectedSku = shoppingCartPage.getSkuOnShoppingCart();
        expectedUnitPrice = shoppingCartPage.getUnitPriceOnShoppingCart();
        expectedQuantity = shoppingCartPage.getQuantityOnShoppingCart();
        expectedSubTotal = shoppingCartPage.getSubTotalOnShoppingCart();
        expectedOrderTotal = shoppingCartPage.getOrderTotalOnShoppingCart();
        shoppingCartPage.selectToGiftWrappingDropdown(expectedCartOption);
        shoppingCartPage.selectToTermOfServiceCheckbox();
        shoppingCartPage.clickToCheckoutButton();

        shoppingCartPage.unSelectToShipToSameAddressCheckbox();
        shoppingCartPage.selectToNewAddressbillingDropdown("New Address");
        shoppingCartPage.enterToFirstnameBillingTextbox(firstNameBillingNew);
        shoppingCartPage.enterToLastnameBillingTextbox(lastNameBillingNew);
        shoppingCartPage.enterToEmailBillingTextbox(emailBillingNew);
        shoppingCartPage.selectToCountryBillingDropdown(countryBillingNew);
        shoppingCartPage.selectToStateProvinceBillingDropdown(stateBillingNew);
        shoppingCartPage.enterToCityBillingTextbox(cityBillingNew);
        shoppingCartPage.enterToAddress1BillingTextbox(addressBillingNew);
        shoppingCartPage.enterToPostalCodeBillingTextbox(zipBillingNew);
        shoppingCartPage.enterToPhoneNumberBillingTextbox(phoneNumberBillingNew);
        shoppingCartPage.clickToContinueBillingButton();

        shoppingCartPage.selectToNewAddressShippingDropdown("New Address");
        shoppingCartPage.enterToFirstnameShippingTextbox(firstNameShippingNew);
        shoppingCartPage.enterToLastnameShippingTextbox(lastNameShippingNew);
        shoppingCartPage.enterToEmailShippingTextbox(emailShippingNew);
        shoppingCartPage.selectToCountryShippingDropdown(countryShippingNew);
        shoppingCartPage.selectToStateProvinceShippingDropdown(stateShippingNew);
        shoppingCartPage.enterToCityShippingTextbox(cityShippingNew);
        shoppingCartPage.enterToAddress1ShippingTextbox(addressShippingNew);
        shoppingCartPage.enterToPostalCodeShippingTextbox(zipShippingNew);
        shoppingCartPage.enterToPhoneNumberShippingTextbox(phoneNumberShippingNew);
        shoppingCartPage.clickToContinueShippingButton();

        shoppingCartPage.selectToShippingMethodRadio(shippingMethodNew);
        shoppingCartPage.clickToContinueShippingMethodButton();

        shoppingCartPage.selectToPaymentMethodRadio(paymentMethodCheque);
        shoppingCartPage.clickToContinuePaymentMethodButton();

        shoppingCartPage.clickToContinuePaymentInforButton();

        Assert.assertEquals(shoppingCartPage.getNameBillingOnConfirmOrder(), firstNameBillingNew + " " + lastNameBillingNew);
        Assert.assertEquals(shoppingCartPage.getEmailBillingOnConfirmOrder(), "Email: " + emailBillingNew);
        Assert.assertEquals(shoppingCartPage.getPhoneBillingOnConfirmOrder(), "Phone: " + phoneNumberBillingNew);
        Assert.assertEquals(shoppingCartPage.getAddress1BillingOnConfirmOrder(), addressBillingNew);
        Assert.assertEquals(shoppingCartPage.getCityStateZipBillingOnConfirmOrder(), cityBillingNew + "," + zipBillingNew);
        Assert.assertEquals(shoppingCartPage.getCountryBillingOnConfirmOrder(), countryBillingNew);
        Assert.assertEquals(shoppingCartPage.getPaymentMethodOnConfirmOrder(), paymentMethodCheque);
        Assert.assertEquals(shoppingCartPage.getNameShippingOnConfirmOrder(), firstNameShippingNew + " " + lastNameShippingNew);
        Assert.assertEquals(shoppingCartPage.getEmailShippingOnConfirmOrder(), "Email: " + emailShippingNew);
        Assert.assertEquals(shoppingCartPage.getPhoneShippingOnConfirmOrder(), "Phone: " + phoneNumberShippingNew);
        Assert.assertEquals(shoppingCartPage.getAddress1ShippingOnConfirmOrder(), addressShippingNew);
        Assert.assertEquals(shoppingCartPage.getCityStateZipShippingOnConfirmOrder(), cityShippingNew + "," + zipShippingNew);
        Assert.assertEquals(shoppingCartPage.getCountryShippingOnConfirmOrder(), countryShippingNew);
        Assert.assertEquals(shoppingCartPage.getShippingMethodOnConfirmOrder(), shippingMethodNew);
        Assert.assertEquals(shoppingCartPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(shoppingCartPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(shoppingCartPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(shoppingCartPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(shoppingCartPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(shoppingCartPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(shoppingCartPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(shoppingCartPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
        shoppingCartPage.clickToConfirmButton();

        orderNumber = shoppingCartPage.getOrderNumberText();

        shoppingCartPage.openHeaderPageByName(driver, "My account");
        myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
        myAccountPage.clickToOrdersMenu();
        Assert.assertEquals(myAccountPage.getOrderItemTitle(), orderNumber);
        myAccountPage.clickToDetailbutton();

        Assert.assertEquals(myAccountPage.getOrderNumberOnOverview(), orderNumber);
        orderDate = myAccountPage.getCurrentDatetime("EEEEE, MMMM dd, yyyy");
        Assert.assertEquals(myAccountPage.getOrderDateOnOverview(), "Order Date: " + orderDate);
        Assert.assertEquals(myAccountPage.getOrderStatusOnOverview(), "Order Status: Pending");
        Assert.assertEquals(myAccountPage.getOrderTotalOnOverview(), "Order Total: " + expectedOrderTotal);
        Assert.assertEquals(myAccountPage.getNameBillingOnOverview(), firstNameBillingNew + " " + lastNameBillingNew);
        Assert.assertEquals(myAccountPage.getEmailBillingOnOverview(), "Email: " + emailBillingNew);
        Assert.assertEquals(myAccountPage.getPhoneBillingOnOverview(), "Phone: " + phoneNumberBillingNew);
        Assert.assertEquals(myAccountPage.getAddress1BillingOnOverview(), addressBillingNew);
        Assert.assertEquals(myAccountPage.getCityStateZipBillingOnOverview(), cityBillingNew + "," + zipBillingNew);
        Assert.assertEquals(myAccountPage.getCountryBillingOnOverview(), countryBillingNew);
        Assert.assertEquals(myAccountPage.getPaymentMethodOnOverview(), paymentMethodCheque);
        Assert.assertEquals(myAccountPage.getPaymentStatusOnOverview(), "Pending");
        Assert.assertEquals(myAccountPage.getNameShippingOnOverview(), firstNameShippingNew + " " + lastNameShippingNew);
        Assert.assertEquals(myAccountPage.getEmailShippingOnOverview(), "Email: " + emailShippingNew);
        Assert.assertEquals(myAccountPage.getPhoneShippingOnOverview(), "Phone: " + phoneNumberShippingNew);
        Assert.assertEquals(myAccountPage.getAddress1ShippingOnOverview(), addressShippingNew);
        Assert.assertEquals(myAccountPage.getCityStateZipShippingOnOverview(), cityShippingNew + "," + zipShippingNew);
        Assert.assertEquals(myAccountPage.getCountryShippingOnOverview(), countryShippingNew);
        Assert.assertEquals(myAccountPage.getShippingMethodOnOverview(), shippingMethodNew);
        Assert.assertEquals(myAccountPage.getShippingStatusOnOverview(), "Not yet shipped");
        Assert.assertEquals(myAccountPage.getSkuOnConfirmOrder(), expectedSku);
        Assert.assertEquals(myAccountPage.getProductNameOnConfirmOrder(), productTitleMacBookPro);
        Assert.assertEquals(myAccountPage.getUnitPriceOnConfirmOrder(), expectedUnitPrice);
        Assert.assertEquals(myAccountPage.getQuantityOnConfirmOrder(), expectedQuantity);
        Assert.assertEquals(myAccountPage.getSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getCartOptionOnConfirmOrder(), "Gift wrapping: " + expectedCartOption);
        Assert.assertEquals(myAccountPage.getOrderSubTotalOnConfirmOrder(), expectedSubTotal);
        Assert.assertEquals(myAccountPage.getShippingCostOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getTaxValueOnConfirmOrder(), "$0.00");
        Assert.assertEquals(myAccountPage.getOrderTotalOnConfirmOrder(), expectedOrderTotal);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}