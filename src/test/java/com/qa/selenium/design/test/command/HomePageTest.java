package com.qa.selenium.design.test.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.selenium.design.command.HomePage;
import com.qa.selenium.design.test.BaseTest;

public class HomePageTest extends BaseTest
{
	HomePage homePage;
	
	@BeforeTest
	public void setUpHomePage()
	{
		this.homePage = new HomePage(driver);
	}
	
	@Test
	public void homePageTest()
	{
		this.homePage.goTo();
		
		/*List<ElementValidator> ev = this.homePage.getElementValidators();		
		for(ElementValidator e : ev)
		{
			boolean result = e.validate();
			Assert.assertTrue(result);
		}*/
		
		this.homePage.getElementValidators().stream().parallel()
			.map(ev -> ev.validate())
			.forEach(val -> Assert.assertTrue(val));
	}
}
