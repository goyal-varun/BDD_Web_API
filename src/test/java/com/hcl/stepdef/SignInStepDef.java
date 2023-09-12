package com.hcl.stepdef;

import java.io.IOException;

import com.hcl.pageobjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInStepDef {

	SignInPage signInPage = null;

	@Given("Initialize the elements on the SignIn page")
	public void initialize_the_elements_on_the_SignIn_page() {
		signInPage = new SignInPage();			
	}
	
	@When("User clicks on Signin link")
	public void user_clicks_on_signin_link() { 
		signInPage.clickOnSignInLink();
	}

	@When("User enters the username {string} and password {string} on signin popup")
	public void user_enters_the_username_and_password_on_signin_popup(String username, String password) {
		signInPage.enterUsernamePasswordSignIn(username, password);
	}

	@When("User clicks on Signin button on the signin popup")
	public void user_clicks_on_signin_button_on_the_signin_popup() throws InterruptedException {
		signInPage.clickOnSignInButton();
	}

	@Then("validate that Signin is successful")
	public void validate_signin_is_successful()  {
		signInPage.validateSignInSuccess();
	}

	@Then("validate that Signin is unsuccessful for invalid password")
	public void validate_that_signin_is_unsuccessful_for_invalid_password() throws InterruptedException, IOException {
		signInPage.validateSignInFailInvalidPassword();
	}

	@Then("validate that Signin is unsuccesful for unregistered user")
	public void validate_that_signin_is_unsuccesful_for_unregistered_user() throws InterruptedException, IOException {
		signInPage.validateSignInFailUnregisteredUser();
	}

	@Then ("validate that missing username or password error")
	public void validate_that_missing_username_or_password_error() throws IOException {
		signInPage.validateMissingUsernamePassword();
	}

	@Then("User clicks on Logout button")
	public void user_clicks_on_logout_button() throws InterruptedException {
		signInPage.clickOnLogoutLink();
	}

	@Given("User has Login into the application with username {string} and password {string}")
	public void login_into_application(String username, String password) throws InterruptedException {
		initialize_the_elements_on_the_SignIn_page();
		user_clicks_on_signin_link();
		user_enters_the_username_and_password_on_signin_popup(username, password);
		user_clicks_on_signin_button_on_the_signin_popup();
		validate_signin_is_successful();
	}

}