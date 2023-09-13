package com.hcl.stepdef;

import java.net.MalformedURLException;

//import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hcl.baseframework.DriverUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	String browserType = System.getProperty("browser");
	
	@Before
	public void initBrowser() throws MalformedURLException {
		//System.out.println("Before Hook");
		if (!browserType.equals("api"))
			DriverUtils.getDriver();
	}
	
	
	@BeforeStep
	public void beforeStepMethod() {
		//System.out.println("Before Step Method");
	}
	
	@AfterStep()
	public void afterStepMethod(Scenario scenario) throws InterruptedException {
		if(scenario.isFailed()) 
		{
			//System.out.println("###"+scenario.getName());
			Thread.sleep(1000);
			final byte[] screenshot = ((TakesScreenshot) DriverUtils.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	@After()
	public void closeBrowser() {
		//System.out.println("After Hook");
		if (!browserType.equals("api"))
			DriverUtils.tearDown();
	}	
}

