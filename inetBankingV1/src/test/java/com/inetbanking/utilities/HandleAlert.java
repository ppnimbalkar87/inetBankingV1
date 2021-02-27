package com.inetbanking.utilities;

import org.openqa.selenium.NoAlertPresentException;

import com.inetbanking.testCases.BaseClass;

public class HandleAlert extends BaseClass {
	
	public static boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}

}
