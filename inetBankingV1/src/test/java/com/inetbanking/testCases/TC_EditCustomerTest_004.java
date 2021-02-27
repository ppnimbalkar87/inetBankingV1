package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.HandleAlert;

public class TC_EditCustomerTest_004 extends BaseClass
{
	@Test
	public void editCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000); 
		EditCustomerPage editCust=new EditCustomerPage(driver);
		editCust.clickEditCustomer();
		
		logger.info("Providing Customer ID");
		
		editCust.custID("3");
		editCust.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation Started..........");
		
		
		if(HandleAlert.isAlertPresent()==true)
		{
			driver.switchTo().alert();
			String alertmsg=driver.switchTo().alert().getText();
			if(alertmsg.contains("You are not authorize to edit this customer!!"))
			{
				driver.switchTo().alert().accept();//close alert
//				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
			else if(alertmsg.contains("Customer does not exist!!"))
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
			logger.info("test case Passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"EditCustomer");
			Assert.assertTrue(false);
		}
		
	}

	
}
