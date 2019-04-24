package com.makemytrip.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Operations {

	public static void scrollDown(WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver; 
		for (int i=0; i<10; i++)
		{ 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
	}
	
}
