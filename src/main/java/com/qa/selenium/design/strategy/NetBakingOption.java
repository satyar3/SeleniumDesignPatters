package com.qa.selenium.design.strategy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NetBakingOption implements PaymentOption
{
	
	@FindBy(id="bank")
	private WebElement bank;
	
	@FindBy(id="acc_number")
	private WebElement account;
	
	@FindBy(id="pin")
	private WebElement pin;	
	

	@Override
	public void pay(Map<String, String> paymentDetails)
	{
		Select selDropDown = new Select(bank);
		selDropDown.selectByValue(paymentDetails.get("bank"));
		this.account.sendKeys(paymentDetails.get("account"));
		this.pin.sendKeys(paymentDetails.get("pin"));		
	}

}
