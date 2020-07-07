package com.qa.selenium.design.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//Single Responsibility pattern
public abstract class AbstractComponent
{	
	protected WebDriverWait wait;	
	@SuppressWarnings("deprecation")
	protected AbstractComponent(final WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30); 
	}
	
	public abstract boolean isDisplayed();
}
