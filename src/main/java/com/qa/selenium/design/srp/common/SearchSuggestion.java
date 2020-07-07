package com.qa.selenium.design.srp.common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.selenium.design.srp.AbstractComponent;

public class SearchSuggestion extends AbstractComponent
{
	
	public SearchSuggestion(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(css="li.sbct")
	private List<WebElement> suggestions;
	
	
	public void clickSuggestionByIndex(int i)
	{
		this.suggestions.get(i-1).click();
	}
	
	
	@Override
	public boolean isDisplayed()
	{
		return this.wait.until(driver -> suggestions.size()>5);
	}
	
}
