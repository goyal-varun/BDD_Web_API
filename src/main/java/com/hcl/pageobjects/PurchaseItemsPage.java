package com.hcl.pageobjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.ExcelUtils;
import com.hcl.baseframework.Utilities;

public class PurchaseItemsPage extends BaseClass {

	HashMap<String, Integer> productsInCart = new HashMap<String, Integer>();
	public static String productType = "";
	public String productTypeLinkName = " ";
	

	public PurchaseItemsPage() {
		// super(driver); // Old Code
		PageFactory.initElements(DriverUtils.threadLocalDriver.get(), this);
	}

	@FindBy(xpath = "//*[contains(text(),'Phones')]")
	WebElement PhonesLink;

	@FindBy(xpath = "//*[contains(text(),'Laptops')]")
	WebElement LaptopsLink;

	@FindBy(xpath = "//*[contains(text(),'Monitors')]")
	WebElement MonitorsLink;

	@FindBy(xpath = "")
	WebElement AppleMonitor24Link;

	/*
	 * @FindAll({
	 * 
	 * @FindBy(xpath=("//h4[@class='card-title']"))
	 * //@FindBy(xpath=("//h4[@class='card-title]")) }) List<WebElement>
	 * productNamesLinks;
	 */

	@FindBy(xpath = ("//h4[@class='card-title']/a"))
	WebElement productNamesLink;

	@FindBy(xpath = "//*[contains(text(),'Add to cart')]")
	WebElement addToCartButton;

	@FindBy(xpath = ("//tr[@class='success']"))
	List<WebElement> itemsInCart;

	@FindBy(linkText = "Delete")
	List<WebElement> deleteCartItemCount;

	@FindBy(linkText = "Delete")
	WebElement deleteCartItemLink;

	@FindBy(xpath = "//h2[contains(text(),'Total')]")
	WebElement totalTextLabel;

	@FindBy(id = "totalp")
	WebElement totalCartValue;

	@FindBy(xpath = "//*[contains(text(),'Cart')]")
	WebElement cartLink;

	@FindBy(partialLinkText = "Home")
	WebElement homeLink;

	@FindBy(xpath = "//button[(text()='Place Order')]")
	WebElement placeOrderButton;

	@FindBy(id = "name")
	WebElement placeOrderNameTextField;

	@FindBy(id = "country")
	WebElement placeOrderCountryTextField;

	@FindBy(id = "city")
	WebElement placeOrderCityTextField;

	@FindBy(id = "card")
	WebElement placeOrderCreditCardTextField;

	@FindBy(id = "month")
	WebElement placeOrderMonthTextField;

	@FindBy(id = "year")
	WebElement placeOrderYearTextField;

	@FindBy(xpath = "//*[contains(text(),'Purchase')]/preceding-sibling::button")
	WebElement placeOrderCloseButton;

	@FindBy(xpath = "//button[(text()='Purchase')]")
	WebElement placeOrderPurchaseButton;

	@FindBy(xpath = "//*[contains(text(),'Thank you for your purchase!')]")
	WebElement thankYouPurchaseText;

	@FindBy(xpath = "//p[@class = 'lead text-muted ']")
	WebElement orderIDText;

	@FindBy(xpath = "//button[(text()='OK')]")
	WebElement purchaseOrderOKButton;

	@FindBy(id = "logout2")
	WebElement logoutLink;

	public void clickOnProductTypeLink(String productLink) {
		switch (productLink) {
		case "Phones":
			scrollPage(PhonesLink);
			clickOnElement(PhonesLink);
			break;

		case "Laptops":
			scrollPage(LaptopsLink);
			clickOnElement(LaptopsLink);
			break;

		case "Monitors":
			scrollPage(MonitorsLink);
			clickOnElement(MonitorsLink);
			break;
		}
	}

	public void clickOnProductNameLink(String productName) {
		clickOnElement(DriverUtils.threadLocalDriver.get().findElement(By.partialLinkText(productName)));
	}

	public void addToCartButton(Integer addQty) throws IOException {
		for (int i = 0; i < addQty; i++) {
			clickOnElement(addToCartButton);
			handleAlert("getText");
			Assert.assertEquals(handleAlert("getText"), ExcelUtils.getExcelData("warningMessages", "AddToCart_ProductAdded"));
			handleAlert("accept");
		}
	}

	public void clickOnCartLink() {
		clickOnElement(cartLink);
	}

	public void clickOnHomeLink() {
		clickOnElement(homeLink);
	}

	public void clickOnPlaceOrderButton() {
		clickOnElement(placeOrderButton);
	}

	public void enterPlaceOrderNameTextField(String name) {
		clickOnElement(placeOrderNameTextField);
		typeText(placeOrderNameTextField, name);
	}

	public void enterPlaceOrderCountryTextField(String country) {
		clickOnElement(placeOrderCountryTextField);
		typeText(placeOrderCountryTextField, country);
	}

	public void enterPlaceOrderCityTextField(String city) {
		clickOnElement(placeOrderCityTextField);
		typeText(placeOrderCityTextField, city);
	}

	public void enterPlaceOrderCreditCardTextField(String card) {
		clickOnElement(placeOrderCreditCardTextField);
		typeText(placeOrderCreditCardTextField, card);
	}

	public void enterPlaceOrderMonthTextField(String month) {
		clickOnElement(placeOrderMonthTextField);
		typeText(placeOrderMonthTextField, month);
	}

	public void enterPlaceOrderYearTextField(String year) {
		clickOnElement(placeOrderYearTextField);
		typeText(placeOrderYearTextField, year);
	}

	public void clickOnPlaceOrderPurchaseButton() {
		clickOnElement(placeOrderPurchaseButton);
	}

	public void fetchOrderID() {
		waitForElementToBeVisible(thankYouPurchaseText);
		String orderId = orderIDText.getText();
		String[] stringPart;
		stringPart = Utilities.splitStringExtractText(orderId, "\n");
		System.out.println("** Order " + stringPart[0] + " **");
	}

	public void clickOnPurchaseOrderOKButton() {
		clickOnElement(purchaseOrderOKButton);
	}

	public void clickOnLogoutLink() {
		jsClickElement(logoutLink);
	}

	public void clickOnPlaceOrderCloseButton() {
		// clickOnElement(placeOrderCloseButton);
	}

	public void addItemsToCart(String productType, String productName, String Qty) throws NumberFormatException, IOException {
		String[] productTypes = Utilities.splitStringExtractText(productType.trim(), ",");
		String[] productNames = Utilities.splitStringExtractText(productName.trim(), ",");
		String[] quantities = Utilities.splitStringExtractText(Qty.trim(), ",");
		for (int i = 0; i < productTypes.length; i++) {
			String[] product = Utilities.splitStringExtractText(productNames[i], ":");
			String[] quantity = Utilities.splitStringExtractText(quantities[i], ":");
			if (product.length > 1) {
				for (int j = 0; j < product.length; j++) {
					clickOnProductTypeLink(productTypes[i]);
					clickOnProductNameLink(product[j].trim());
					addToCartButton(Integer.parseInt(quantity[j].trim()));
					productsInCart.put(product[j].trim(), Integer.parseInt(quantity[j].trim()));
					clickOnHomeLink();
				}
			} else {
				clickOnProductTypeLink(productTypes[i].trim());
				clickOnProductNameLink(product[0].trim());
				addToCartButton(Integer.parseInt(quantity[0].trim()));
				productsInCart.put(product[0].trim(), Integer.parseInt(quantity[0].trim()));
				clickOnHomeLink();
			}
		}
	}

	public void validateTotalCartValue() {
		waitForElementToBeVisible(totalCartValue);
		Assert.assertFalse(totalCartValue.getText().isBlank());
	}

	public void validateAddedProductsInCart() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToBeVisible(totalCartValue);
		int itemCount = 0;
		int cartValue = 0;
		// int itemsInCart =
		// driver.findElements(By.xpath("//tr[@class='success']")).size();
		for (Map.Entry map : productsInCart.entrySet()) {
			for (int i = 0; i < (int) map.getValue(); i++) {
				String productName = "//td[contains(text(),'" + map.getKey() + "')]";

				// System.out.println("productNameLocator: "+productName);
				// productName = itemsInCart.toString().concat(productName);
				// System.out.println("productNameLocatorConcatenate: "+productName);

				String productCost = productName + "/following-sibling::td";
				productName = DriverUtils.threadLocalDriver.get().findElement(By.xpath(productName)).getText();
				productCost = DriverUtils.threadLocalDriver.get().findElement(By.xpath(productCost)).getText();

				// System.out.println("Product Name: "+productName);
				// System.out.println("Product Cost: "+productCost);

				cartValue = cartValue + Integer.parseInt(productCost);
				itemCount = itemCount + 1;
			}
		}
		Assert.assertEquals(Integer.parseInt(totalCartValue.getText()), cartValue);
	}

	public void flushCartItems() throws InterruptedException {
		Thread.sleep(2000);
		waitForElementToBeVisible(totalCartValue);
		// waitForElementToBeVisible(totalTextLabel);
		System.out.println("Total Cart Value: " + totalCartValue.getText());
		if (!totalCartValue.getText().isBlank()) {
			int itemCount = deleteCartItemCount.size();
			System.out.println("No. of products to be Deleted: " + itemCount);
			for (int i = itemCount; i > 0; i--) {
				waitForElementToBeVisible(totalCartValue);
				Thread.sleep(1000);
				clickOnElement(deleteCartItemLink);
				// System.out.println("***Product Deleted");

			}
		} else
			System.out.println("Cart Empty");
		clickOnHomeLink();
	}

}
