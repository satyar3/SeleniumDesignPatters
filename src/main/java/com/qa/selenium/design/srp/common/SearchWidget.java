package com.qa.selenium.design.srp.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.selenium.design.srp.AbstractComponent;

public class SearchWidget extends AbstractComponent
{
	
	public SearchWidget(final WebDriver driver)
	{
		super(driver);
	}

	@FindBy(name = "q")
	private WebElement searchBox;

	public void enterKeyWord(String keyWord)
	{
		this.searchBox.clear();
		
		char[] chars = keyWord.toCharArray();
		for (char c : chars)
		{
			Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
			this.searchBox.sendKeys(c+"");
		}
	}
	
	@Override
	public boolean isDisplayed()
	{
		return wait.until(driver -> searchBox.isDisplayed());
	}

}
