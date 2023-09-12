package com.hcl.baseframework;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverUtils {

	public static WebDriver driver;
	public static ThreadLocal <WebDriver> threadLocalDriver = new ThreadLocal <WebDriver>();
	
	public static void getDriver() throws MalformedURLException {

		String browserType = System.getProperty("browser");
		DesiredCapabilities caps = new DesiredCapabilities();

		if (browserType.equals("chrome")) {
			caps.setBrowserName(browserType);
			//driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
			driver = new ChromeDriver();
			threadLocalDriver.set(driver);
		}
		else {
			driver = new EdgeDriver();
			threadLocalDriver.set(driver);
		}

		threadLocalDriver.get().get("https://www.demoblaze.com/index.html");
		threadLocalDriver.get().manage().window().maximize();
		threadLocalDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println("Before Test Thread ID: "+Thread.currentThread().getId()+"  "+threadLocalDriver.get());
	}

	public static void  tearDown() {
		System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
		if (threadLocalDriver.get()!=null)
			threadLocalDriver.get().quit();
		threadLocalDriver.remove();
	}
}
