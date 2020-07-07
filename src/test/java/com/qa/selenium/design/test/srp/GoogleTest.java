package com.qa.selenium.design.test.srp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.selenium.design.srp.main.GoogleMainPage;
import com.qa.selenium.design.srp.result.GoogleResultPage;
import com.qa.selenium.design.test.BaseTest;

public class GoogleTest extends BaseTest
{
	private GoogleMainPage googleMainPage;
	private GoogleResultPage googleResultPage;
	
	@BeforeTest
	public void setUpPage()
	{
		googleMainPage = new GoogleMainPage(driver);
		googleResultPage = new GoogleResultPage(driver);
	}
	
	@Test(dataProvider="testData")
	public void googleWorkFlow(String keyWord, int index)
	{
		googleMainPage.goTo();		
		Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());
		
		googleMainPage.getSearchWidget().enterKeyWord(keyWord);
		Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());
		
		googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
		Assert.assertTrue(googleResultPage.getNavBar().isDisplayed());
		
		googleResultPage.getSearchWidget().enterKeyWord(keyWord);
		Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());
		
		googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);
		googleResultPage.getNavBar().goToNews();
	}
	
	@DataProvider(name = "testData")
	public Object[][] testData()
	{
		return new Object[][]{
				
				{"Selenium",3,},
				{"Docker",2}
		};
	}
	
	
}
