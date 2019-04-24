package com.makemytrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText="Flights")
	WebElement flightButton;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	public FlightsPage clickOnFilghts()
	{
		flightButton.click();
		return new FlightsPage();
	}

}
