package com.qa.selenium.design.strategy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardOption implements PaymentOption
{
	
	@FindBy(id="cc")
	private WebElement cc;
	
	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(id="cvv")
	private WebElement cvv;	
	

	@Override
	public void pay(Map<String, String> paymentDetails)
	{
		this.cc.sendKeys(paymentDetails.get("cc"));
		this.year.sendKeys(paymentDetails.get("year"));
		this.cvv.sendKeys(paymentDetails.get("cvv"));
		
	}

}
