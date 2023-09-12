package com.hcl.stepdef;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.Utilities;
import com.hcl.pageobjects.SignUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDef {

	SignUpPage signUpPage;

	@Given("Initialize the elements on the SignUp page") 
	public void initialize_the_elements_on_the_signup_page() { 
		//System.out.println("StepDefClass: "+Thread.currentThread().getId()+"  "+DriverUtils.threadLocalDriver.get());
		signUpPage = new SignUpPage();
	}

	@When("User clicks on Signup link")
	public void user_clicks_on_signup_link() {
		signUpPage.clickOnSignUpLink();
	}

	@When("User enters the new email and password on signup popup")
	public void user_enters_the_new_email_and_password_on_signup_popup() {
		int randomNumber = Utilities.randomNumberGenerator();
		signUpPage.enterUsernamePasswordSignUp("UserName" + randomNumber + "@gmail.com", "abcd123");
	}

	@When("User clicks on Signup button on the signup popup")
	public void user_clicks_on_signup_button_on_the_signup_popup() {
		signUpPage.clickOnSignUpButton();
	}

	@Then("validate that signup is successful")
	public void validate_that_signup_is_successful() throws IOException {
		signUpPage.validateSignupSuccess();
	}

	@When("User enters the existing email {string} and existing password {string} on signup popup")
	public void user_enters_the_existing_email_and_existing_password_on_signup_popup(String username, String password) {
		signUpPage.enterUsernamePasswordSignUp(username, password);
	}

	@Then("validate that signup is unsuccessful")
	public void validate_that_signup_is_unsuccessful() throws IOException {
		signUpPage.validateSignupFail();
	}

}