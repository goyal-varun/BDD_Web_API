package com.hcl.testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@api",
//@CucumberOptions(tags = "@Ignore",
//@CucumberOptions(tags = "@SignUp or @SignIn or @PurchaseItems",
//@CucumberOptions(tags = "@SignIn or (not @SignUp and not @PurchaseItems and not @Run and not @Ignore)", 
//@CucumberOptions(tags = "@Run or (not @SignUp and not @SignIn and not @PurchaseItems and not @Ignore)",				 
				features = {"features"}, 
				 glue = {"com.hcl.stepdef"},
				 plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				 //plugin = { "pretty", "html:target/cucumber-reports.html" },
				 monochrome = true
				)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	
	  @Override
	  @DataProvider(parallel = true)
	  public Object[][] scenarios() { 
		  return super.scenarios(); 
	  }
}
