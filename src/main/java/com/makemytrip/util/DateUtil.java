package com.makemytrip.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil
{
	public static LocalDate date;
	public static DateTimeFormatter dtf;
	public static String departureDate()
	{
		date = LocalDate.now();
		dtf = DateTimeFormatter.ofPattern("MMM dd yyyy");
		String GoingDate = dtf.format(date);
		return GoingDate;
		//LocalDate nextDate = date.plusDays(7);
		//String returnDate = dtf.format(nextDate);
		
	}
	public static String returnDate()
	{
		LocalDate nextDate = date.plusDays(7);
		String returnDate = dtf.format(nextDate);
		return returnDate;
				
	}
}
