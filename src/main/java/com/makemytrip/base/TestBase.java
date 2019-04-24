package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase()
	{
		properties = new Properties();
		try 
		{
			FileInputStream proFile = new FileInputStream("D://NaveenAssignments//MakeMyTrip.Assignment//src//main//java//com//makemytrip//config//config.properties");
			properties.load(proFile);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public static void initialize()
	{
		String browser = properties.getProperty("Browser");
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		else
			if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));

	}
	
	

}
