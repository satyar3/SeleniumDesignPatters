package com.qa.selenium.design.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentsReal implements IOrderComponent
{
	@FindBy(id="buy")
	private WebElement buyNow;
	
	@FindBy(id="ordernumber")
	private WebElement orderNumber;
	
	public OrderComponentsReal(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public String placeOrder()
	{
		buyNow.click();
		return this.orderNumber.getText();
	}
}
