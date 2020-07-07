package com.qa.selenium.design.test.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.selenium.design.factory.GoogleFactory;
import com.qa.selenium.design.factory.GooglePage;
import com.qa.selenium.design.test.BaseTest;

public class SearchTest extends BaseTest
{
	private GooglePage googlePage;
	
	@Test(dataProvider="testData")
	public void searchTest(String language, String keyword)
	{
		googlePage = GoogleFactory.get(language, driver);
		
		this.googlePage.lunchSite();
		this.googlePage.search(keyword);
		int resultCount = this.googlePage.getearchResultCount();
		
		System.out.println("Result Count :: "+resultCount);
	}
	
	
	@DataProvider
	public Object[][] testData()
	{
		return new Object[][]{
			{"english", "selenium"},
			{"french", "selenium"},
			{"arabic", "selenium"},
		};
	}
}
