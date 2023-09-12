package com.hcl.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hcl.baseframework.BaseClass;
import com.hcl.baseframework.DriverUtils;
import com.hcl.baseframework.ExcelUtils;

public class SignInPage extends BaseClass{

	//WebDriver driver = null;

	public SignInPage() {
		// super(driver);			// Old Code
		PageFactory.initElements(DriverUtils.threadLocalDriver.get(), this);	
	}

	@FindBy(id="login2")
	WebElement signInLink;

	@FindBy(id="loginusername")
	WebElement signInUsernameTextField;

	@FindBy(id="loginpassword")
	WebElement signInPasswordTextField;

	@FindBy(xpath="//button[text()='Log in']")
	WebElement signInButton;

	@FindBy(id="nameofuser")
	WebElement welcomeUserText;
	
	@FindBy(id="logout2")
	WebElement logoutLink;

	@FindBy(xpath = "//button[text()='Log in']/preceding-sibling::button")
	WebElement closeButton;


	public void clickOnSignInLink() {
		clickOnElement(signInLink);
	}

	public void enterUsernamePasswordSignIn(String username, String password) {
		clickOnElement(signInUsernameTextField);
		typeText(signInUsernameTextField,username);
		clickOnElement(signInPasswordTextField);
		typeText(signInPasswordTextField,password);
	}

	public void clickOnSignInButton() throws InterruptedException {
		clickOnElement(signInButton);
		Thread.sleep(1000);
	}

	public void validateSignInSuccess() {
		waitForElementToBeVisible(welcomeUserText);
		Assert.assertTrue(welcomeUserText.getText().startsWith("Welcome"));
	}

	public void validateSignInFailInvalidPassword() throws InterruptedException, IOException {
		Thread.sleep(1000);
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue(handleAlert("getText").equals(ExcelUtils.getExcelData("warningMessages", "SignIn_Wrong_Password")));
		handleAlert("accept");
		clickOnElement(closeButton);
	}

	public void validateSignInFailUnregisteredUser() throws InterruptedException, IOException {
		Thread.sleep(1000);
		//System.out.println(handleAlert("getText"));
		Assert.assertTrue(handleAlert("getText").equals(ExcelUtils.getExcelData("warningMessages", "SignIn_User_Not_Exists")));
		handleAlert("accept");
		clickOnElement(closeButton);
	}

	public void clickOnLogoutLink() {
		clickOnElement(logoutLink);
	}

	public void validateMissingUsernamePassword() throws IOException {
		Assert.assertTrue(handleAlert("getText").equals(ExcelUtils.getExcelData("warningMessages", "SignIn_Missing_Username_Password")));
		handleAlert("accept");
		clickOnElement(closeButton);
	}
}
