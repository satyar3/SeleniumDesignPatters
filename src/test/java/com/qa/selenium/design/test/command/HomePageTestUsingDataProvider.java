package com.qa.selenium.design.test.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.selenium.design.command.ElementValidator;
import com.qa.selenium.design.command.HomePage;
import com.qa.selenium.design.test.BaseTest;

public class HomePageTestUsingDataProvider extends BaseTest
{
	HomePage homePage;
	
	@BeforeTest
	public void setUpHomePage()
	{
		this.homePage = new HomePage(driver);
	}
	
	@Test
	public void launchSite()
	{
		this.homePage.goTo();
	}
	
	@Test(dependsOnMethods = "launchSite", dataProvider = "testData")
	public void homePageTest(ElementValidator el)
	{
		Assert.assertTrue(el.validate());
	}
	
	@DataProvider
	public Object[] testData()
	{
			return homePage.getElementValidators().toArray();
	}
}
