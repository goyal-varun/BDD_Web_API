package com.hcl.withoutframework;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Functions {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);
	// String emailId = "username" + randomInt + "@gmail.com";
	String emailId = "username354@gmail.com";
	String password = "abcd123"; 
	// WebDriver driver = null;
	
	@BeforeClass(alwaysRun = true)
	public void initialSetup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//config.properties");
		System.out.println(System.getProperty("user.dir"));
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();

		driver.get(prop.getProperty("applicationUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;

	}

	/*
	 * @Test(priority = 1) 
	 * public void signUp() {
	 * 
	 * driver.findElement(By.xpath("//a[@id='signin2']")).click();
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 * 
	 * driver.findElement(By.id("sign-username")).click();
	 * driver.findElement(By.id("sign-username")).sendKeys(emailId);
	 * driver.findElement(By.id("sign-password")).click();
	 * driver.findElement(By.id("sign-password")).sendKeys(password);
	 * driver.findElement(By.xpath("//button[text()='Sign up']")).click();
	 * 
	 * // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.alertIsPresent()); Alert alert =
	 * driver.switchTo().alert();
	 * 
	 * String actualMessage = alert.getText();
	 * 
	 * String expectedMessage = "Sign up successful.";
	 * AssertJUnit.assertEquals(actualMessage, expectedMessage);
	 * System.out.println("Alert Message: " + actualMessage); alert.accept(); }
	 */

	@Test(priority = 2)
	public void signIn() throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(By.id("login2")).click();

		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys(emailId);
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		wait.until(ExpectedConditions.textMatches((By.id("nameofuser")), Pattern.compile("Welcome*")));
		System.out.println("SignIn Successful - " + emailId);

	}

	@Test(priority = 3)
	public void addItem() throws InterruptedException {

		WebElement monitorElement = driver.findElement(By.xpath("//*[contains(text(),'Monitors')]"));
		
		//js.executeScript("arguments[0].scrollIntoView();", monitorElement);

		monitorElement.click();
		String productName = "Apple monitor 24";
		driver.findElement(By.xpath("//*[contains(text(),'" + productName + "')]")).click();
		int addQty = 2;

		for (int i = 0; i < addQty; i++) {
			driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			Assert.assertEquals(alertMessage, "Product added.");
			alert.accept();
		}

		driver.findElement(By.xpath("//*[contains(text(),'Cart')]")).click();
		for (int i = 1; i < addQty + 1; i++) {
			// System.out.println("//tr[@class='success'][1]/td[2]");
			String actualProductName = driver.findElement(By.xpath("//tr[@class='success'][" + i + "]/td[2]"))
					.getText();
			assertEquals(actualProductName, productName);
		}
		driver.findElement(By.xpath("//button[(text()='Place Order')]")).click();
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("Varun Goyal");

		driver.findElement(By.id("country")).click();
		driver.findElement(By.id("country")).sendKeys("India");

		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).sendKeys("Chandigarh");

		driver.findElement(By.id("card")).click();
		driver.findElement(By.id("card")).sendKeys("1234123412341234");

		driver.findElement(By.id("month")).click();
		driver.findElement(By.id("month")).sendKeys("09");

		driver.findElement(By.id("year")).click();
		driver.findElement(By.id("year")).sendKeys("28");

		driver.findElement(By.xpath("//button[(text()='Purchase')]")).click();

		Thread.sleep(1000);
		Boolean thankMessage = driver.findElement(By.xpath("//*[contains(text(),'Thank you for your purchase!')]"))
				.isDisplayed();
		Assert.assertTrue(thankMessage);

		String orderId = driver.findElement(By.xpath("//p[@class = 'lead text-muted ']")).getText();

		String[] stringParts = orderId.split(Pattern.quote("\n"));
		String partA = stringParts[0];
		System.out.println("Order " + partA);

		driver.findElement(By.xpath("//button[(text()='OK')]")).click();
		driver.findElement(By.id("logout2")).click();

	}

	/*@Test(priority = 4)
	public void itemCost() throws InterruptedException {

		WebElement laptopElement = driver.findElement(By.xpath("//*[contains(text(),'Laptops')]"));
		js.executeScript("arguments[0].scrollIntoView();", laptopElement);
		laptopElement.click();
		Thread.sleep(1000);
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("Sony vaio i5", "$790");
		hm.put("Sony vaio i7", "$790");
		hm.put("MacBook air", "$700");
		hm.put("Dell i7 8gb", "$700");
		hm.put("2017 Dell 15.6 Inch", "$700");
		hm.put("MacBook Pro", "$1100");
		// System.out.println(hm.get("MacBook Pro"));

		int itemCount = driver.findElements(By.xpath("//h4[@class='card-title']")).size();
		for (int i = 0; i < itemCount; i++) {
			String productName = driver.findElements(By.xpath("//h4[@class='card-title']")).get(i).getText();
			String productPrice = driver.findElements(By.xpath("//h4[@class='card-title'][1]/following-sibling::h5"))
					.get(i).getText();
			// System.out.println(productName);
			// System.out.println(productPrice);
			Assert.assertEquals(productPrice, hm.get(productName));
		}

	}*/

	/*
	 * @AfterClass public void closeBrowser() { driver.quit(); }
	 */

}
