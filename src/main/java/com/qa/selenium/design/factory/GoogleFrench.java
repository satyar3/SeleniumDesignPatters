package com.qa.selenium.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish
{

	public GoogleFrench(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(linkText="Français")
	private WebElement frechLink;
	
	@Override
	public void lunchSite()
	{
		this.driver.get("https://www.google.fr");
		this.frechLink.click();
		
	}
}
