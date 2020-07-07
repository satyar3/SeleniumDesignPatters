package com.qa.selenium.design.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.selenium.design.srp.AbstractComponent;

public class NavigationBar extends AbstractComponent
{
	
	public NavigationBar(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="hdtb")
	private WebElement navBar;
	
	@FindBy(linkText="News")
	private WebElement news;
	
	@FindBy(linkText="Images")
	private WebElement images;

	
	public void goToImages()
	{
		this.images.click();
	}
	
	public void goToNews()
	{
		this.news.click();
	}
	
	
	@Override
	public boolean isDisplayed()
	{
		return this.wait.until(driver -> navBar.isDisplayed());
	}
	
	

}
