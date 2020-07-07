package com.qa.selenium.design.factory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

class GoogleEnglish extends GooglePage
{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public GoogleEnglish(final WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	protected WebElement searchBox;
	
	@FindBy(name="btnK")
	protected WebElement searchButton;
	

	@FindBy(css="div.rc")
	protected List<WebElement> searchResults;

	@Override
	public void lunchSite()
	{
		this.driver.get("https://www.google.com");		
	}

	@Override
	public void search(String keyword)
	{
		char[] chars = keyword.toCharArray();
		for (char c : chars)
		{
			Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
			this.searchBox.sendKeys(c+"");
		}
		this.wait.until(driver -> searchButton.isDisplayed());
		this.searchButton.click();
		
	}

	@Override
	public int getearchResultCount()
	{
		this.wait.until(driver -> searchResults.size()>0);
		return this.searchResults.size();
	}

}
