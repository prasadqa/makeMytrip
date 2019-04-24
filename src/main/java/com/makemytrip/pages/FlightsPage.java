package com.makemytrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;

public class FlightsPage extends TestBase{
	
	@FindBy(xpath="//li[text()='Round Trip']")
	WebElement roundTrip;

	@FindBy(id="fromCity")
	WebElement enterFromCity;
	
	@FindBy(id="toCity")
	WebElement enterToCity;
	
	
	@FindBy( xpath = "//a[text()='Search']")
	WebElement searchButton;
	
	@FindBy( xpath = "(//span[contains(@class,'lbl_input latoBold appendBottom10')])[1]")
	WebElement dateButton;
	
	
	public FlightsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRoundTrip()
	{
		roundTrip.click();
	}
	public void enterCities(String fromCity,String toCity)
	{
		enterFromCity.sendKeys(fromCity);
		enterToCity.sendKeys(toCity);
	}
	public void enterDates(String depatureDate,String retunrDate)
	{
		dateButton.click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+depatureDate+"')]")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+retunrDate+"')]")).click();
		
	}
	public ResultPage clickOnSearchButtom()
	{
		searchButton.click();
		return new ResultPage();
	}

}
