package com.hcl.withoutframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InitialSetup {

	WebDriver driver=null;
	
	public void browserSetup() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		System.out.println(System.getProperty("user.dir"));
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) 
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Edge")) 
			driver = new EdgeDriver();
		
		driver.get(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
}
