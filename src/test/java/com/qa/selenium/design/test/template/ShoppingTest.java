package com.qa.selenium.design.test.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.selenium.design.template.AmazonShoppingClass;
import com.qa.selenium.design.template.EbayShoppingClass;
import com.qa.selenium.design.template.ShoppingTemplate;
import com.qa.selenium.design.test.BaseTest;

public class ShoppingTest extends BaseTest
{
	
	
	@Test(dataProvider = "testData")
	public void test(ShoppingTemplate template)
	{
		template.shop();
	}
	
	@DataProvider
	public Object[] testData()
	{
		return new Object[]{
				new AmazonShoppingClass(driver, "Apple iphone 5s"),
				new EbayShoppingClass(driver, "Samesung galxy s5")
				
		};
	}
}
