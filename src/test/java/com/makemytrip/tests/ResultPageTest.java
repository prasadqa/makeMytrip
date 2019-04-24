package com.makemytrip.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.FlightsPage;
import com.makemytrip.pages.HomePage;
import com.makemytrip.pages.ResultPage;
import com.makemytrip.util.DateUtil;
import com.makemytrip.util.ExelUtil;

public class ResultPageTest extends TestBase {
	FlightsPage flightsPage;
	HomePage homePage;
	ResultPage resultPage;
	ExelUtil exelUtil;

	public ResultPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialize();
		exelUtil = new ExelUtil();
		flightsPage = new FlightsPage();
		homePage = new HomePage();
		resultPage = new ResultPage();

		homePage.clickOnFilghts();

		flightsPage.clickOnRoundTrip();
		flightsPage.enterCities(exelUtil.getCellData("Sheet1", 1, 0), exelUtil.getCellData("Sheet1", 1, 1));
		flightsPage.enterDates(DateUtil.departureDate(), DateUtil.returnDate());
		flightsPage.clickOnSearchButtom();

	}

	// Test case 1: Printing the number of Flights between two date with 7days
	@Test(priority = 0)
	public void printFlightsList() {
		List<WebElement> listOfDepFlights = resultPage.getFlightsList("Departure");
		System.out.println("Number of Departure Flights : " + listOfDepFlights.size());
		for (int i = 0; i < listOfDepFlights.size(); i++) {
			String nameOfFlight = listOfDepFlights.get(i).getText();
			System.out.println(nameOfFlight);
		}
		List<WebElement> listOfRetFlights = resultPage.getFlightsList("Return");
		System.out.println("Number of Return Flights : " + listOfRetFlights.size());
		for (int i = 0; i < listOfRetFlights.size(); i++) {
			String nameOfFlight = listOfRetFlights.get(i).getText();
			System.out.println(nameOfFlight);
		}
	}

	// Test case 2 : Printing number of flights with filter Non stop
	@Test(priority = 1)
	public void printFlightsListNonStop() {
		resultPage.selectNonStop();
		List<WebElement> listOfDepartureFlightsNonStop = resultPage.getNonStopFlightsList("Departure");
		System.out.println("Number of Departure Non Stop Flights : " + listOfDepartureFlightsNonStop.size());
		for (int i = 0; i < listOfDepartureFlightsNonStop.size(); i++) {
			String nameOfFlight = listOfDepartureFlightsNonStop.get(i).getText();
			System.out.println(nameOfFlight);
		}
		List<WebElement> listOfReturnFlightsNonStop = resultPage.getNonStopFlightsList("Return");
		System.out.println("Number of Return Non Stop Flights : " + listOfReturnFlightsNonStop.size());
		for (int i = 0; i < listOfReturnFlightsNonStop.size(); i++) {
			String nameOfFlight = listOfReturnFlightsNonStop.get(i).getText();
			System.out.println(nameOfFlight);
		}
	}

	// Test case 3 : Printing number of flights with filter One stop
	@Test(priority = 2)
	public void printFlightsListOneStop() {

		resultPage.selectOneStop();
		List<WebElement> listOfDepartureFlightsOneStop = resultPage.getOneStopFlightsList("Departure");
		System.out.println("Number of Departure One Stop Flights : " + listOfDepartureFlightsOneStop.size());
		for (int i = 0; i < listOfDepartureFlightsOneStop.size(); i++) {
			String nameOfFlight = listOfDepartureFlightsOneStop.get(i).getText();
			System.out.println(nameOfFlight);
		}
		List<WebElement> listOfReturnFlightsOneStop = resultPage.getOneStopFlightsList("Return");
		System.out.println("Number of Return One Stop Flights : " + listOfReturnFlightsOneStop.size());
		for (int i = 0; i < listOfReturnFlightsOneStop.size(); i++) {
			String nameOfFlight = listOfReturnFlightsOneStop.get(i).getText();
			System.out.println(nameOfFlight);
		}
	}

	// test case 4: compare departure prices
	@Test(priority = 3)
	public void VerifyDeparturePrices() {

		String actPrice = resultPage.selectDepatureFlight(1);
		String expPrice = resultPage.getBottomDepaturePrice();
		System.out.println(actPrice+" "+expPrice);
		Assert.assertEquals(actPrice, expPrice);
	}

	// test case 5: compare return prices
	@Test(priority = 4)
	public void VerifyReturnPrices() {

		String actPrice = resultPage.selectReturnFlight(2);
		String expPrice = resultPage.getBottomReturnPrice();
		System.out.println(actPrice+" "+expPrice);
		Assert.assertEquals(actPrice, expPrice);
	}
	// test case 6: compare total prices
	@Test(priority = 5)
	public void VerifyTotalPrices() {
		String DepPrice = resultPage.selectDepatureFlight(1);
		String DepPriceInt = CharMatcher.digit().retainFrom(DepPrice);
		int DepRate = Integer.parseInt(DepPriceInt);

		String RetPrice = resultPage.selectReturnFlight(2);
		String ReTPriceInt = CharMatcher.digit().retainFrom(RetPrice);
		int RetRate = Integer.parseInt(ReTPriceInt);

		String totalPrice = resultPage.getTotalPrice();
		String totalPriceInt = CharMatcher.digit().retainFrom(totalPrice);
		int totalRate = Integer.parseInt(totalPriceInt);
		System.out.println(DepRate + RetRate+" "+totalRate);
		Assert.assertEquals(DepRate + RetRate, totalRate);
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
