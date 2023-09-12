package com.hcl.pageobjects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.ExcelUtils;

public class SignUpPage extends BaseClass {

	// Locators of the singup page - Username, passowrd, signuplink, signup, close,
	// X etc.,
	// Actions of the signup page
	// - enterUsername, enterpssword, clickonsignup
	// - signupMethod

	public WebDriver driver;
	Alert alert = null;

	public SignUpPage() {
		super(); 			
		//System.out.println("PageClass: "+Thread.currentThread().getId()+"  "+DriverUtils.threadLocalDriver.get());
		PageFactory.initElements(DriverUtils.threadLocalDriver.get(), this);
	}

	@FindBy(id = "signin2")
	WebElement signUpLink;

	@FindBy(id = "sign-username")
	WebElement signUpUserNameTextField;

	@FindBy(id = "sign-password")
	WebElement signUpPasswordTextField;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//button[text()='Sign up']/preceding-sibling::button")
	WebElement closeButton;

	public void clickOnSignUpLink() {

		clickOnElement(signUpLink);
	}

	public void enterUsernamePasswordSignUp(String username, String password) {
		typeText(signUpUserNameTextField, username);
		typeText(signUpPasswordTextField, password);
	}

	public void clickOnSignUpButton() {
		clickOnElement(signUpButton);
	}

	public void validateSignupSuccess() throws IOException {

		// return actualMessage.equals(expectedMessage)? true : false;
		Assert.assertTrue((handleAlert("getText").equals(ExcelUtils.getExcelData("warningMessages", "SignUp_Success"))));
		handleAlert("accept");
	}

	public void validateSignupFail() throws IOException {
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue((handleAlert("getText").equals(ExcelUtils.getExcelData("warningMessages", "SignUp_User_Exists"))));
		
		handleAlert("accept");
		clickOnElement(closeButton);
	}

}