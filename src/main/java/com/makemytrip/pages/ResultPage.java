package com.makemytrip.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;
import com.makemytrip.util.Operations;

public class ResultPage extends TestBase{
	
	@FindBy(xpath="//label[@for='filter_stop0']")
	WebElement nonStopRadioButton;

	@FindBy(id="//label[@for='filter_stop1']")
	WebElement oneStopRadioButton;

	@FindBy(xpath="//div[@class='splitVw-footer-left ']//p[@class='actual-price']")
	WebElement bottomDepPrice;

	@FindBy(xpath="//div[@class='splitVw-footer-right ']//p[@class='actual-price']")
	WebElement bottomRetPrice;

	@FindBy(xpath="//span[@class='splitVw-total-fare']")
	WebElement totalPrice;

	

	public ResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	//it return the list of Departure and return flights list
	public List<WebElement> getFlightsList(String typeOfFlights)
	{
		if(typeOfFlights.equalsIgnoreCase("Departure"))
		{
			Operations.scrollDown(driver);
			List<WebElement> listOfdepatureFlights = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']"));
			return listOfdepatureFlights;
		}else
			if(typeOfFlights.equalsIgnoreCase("return"))
			{
				Operations.scrollDown(driver);
				List<WebElement> listOfReturnFlights = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));
				
				return listOfReturnFlights;
			}
			return null;
	}
	//it will select the non stop
	public void selectNonStop()
	{
		if(driver.findElement(By.xpath("//label[@for='filter_stop0']")).isSelected())
		{
			System.out.println("non stop selected");
		}
		else
		{
			driver.findElement(By.xpath("//label[@for='filter_stop0']")).click();
		}
		
	}
	//it return the list of Departure flights list of non stop
	public List<WebElement> getNonStopFlightsList(String typeOfFlights)
	{
		//driver.navigate().refresh();
		
		if(typeOfFlights.equalsIgnoreCase("Departure"))
		{
			Operations.scrollDown(driver);
			List<WebElement> listOfDepFlightNonStop= driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']"));
			return listOfDepFlightNonStop;
			
		}else
			if(typeOfFlights.equalsIgnoreCase("Return"))
			{
				
				List<WebElement> listOfRetFlightNonStop = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));
				return listOfRetFlightNonStop;
				
			}
			return null;
	}
	//it will select the One stop
	public void selectOneStop()
	{ 
		driver.navigate().refresh();
		if (driver.findElement(By.xpath("//p[@class='fflow-head LatoBold append_bottom7']")).isDisplayed())
		{
			driver.findElement(By.xpath("//a[@class='fli-clear inlineB']")).click();
		}
		if(driver.findElement(By.xpath("//label[@for='filter_stop1']")).isSelected())
		{
			System.out.println("one stop selected");
		}
		else
		{
			driver.findElement(By.xpath("//label[@for='filter_stop1']")).click();
		}
	}
	//it return the list of Departure and return flights list of One stop
	public List<WebElement> getOneStopFlightsList(String typeOfFlights)
	{
		//driver.navigate().refresh();
		
		if(typeOfFlights.equalsIgnoreCase("Departure"))
		{
			Operations.scrollDown(driver);
			List<WebElement> listOfDepFlightsOneStop = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']"));
			return listOfDepFlightsOneStop;
			
		}else
			if(typeOfFlights.equalsIgnoreCase("return"))
			{
				//Operations.scrollDown(driver);
				List<WebElement> listOfRetFlightsOneStop = driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));
				
				return listOfRetFlightsOneStop;
				
				
			}
			return null;
	}
	//it will select departure flights from result list based on index and returns the price
	public String selectDepatureFlight(int position)
	{
		
		if(driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-left']//span[@class='splitVw-inner'])[position()="+position+"]")).isSelected())
		{
			String deptPrice = driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-left']//p[@class='actual-price'])[position()="+position+"]")).getText();
			return deptPrice;
		}
		else
		{
			driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-left']//span[@class='splitVw-inner'])[position()="+position+"]")).click();
			String deptPrice = driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-left']//p[@class='actual-price'])[position()="+position+"]")).getText();
			return deptPrice;
		}
	}
	//it will select return flights from result list based on index and returns the price
	public String selectReturnFlight(int position)
	{
		driver.navigate().refresh();
		if(driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-right']//div[@class='paddLR15 make_flex append_bottom7'])[position()="+position+"]")).isSelected())
		{
			String retPrice = driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-right']//p[@class='actual-price'])[position()="+position+"]")).getText();
			return retPrice;
		}
		else
		{
			driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-right']//div[@class='paddLR15 make_flex append_bottom7'])[position()="+position+"]")).click();
			String retPrice = driver.findElement(By.xpath("(//div[@class='splitVw-sctn pull-right']//p[@class='actual-price'])[position()="+position+"]")).getText();
			return retPrice;
		
		}
		
	}
	//it return the bottom departure flight price
	public String getBottomDepaturePrice()
	{
		String btmDepPrice = bottomDepPrice.getText();
		return btmDepPrice;
	}
	//it return the bottom return flight price
	public String getBottomReturnPrice()
	{
		String btmRetPrice = bottomRetPrice.getText();
		return btmRetPrice;
	}
	//it return the bottom total flight price
	public String getTotalPrice()
	{
		String bottomTotalPrice = totalPrice.getText();
		return bottomTotalPrice;
	}

}
