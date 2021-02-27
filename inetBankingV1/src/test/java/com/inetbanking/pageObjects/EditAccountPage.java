package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
	
	WebDriver ldriver;
	public EditAccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Edit Account')]")
	@CacheLookup
	WebElement lnkEditAccount;
	
	@FindBy(how = How.NAME, using ="accountno")
	@CacheLookup
	WebElement txtAccountNo;
	
	@FindBy(how = How.NAME, using ="AccSubmit")
	@CacheLookup
	WebElement btnAccountSubmit;
	
	public void clickEditAccount()
	{
		lnkEditAccount.click();
	}
	
	
	public void AccountNo(String accNo)
	{
		txtAccountNo.clear();
		txtAccountNo.sendKeys(accNo);
	}
	
	public void ClickSubmit()
	{
		btnAccountSubmit.click();
	}
}
