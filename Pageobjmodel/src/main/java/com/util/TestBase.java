package com.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase()
	{
		try {
			
			prop=new Properties();
			FileInputStream fs= new FileInputStream("C:/Users/admin/eclipse-workspace/Pageobjmodel/src/main/java/com/config.properties");
				prop.load(fs);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
	
	
	public static void initialize() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\ChromeSetup.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
					
		{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			  driver= new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}
}
}
