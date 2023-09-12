package com.hcl.stepdef;

import java.io.IOException;

import com.hcl.pageobjects.PurchaseItemsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseItemsStepDef {

	PurchaseItemsPage purchaseItemsPage = null;

	@Given("Initialize the elements on the PurchaseItems page")
	public void initialize_the_elements_on_the_PurchaseItems_page() {
		purchaseItemsPage = new PurchaseItemsPage();			
	}

	@When ("User clicks on product type link {string}") 
	public void user_clicks_on_product_type_link(String productType) {
		purchaseItemsPage.clickOnProductTypeLink(productType);
	}

	@When("User searches for a product {string}")
	public void user_searches_for_a_product(String productName) {
		purchaseItemsPage.clickOnProductNameLink(productName);
	}

	@When("User adds multiple quantities {int} of above product to cart")
	public void user_adds_multiple_quantities_of_above_product_to_cart(Integer Qty) throws IOException {
		purchaseItemsPage.addToCartButton(Qty);
	}

	@When("User navigates to cart")
	public void user_navigates_to_cart() {
		purchaseItemsPage.clickOnCartLink();
	}

	@Then("validate products in a cart")
	public void validate_products_in_cart() {
		purchaseItemsPage.validateTotalCartValue();
	}
	
	@Then("validate that selected products are added to cart")
	public void validate_that_selected_products_are_added_to_cart() throws InterruptedException {
		purchaseItemsPage.validateAddedProductsInCart();
	}

	@When("User navigates to Home page")
	public void user_navigates_to_home_page() {
		purchaseItemsPage.clickOnHomeLink();	
	}

	@Given("User has added product {string} and quantity {int} under category {string} to cart")
	public void user_has_added_product_and_quantity_under_category_to_cart(String productName, Integer Qty, String productType) throws IOException {
		user_clicks_on_product_type_link(productType);
		user_searches_for_a_product(productName);
		user_adds_multiple_quantities_of_above_product_to_cart(Qty);
		user_navigates_to_cart();
	}

	@When("User clicks on Place Order button")
	public void user_clicks_on_place_order_button() {
		purchaseItemsPage.clickOnPlaceOrderButton();
	}

	@When("User enters name in Name field {string}")
	public void user_enters_name_in_name_field(String string) {
		purchaseItemsPage.enterPlaceOrderNameTextField(string);
	}

	@When("User enters country in Country field {string}")
	public void user_enters_country_in_country_field(String string) {
		purchaseItemsPage.enterPlaceOrderCountryTextField(string);
	}

	@When("User enters city in City field {string}")
	public void user_enters_city_in_city_field(String string) {
		purchaseItemsPage.enterPlaceOrderCityTextField(string);
	}

	@When("User enters card details in Credit Card field {string}")
	public void user_enters_card_details_in_credit_card_field(String string) {
		purchaseItemsPage.enterPlaceOrderCreditCardTextField(string);
	}

	@When("User enters month in Month field {string}")
	public void user_enters_month_in_field(String string) {
		purchaseItemsPage.enterPlaceOrderMonthTextField(string);
	}

	@When("User enters year in Year field {string}")
	public void user_enters_year_in_field(String string) {
		purchaseItemsPage.enterPlaceOrderYearTextField(string);
	}

	@When("User clicks on Purchase button")
	public void user_clicks_on_purchase_button() {
		purchaseItemsPage.clickOnPlaceOrderPurchaseButton();
	}

	@Then("validate that order ID is generated")
	public void validate_that_order_id_is_generated() throws InterruptedException {
		purchaseItemsPage.fetchOrderID();
		purchaseItemsPage.clickOnPurchaseOrderOKButton();
	}
	
	@When("User adds the following product {string} and quantity {string} under category {string} to cart")
	public void user_adds_the_following_product_and_quantity_under_category_to_cart(String productName, String Qty, String productType) throws NumberFormatException, IOException {
		purchaseItemsPage.addItemsToCart(productType, productName, Qty);
	}
	
	@Given("User clears the cart")
	public void user_clears_the_cart() throws InterruptedException {
		user_navigates_to_cart();
		purchaseItemsPage.flushCartItems();
	}

	@Then ("User Logout of the application after final purchase")
	public void user_logout_of_the_application_after_final_purchase() {
		purchaseItemsPage.clickOnLogoutLink();
	}
	
}
