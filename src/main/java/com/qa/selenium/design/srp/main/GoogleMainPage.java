package com.qa.selenium.design.srp.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.design.srp.common.SearchSuggestion;
import com.qa.selenium.design.srp.common.SearchWidget;

public class GoogleMainPage
{
	private WebDriver driver;
	private SearchWidget searchWideget;
	private SearchSuggestion searchSuggestion;
	
	public GoogleMainPage(final WebDriver driver)
	{
		this.driver = driver;
		this.searchWideget = PageFactory.initElements(driver, SearchWidget.class);
		this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
	}
	
	public void goTo()
	{
		this.driver.get("https://www.google.com");
	}
	
	public SearchWidget getSearchWidget()
	{
		return searchWideget;
	}
	
	public SearchSuggestion getSearchSuggestion()
	{
		return searchSuggestion;
	}
	
	
}
