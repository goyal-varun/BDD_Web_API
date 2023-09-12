package com.hcl.baseframework;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	JavascriptExecutor js = null;

	public BaseClass() {
		//this.driver = driver;
		//System.out.println("BaseClass: "+Thread.currentThread().getId()+"  "+DriverUtils.threadLocalDriver.get());
		js = (JavascriptExecutor) DriverUtils.threadLocalDriver.get();
	} 											

	public void clickOnElement(WebElement element) {
		waitForElementToBeVisible(element);
		element.click();
	}

	public void typeText(WebElement element, String value) {
		waitForElementToBeClickable(element);
		element.sendKeys(value);
	}

	public void waitForAlertPresence() {
		WebDriverWait wait = new WebDriverWait(DriverUtils.threadLocalDriver.get(), Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public String handleAlert(String alertType) {
		waitForAlertPresence();
		Alert alert = DriverUtils.threadLocalDriver.get().switchTo().alert();  // New Code
		switch(alertType) {
		case "getText":
			return alert.getText();
		}

		if (alertType.equals("getText")) {
			return alert.getText();
		} 

		else if (alertType.equals("dismiss")) {
			alert.dismiss();
			return "";
		} 

		else if (alertType.equals("accept")) {
			alert.accept();
			return "";
		}
		return "";
	}

	public void scrollPage(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void jsClickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverUtils.threadLocalDriver.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverUtils.threadLocalDriver.get(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public WebElement getDriverElement(String locator1, String locator2) {
		return DriverUtils.threadLocalDriver.get().findElement(By.xpath(locator1+locator2));
	}
	
}
