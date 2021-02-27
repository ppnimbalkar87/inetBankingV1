package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditAccountPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.HandleAlert;

public class TC_EditAccountTest_005 extends BaseClass{
	
	@Test
	public void editAccount() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000); 
		
		EditAccountPage editAcc=new EditAccountPage(driver);
		
		editAcc.clickEditAccount();
		
		logger.info("Providing Account No.........");
		
		editAcc.AccountNo("3");
		editAcc.ClickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started.............");
		
		if(HandleAlert.isAlertPresent()==true)
		{
			driver.switchTo().alert();
			String alertmsg=driver.switchTo().alert().getText();
			if(alertmsg.contains("You are not authorize to edit this Account!!"))
			{
				driver.switchTo().alert().accept();//close alert
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
			else if(alertmsg.contains("Account does not exist"))
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
			captureScreen(driver,"EditAccount");
			Assert.assertTrue(false);
		}
	}

}
