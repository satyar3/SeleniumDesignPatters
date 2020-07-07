package com.qa.selenium.design.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.design.srp.common.SearchSuggestion;
import com.qa.selenium.design.srp.common.SearchWidget;

public class GoogleResultPage
{
	private SearchWidget searchWidget;
	private SearchSuggestion searchSuggestion;
	private NavigationBar navBar;
	
	public GoogleResultPage(final WebDriver driver)
	{
		this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
		this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
		this.navBar = PageFactory.initElements(driver, NavigationBar.class);
	}

	public SearchWidget getSearchWidget()
	{
		return searchWidget;
	}

	public SearchSuggestion getSearchSuggestion()
	{
		return searchSuggestion;
	}

	public NavigationBar getNavBar()
	{
		return navBar;
	}
}
