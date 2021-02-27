package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	
	@FindBy(how = How.NAME, using ="cusid")
	@CacheLookup
	WebElement txtCustomerID;
	
	@FindBy(how = How.NAME, using ="AccSubmit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.NAME, using ="res")
	@CacheLookup
	WebElement btnReset;
	
	
	
	public void clickEditCustomer()
	{
		lnkEditCustomer.click();
	}
	
	public void custID(String ID)
	{
		txtCustomerID.sendKeys(ID);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}
}
