package com.qa.selenium.design.template;

public abstract class ShoppingTemplate
{
	public abstract void lunchSite();
	public abstract void searchForProduct();
	public abstract void selectProduct();
	public abstract void checkPrice();
	
	public void shop()
	{
		lunchSite();
		searchForProduct();
		selectProduct();
		checkPrice();
	}
}
